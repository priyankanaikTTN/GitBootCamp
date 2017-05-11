package co

import com.ttn.linksharing.User
import enums.Visibility
import grails.validation.Validateable

/**
 * Created by priyanka on 7/5/17.
 */
class ResourceSearchCO extends SearchCO implements Validateable {

    Long topicID
    Visibility visibility



}
