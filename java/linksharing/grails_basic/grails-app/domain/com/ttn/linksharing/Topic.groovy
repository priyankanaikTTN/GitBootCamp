package com.ttn.linksharing

import constants.Constants
import enums.Visibility
import vo.PostVO
import vo.TopicVO


class Topic {


    String topicname
    Date dateCreated
    Date lastUpdated
    Visibility visibility
    User createdBy

    static mapping = {
        sort "topicname"
    }


static namedQueries =
        {
            recentTopics{Date date ->
                gt 'dateCreated', date-10
            }
        }

    static hasMany = [subscriptions: Subscription,
                      resources    : Resource]
    static constraints = {

        topicname(nullable: false,unique:['createdBy'],blank: false)

        topicname(unique: 'createdBy')

        visibility(inList: Visibility.values().toList())
        createdBy(nullable: false)

    }
    def afterInsert() {
       Topic.withNewSession {
            Subscription subscription = new Subscription(
                    user: this.createdBy,
                    topic: this,
                    seriousness: Constants.SERIOUSNESS)
            if (subscription.validate() && subscription.save(flush:true)) {
                log.info "${subscription}-> ${this.createdBy} subscribed for ${this}"
            } else {
                log.error "Subscription does not occurs--- ${subscription.errors.allErrors}"
            }
        }
    }

    static List<PostVO> getTopPosts() {

    }


    static List<TopicVO> getTrendingTopics() {
        List<TopicVO> trendingTopics = []
        Resource.createCriteria().list {
            projections {
                createAlias('topic', 't')
                groupProperty('t.id')
                property('t.topicname')
                property('t.visibility')
                count('t.id', 'topicCount')
                property('t.createdBy')
            }
            order('topicCount', 'desc')
            order('t.topicname', 'asc')
            maxResults(5)
        }?.each {
            trendingTopics.add(new TopicVO(id: it[0], name: it[1], visibility: it[2], count: it[3], createdBy: it[4]))
        }
        return trendingTopics
    }
    @Override
    public String toString() {
        return topicname + ", " + createdBy

    }
}
