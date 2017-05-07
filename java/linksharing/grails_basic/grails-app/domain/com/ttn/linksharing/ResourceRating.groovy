package com.ttn.linksharing

class ResourceRating {


   Resource resource
    User user
    Integer score

    static belongsTo = [user    : User,
                        resource: Resource]

    static constraints = {
        score(min: 1, max: 5)
        resource(unique: ['user'])
    }

    String toString() {
        return "${user} rated ${resource} by ${score}"
    }
}
