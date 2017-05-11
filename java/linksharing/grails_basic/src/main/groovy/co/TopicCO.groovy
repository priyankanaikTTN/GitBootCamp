package co

import com.ttn.linksharing.User
import enums.Visibility
import grails.validation.Validateable

/**
 * Created by priyanka on 11/5/17.
 */
class TopicCO implements Validateable {
    String topicname
    Visibility visibility
    User createdBy

    static constraints = {

        topicname(nullable: false,unique:['createdBy'],blank: false)

        topicname(unique: 'createdBy')

        visibility(inList: Visibility.values().toList())
        createdBy(nullable: false)

    }
}
