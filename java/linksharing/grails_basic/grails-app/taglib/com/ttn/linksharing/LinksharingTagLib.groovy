package com.ttn.linksharing

import vo.PostVO
import vo.TopicVO

class LinksharingTagLib {
    static defaultEncodeAs = "raw"

    static namespace = "ls"
    def isRead = { attrs, body ->
        User user = session.user
        if (user) {
            Resource resource = attrs.resource
            if (resource) {
                Integer count = ReadingItem.countByResourceAndIsReadAndUser(resource, true, user)
                if (count) {
                    out << "<a href='${createLink(controller: 'readingItem', action: 'toggleIsRead', id: resource.id)}'>Mark as Un Read</a> "
                } else {
                    out << "<a href='${createLink(controller: 'readingItem', action: 'toggleIsRead', id: resource.id)}'>Mark as Read</a> "
                }
            }
        }
    }

    def trendingTopics ={

       List<TopicVO> topicVOList = Topic.getTrendingTopics()




    }

    def recentShares ={

      List<PostVO> recentPostList =Resource.recentShares()


       out<< render(template: "/templates/recentShares",  model: [recentPostList: recentPostList])    }

    def topPosts ={

        List<PostVO> postVOList = Resource.getTopPosts()

        out<< render(template: "/templates/topPosts", model: [topPostList: postVOList])

    }

    def showSubscribedTopics = {
        User user = session.user


        if (user) {
            out << "${g.select(class: 'btn dropdown-toggle col-sm-8 form-control', name: 'topic', from: user?.getSubscribedTopics())}"
        }
    }

    def isLoggedIn = { attrs, body ->
        if (session.user) {
            out << body()
        }

    }
}
