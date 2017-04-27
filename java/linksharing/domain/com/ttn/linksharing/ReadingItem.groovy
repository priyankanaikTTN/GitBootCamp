package com.ttn.linksharing

class ReadingItem {

   //Resource resource
    //User user
    Boolean isRead


    static  belongsTo = [user:User,resource:Resource]


    static constraints = {
        resource(unique: ['user'])
    }

    String toString() {
        return "${user} read the ${resource}: ${isRead}"
    }

}
