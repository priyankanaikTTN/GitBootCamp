package com.ttn.linksharing

import constants.Constants
import enums.Visibility


class Topic {


    String topicname
    Date dateCreated
    Date lastUpdated
    Visibility visibility
    User createdBy

static namedQueries =
        {
            recentTopics{Date date ->
                gt 'dateCreated', date-10
            }
        }

    static hasMany = [subscriptions: Subscription,
                      resources    : Resource]
    static constraints = {

//        topicname(nullable: false,unique:['createdBy'],blank: false)
        topicname unique: 'createdBy'
        visibility(inList: Visibility.values().toList())
        createdBy(nullable: false)

    }
    def afterInsert() {
        Topic.withNewSession {
            Subscription subscription = new Subscription(
                    user: this.createdBy,
                    topic: this,
                    seriousness: Constants.SERIOUSNESS)
            if (subscription.validate() && subscription.save(flush: true)) {
                log.info "${subscription}-> ${this.createdBy} subscribed for ${this}"
            } else {
                log.error "Subscription does not occurs--- ${subscription.errors.allErrors}"
            }
        }
    }
    @Override
    public String toString() {
        return topicname + ", " + createdBy

    }
}
