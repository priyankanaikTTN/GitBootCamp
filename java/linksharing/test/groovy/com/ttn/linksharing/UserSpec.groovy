package com.ttn.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test_user"() {

        setup:
        User user = new User(firstname:fname ,lastname:lname ,active:activate ,admin:admn ,password:pass ,username:uname
                ,email:emailid ,photo: null)

        when:
        Boolean isvalid = user.validate()

        then:
        isvalid==valid

        where:
        uname                | fname       | lname   | activate | admn | pass       | emailid             | valid
        "naik_priyanka"      | "priyanka"  | "naik"  |  true    | true | "priya123" | "priyan@gmail.com"  | true
        ""                   | "priyanka"  | "naik"  |  null    | null | "priya123" | "priyanka@gmail.com"| false
        "naik_priyanka"      | null        | "naik"  |  null    | null | null       | "priya"             | false


    }

    void "check_name_and_email_uniqueness"()
    {


        setup:
        String email = "puneet@tothenew.com"
        String password = 'password'

        User user = new User(firstname: "puneet" ,lastname: "arora",email:email,password: password,username: "uname")
        when:
        user.save()


        then:
        user.count() == 1

        when:
        User newUser = new User(firstname: "Neha", lastname: "Gupta", email: email, password: password,username: "uname")
        newUser.save()

        then:
        User.count() == 1
        newUser.errors.allErrors.size() == 2
        newUser.errors.getFieldErrorCount('email') == 1
        newUser.errors.getFieldErrorCount('username')==1


    }

    @Unroll
    def "fullName"() {
        given:
        User user = new User(firstname: firstName, lastname: lastName)

        expect:
        result == user.getFullname()

        where:
        firstName   | lastName   | result
        ""          | ""         | ""
        "Priyanka"  | ""         | "Priyanka"
        ""          | "Naik"     | "Naik"
        "Priyanka"  | "Naik"     | "Priyanka Naik"
        null        | "Naik"     | "Naik"
        "Priyanka"  | null       | "Priyanka"
        null        | null       | ""
    }

}
