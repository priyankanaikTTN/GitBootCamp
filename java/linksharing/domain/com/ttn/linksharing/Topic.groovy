package com.ttn.linksharing

import enums.Visibility


class Topic {


    String topicname
    Date dateCreated
    Date lastUpdated
    Visibility visibility
    User createdBy



   static  hasMany = [subscriptions:Subscription,
                      resources:Resource]
    static constraints = {

        topicname(nullable: false,unique:['createdBy'],blank: false)

        visibility(inList: Visibility.values().toList())
         createdBy(nullable: false)

    }


    @Override
    public String toString() {
        return topicname + ", " + createdBy

    }
}
