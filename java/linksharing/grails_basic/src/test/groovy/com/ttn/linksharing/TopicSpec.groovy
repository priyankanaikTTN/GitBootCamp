package com.ttn.linksharing

import enums.Visibility
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

import java.security.PublicKey

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Topic)
@Mock([User, Subscription])
class TopicSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect: "fix me"
        true == true
    }

    @Unroll("Topic Constraints ----- #sno")
    def "topicConstraints"() {
        given:
        Topic topicObj = new Topic(topicname: topicName, createdBy: creator, visibility: visibility)

        when:
        boolean result = topicObj.validate()

        then:
        result == valid

        where:
        sno | topicName | creator    | visibility         | valid
        1   | "grails"  | new User() | Visibility.PRIVATE | true
        2   | " "       | new User() | Visibility.PRIVATE | false
        3   | null      | new User() | Visibility.PRIVATE | false
        4   | "grails"  | null       | Visibility.PRIVATE | false
        5   | "grails"  | new User() | null               | false
    }

    @Unroll
    def "topicUserUniqueness"() {
        given:
        String topicName = "grails"

        User creator1 = new User(username: "priyanka",firstname: "Priynka", lastname: "Naik", email: "pri@ttn.com", password: "3411312")

        User creator2 = new User(username: "sargam",firstname: "Sargam", lastname: "SAchdeva", email:  "sargam@ttn.com", password: "3411312")

        creator1.save(validate: false)

        creator2.save(validate: false)
                Visibility visibility = Visibility.PRIVATE

        Topic topicObj

        when:
        topicObj = new Topic(topicname: topicName, createdBy: creator1, visibility: visibility)
        topicObj.save(flush: true)

        then:
        Topic.count() == 1

        when:
        topicObj = new Topic(topicname: topicName, createdBy: creator1, visibility: visibility)
        topicObj.save(flush : true)

        then:
        Topic.count() == 1
        topicObj.errors.allErrors.size() == 1
        topicObj.errors.getFieldErrorCount('topicname') == 1


        when:
        topicObj = new Topic(topicname: topicName, createdBy: creator2, visibility: visibility)
        topicObj.save()
        println("<<<<<<<<<<<<<<<<<<<<<<<<<${topicObj.errors.allErrors}")

        then:
        Topic.count() == 2
    }

    def "tostringCheck"() {
        given:
        User user = new User(username: 'priyanka')
        Topic topic = new Topic(topicname: name, createdBy: user)

        when:
        String topicName = topic.toString()

        then:
        topicName == result

        where:
        name            | result
        "testTopicName" | "testTopicName, priyanka"
    }
}
