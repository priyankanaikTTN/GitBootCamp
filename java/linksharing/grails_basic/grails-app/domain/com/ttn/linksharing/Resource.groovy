package com.ttn.linksharing

import co.ResourceSearchCO
import enums.Visibility
import vo.PostVO
import vo.RatingInfoVO


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

    static transients = ['ratingInfo']

    static constraints = {
        description(blank: false)
    }


    static namedQueries = {
        search { ResourceSearchCO resourceSearchCO ->
            if (resourceSearchCO.q) {
                if (resourceSearchCO.topicID) {
                     eq('topic.id', resourceSearchCO.topicID)
                }
                if (resourceSearchCO.visibility && resourceSearchCO.visibility == Visibility.PUBLIC) {
                    'topic' {
                        eq('visibility', Visibility.PUBLIC)
                    }
                }
                ilike('description', "%${resourceSearchCO.q}%")
            }

        }
    }




    RatingInfoVO getRatingInfo() {
        List result = ResourceRating.createCriteria().get {
            projections {
                count('id', 'totalVotes')
                avg('score')
                sum('score')
            }
            eq('resource', this)
            order('totalVotes', 'desc')
        }
        new RatingInfoVO(totalVotes: result[0], averageScore: result[1], totalScore: result[2])
    }



    static List<PostVO> getTopPosts() {
        List<PostVO> topPosts = []
        ResourceRating.createCriteria().list(max: 5) {
            projections {
                property('resource.id')

                'resource'{
                    property('description')
                    property('url')
                    property('filePath')
                    'topic' {
                        property('id')
                        property('topicname')
                        eq('visibility', enums.Visibility.PUBLIC)
                    }
                    'createdBy' {
                        property('id')
                        property('username')
                        property('firstname')
                        property('lastname')
                        property('photo')
                    }
                    property('lastUpdated')
                }
            }
            groupProperty('resource.id')
            count('id', 'totalVotes')
            order('totalVotes', 'desc')
        }?.each {
            topPosts.add(new PostVO(resourceID: it[0], description: it[1], url: it[2], filePath: it[3], topicID:
                    it[4], topicName: it[5], userID: it[6], userName: it[7], userFirstName: it[8], userLastName: it[9],
                    userPhoto: it[10], isRead: "", resourceRating: 0, postDate: it[11]))
        }

        return topPosts
    }
    String toString() {
        return "${description}"
    }

}

