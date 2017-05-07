package com.ttn.linksharing

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LoginController)
@Mock(User)
class LoginControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }

    def "indexTest"()
    {

        given :
        session['user'] = new User()

        when:
        controller.index()

        then:
        response.forwardedUrl=='/user/index'


    }

    def "loginHandlerTest"()
    {

        given:
        User newUser = new User(firstname: "Neha", lastname: "Gupta", email: "neha.gupta@tothenew.com",
                password: "neha123",username: "UserNeha", active: true)
        newUser.save(flush:true)



        when:
        controller.loginHandler(newUser.username,newUser.password)

        then:
        response.redirectedUrl=='/login/index'

        when:
        controller.loginHandler("uname","password")

        then:
        response.text == "User not found"




    }


    def "loginHandlerTestUserIsActive"() {
        setup:
        User user = new User(firstname: "Arush", lastname: "Malik" , username:  "arush_malik",
                email:"arush.malik@tothenew.com",password: "arush123", active: false)

        user.save(flush:true)

        when:
        controller.loginHandler(user.username, user.password)

        then:
        response.text == "Your account is not active"
    }

    def "LogoutTest"() {
        when:
        controller.logout()

        then:
        session.user == null
        response.forwardedUrl == "/login/index"
    }


}
