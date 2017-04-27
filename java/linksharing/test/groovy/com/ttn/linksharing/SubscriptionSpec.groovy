package com.ttn.linksharing

import enums.Seriousness
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Subscription)
class SubscriptionSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }

     @Unroll
    def "validatingSubscription"() {
        given:
        Subscription subscription = new Subscription(topic: topic, user: user, seriousness: seriousness)

        when:
        Boolean valid = subscription.validate()

        then:
        valid == result

        where:
        topic       | user       | seriousness        | result
        new Topic() | new User() | Seriousness.CASUAL | true
        null        | new User() | Seriousness.CASUAL | false
        new Topic() | null       | Seriousness.CASUAL | false
        new Topic() | new User() | null               | false
    }

    def "validatingDuplicateSubscription"() {

        given:
        Topic topic = new Topic()
        User user = new User()
        Seriousness seriousness = Seriousness.VERY_SERIOUS
        Subscription subscription = new Subscription(topic: topic, user: user, seriousness: seriousness)

        when:
        subscription.save()

        then:
        Subscription.count() == 1

        when:
        subscription = new Subscription(topic: topic, user: user, seriousness: seriousness)
        subscription.save()

        then:
        Subscription.count() == 1
        subscription.errors.allErrors.size() == 1
        subscription.errors.getFieldErrorCount('topic') == 1
    }

    def "tostringCheck"() {

        given:
        User user = new User(username: userName)
        Topic topic = new Topic(topicname: topicName)
        Subscription subscription = new Subscription(topic: topic, user: user, seriousness: Seriousness.CASUAL)

        when:
        result == subscription.toString()

        then:
        noExceptionThrown()

        where:
        userName          | topicName | result
        "priyanka.naik"   | "grails"  | "priyanka.naik subscribed grails"
    }
}
