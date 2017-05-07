package com.ttn.linksharing

import constants.Constants
import enums.Seriousness
import enums.Visibility
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(SubscriptionController)
@Mock([User, Topic, Subscription])
class SubscriptionControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }

    def "SubscriptionDeleteTest"() {
        setup:
        User user1 = new User(username: "aksah").save(validate: false)

        User user2 = new User(username: "preeti").save(validate: false)

        Topic topic = new Topic(createdBy: user1,topicname: 'some_topic',visibility: Constants.VISIBILITY).save(validate: false)

        Subscription subscription = new Subscription(user: user1, topic: topic, seriousness: Seriousness.CASUAL)


        subscription.save(validate: false)

        when:
        session['user']=user1
        controller.delete(topic.id)

        then:
        response.text == "subscription deleted"




    }

    def "SubscriptionNotDeletedTest"()
    {

        setup:
        User user1 = new User(username: "aksah").save(validate: false)

        User user2 = new User(username: "preeti").save(validate: false)

        Topic topic = new Topic(createdBy: user1,topicname: 'some_topic',visibility: Constants.VISIBILITY).save(validate: false)

        Subscription subscription = new Subscription(user: user1, topic: topic, seriousness: Seriousness.CASUAL)


        subscription.save(validate: false)

        when:
        session['user']=user2
        controller.delete(topic.id)

        then:
        response.text =="could not delete subscription"
    }

    def "SubscriptionSaveTest"() {
        setup:
        User user1 = new User(username: 'preeti_sisodhia').save(validate:false)



        User user2 = new User(username: 'kanishka_sikka').save(validate:false)

        Topic topic = new Topic(topicname:'topic_save', createdBy: user1, visibility: Visibility.PUBLIC).save(validate:false)






        when:
        session['user'] = user2
        controller.save(topic.id, 'serious')


        then:
        response.text == "User subscribed to ${topic.topicname}"

    }

    def "SubscriptionNotSaveTest"() {
        setup:
        User user1 = new User(username: 'preeti_sisodhia').save(validate:false)



        User user2 = new User(username: 'kanishka_sikka').save(validate:false)

        Topic topic = new Topic(topicname:'topic_save', createdBy: user1, visibility: Visibility.PRIVATE).save(validate:false)






        when:
        session['user'] = user2
        controller.save(topic.id, 'serious')


        then:
        response.text == "User cannot subscribe as Topic is private"

    }


    def "SubscriptionNotUpdateTest"() {
        setup:
        User user = new User().save(validate: false)

        Topic topic = new Topic().save(validate: false)

        Subscription subscription = new Subscription(user: user, topic: topic,seriousness:Seriousness.CASUAL)

        session['user']=user
        subscription.save(validate: false)

        when:
        controller.update(topic.id, "CASUAL")

        then:
        response.text =="Subscription not found"

        /*and:

        when:
        controller.update(id, seriousness)

        then:
        response.text == result

        where:
        id | seriousness | result
        1  | "serious"   | "Subscription Updated"
        2  | "casual"    | "Subscription Updated"*/
    }

    def "SubscriptionUpdateTest"() {
        setup:
        User user = new User().save(validate: false)

        Topic topic = new Topic().save(validate: false)

        Subscription subscription = new Subscription(user: user, topic: topic,seriousness:Seriousness.CASUAL)

        session['user']=user
        subscription.save(validate: false)

        when:
        controller.update(topic.id, "SERIOUS")

        then:
        response.text =="Seriousness updated"

           }


}
