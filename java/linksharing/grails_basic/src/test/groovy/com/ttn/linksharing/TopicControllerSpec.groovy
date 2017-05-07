package com.ttn.linksharing

import constants.Constants
import enums.Visibility
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(TopicController)
@Mock([User, Topic, Subscription])
class TopicControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == true
    }

     @Unroll
    def "CheckTopicDelete"()
    {

        /*when:
        User user1 = new User(username:  "priyanka")
        User user2 = new User(username:  "sargma")
        Topic topic1 = new Topic(topicname: 'groovy_grails', visibility:Constants.VISIBILITY, createdBy: user1)
        topic1.save(flush:true)
        session['user']=user2
        controller.delete(topic1.id)
        then:
        response.text == "could not delete topic"


        and:*/

        when:
        session['user'] = user
        Topic topic = new Topic(topicname: topicName,visibility:visibility,createdBy: user)
        topic.save(flush:true)
        controller.delete(topic.id)
        then:
        response.text == result

        where:
        user                           | topicName | visibility | result
        new User(username: "priyanka") | "grails"  | "PUBLIC"   | "topic deleted"



    }
    def "CheckTopicSave"() {
        when:
        session['user'] = user
        controller.save(topicName, visibility)

        then:
        response.text == result

        where:
        user                           | topicName | visibility | result
        new User(username: "priyanka") | "grails"  | "PUBLIC"   | "Topic saved successfully"
        new User(username: "priyanka") | "grails"  | null       | "Topic cannot be saved"
    }

    def "CheckTopicShow"() {
        setup:
        User user = new User(username: "user5", active: true, password: Constants.PASSWORD
            , firstname: "Name", lastname: "Lname", email: "user5@ttnd.com")

        user.save()

        Topic topic = new Topic(topicname:'groovy', visibility: visible, createdBy: user)

        session['user'] = user

        topic.save()

        when:
        println("topic-id :"+topic.id)
        controller.show(topic.id)


        then:
        response.text == result

        where:
        visible            | result
        Visibility.PUBLIC  | "success public"
        Visibility.PRIVATE | "success private"
    }

    def "CheckTopicShow_User_not_subscribed_to_private_topic"() {
        setup:
        User user = new User(username: "user5", active: true, password: Constants.PASSWORD,confirmPassword: Constants.PASSWORD, firstname: "Name", lastname: "Lname", email: "user5@ttnd.com")

        User user1 = new User(username: "user6", active: true, password: Constants.PASSWORD,confirmPassword: Constants.PASSWORD,firstname: "Name", lastname: "Lname", email: "user6@ttnd.com")

        Topic topic = new Topic(topicname: 'groovy', visibility: Visibility.PRIVATE, createdBy: user)

        user.save(flush: true)
        user1.save(flush:true)
        session['user']= user1
        topic.save(flush: true)

        when:
        controller.show(topic.id)

        then:
        response.redirectedUrl == "/login/index"
    }
}
