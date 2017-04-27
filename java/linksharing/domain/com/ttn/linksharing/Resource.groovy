package com.ttn.linksharing

abstract class Resource {

    String description
    User createdBy
    Date dateCreated
    Date lastUpdated

    static belongsTo = [topic:Topic]

    static hasMany = [ratings:ResourceRating,
                      readingItems: ReadingItem
                      ]

    static mapping = {
        description(type: 'text')
    }



    static constraints = {
        description(blank: false)
    }

    String toString() {
        return "${description}"
    }

}
