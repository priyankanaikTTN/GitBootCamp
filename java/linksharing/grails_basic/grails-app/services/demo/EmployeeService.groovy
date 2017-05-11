package demo

import com.ttn.linksharing.User
import grails.transaction.Transactional

@Transactional
class EmployeeService {

    def serviceMethod() {

    }

    def listUser={
        List<User> users = User.createCriteria().list() {

            or
                    {
                        eq("firstname", "Priyanka")
                    }
        }

        return users
    }
}
