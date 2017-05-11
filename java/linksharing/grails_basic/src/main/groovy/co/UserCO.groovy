package co

/**
 * Created by priyanka on 10/5/17.
 */


import grails.validation.Validateable


class UserCO implements Validateable{
    String userName
    String password
    String firstName
    String lastName
    String email
    byte[] photo
    Boolean admin = false
    Boolean active = true
    String confirmPassword

    static constraints = {
        email(unique: true, blank: false, email: true)
        password(blank: false, minSize: 5)
        firstName(blank: false)
        lastName(blank: false)
        userName(blank: false, unique: true)
        photo(nullable: true)
        confirmPassword(bindable: true, nullable: true, blank: true, validator: { val, obj ->
            if (obj.password != val || !val || !obj.password) {
                return 'password.do.not.match.confirm.password'
            }
        })
    }
}
