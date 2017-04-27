package com.ttn.linksharing

import com.sun.org.apache.xpath.internal.operations.Bool

class User {



    String email
    String username
    String password
    String firstname
    String lastname
    Byte[] photo
    Boolean admin
    Boolean active
    Date dateCreated
    Date lastUpdated

    static  hasMany = [topic:Topic,
                       subscriptions:Subscription,
                       readingItems:ReadingItem,
                        resources: Resource,
                         resourceRatings : ResourceRating]

    static transients = ['fullName']

    static  mapping = {

        photo(sqlType: 'longblob')
    }

    static constraints = {

        email(unique: true, blank:false, email: true, nullable: false)

        firstname(blank: false,nullable: false)

        lastname(blank: false,nullable: false)

        username(blank: false, nullable: false,unique: true)

        password(nullable: false, blank: false,minSize: 5)

        photo(nullable: true)

        admin(nullable: true)

        active(nullable: true)


    }

    String getFullname() {
        [this.firstname, this.lastname].findAll { it }.join(' ')
    }


    @Override
    public String toString() {
        return username
    }
}
