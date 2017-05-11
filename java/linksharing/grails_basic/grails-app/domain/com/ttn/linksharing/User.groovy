package com.ttn.linksharing

import co.SearchCO
import com.sun.org.apache.xpath.internal.operations.Bool
import vo.TopicVO

class User {



    String email
    String username
    String password
    String firstname
    String lastname
    String confirmPassword
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


    static transients = ['fullName','confirmPassword']

    static  mapping = {

        sort id: 'desc'

        photo(sqlType: 'longblob')
    }

    static constraints = {

        confirmPassword(nullable: true,blank: true)

        email(unique: true, blank:false, email: true, nullable: false)

        firstname(blank: false,nullable: false)

        lastname(blank: false,nullable: false)

        username(blank: false, nullable: false,unique: true)

        password(nullable: false, blank: false,minSize: 5)

        confirmPassword(   bindable:true,

                validator: { password1, obj ->
                    def password2 = obj.password
                  password2 == password1 ? true : false

                })

        photo(nullable: true)

        admin(nullable: true)

        active(nullable: true)


    }

    String getFullname() {
        [this.firstname, this.lastname].findAll { it }.join(' ')
    }

    List<Topic> getSubscribedTopics() {

        List<TopicVO> topicNameList = Subscription.createCriteria().list {
            projections {
                'topic' {

                    property('topicname')

                    'createdBy' {

                        property('username')

                    }

                }
            }
            eq('user.id', id)
        }.collect{ "${it[0]} by ${it[1]}"}

        return topicNameList
    }

     List <ReadingItem> getUnReadResources(SearchCO searchCO)
     {
         List<ReadingItem> readinItems
         if(searchCO.q)
         {
             readinItems  =ReadingItem.createCriteria().list(max:searchCO.max,offset:searchCO.offset) {

                 eq('user', this)
                 eq('isRead', false)
                 ilike('resource.description',searchCO.q)
             }

         }
         return readinItems

     }

    @Override
    public String toString() {
        return username
    }
}
