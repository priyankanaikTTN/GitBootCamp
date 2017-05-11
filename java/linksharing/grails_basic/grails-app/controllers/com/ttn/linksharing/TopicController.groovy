package com.ttn.linksharing

import co.ResourceSearchCO
import co.TopicCO
import enums.Visibility
import vo.TopicVO

class TopicController {

    def index() { }

    def show(long id, ResourceSearchCO co) {
        Topic topic = Topic.read(id)

        if (!topic) {

            flash.error = "topic doesn't exist"

            redirect(controller: "login", action: "index")




        }
        else if (topic.visibility == Visibility.PUBLIC) {

            render "success public"

        }
        else if (topic.visibility == Visibility.PRIVATE) {


              if (Subscription?.findByUserAndTopic(session['user'], topic)) {

                      render "success private"
              }
              else {

                   flash.error = "topic is private "
                  redirect(controller: "login", action:"index")

              }
          }
        else
        {
            render "failure private"
        }

    }


    def save(TopicCO topicCO)
    {

        if(session['user'])
        {
            Visibility visible = Visibility.toString(topicCO.visibility.toString())

            Topic topic = new Topic(topicname:topicCO.topicname,createdBy: session['user'] , visibility: visible)

           // log.error("${topic.topicname} :: ${topic.createdBy} :: ${topic.visibility}")

            if(topic.save(flush:true))
            {
                flash.message= "Topic saved successfully"

            }
            else
            {
                flash.message= "Topic cannot be saved"

            }


        }

        else
        {
            flash.error =" User session no set"
        }

        redirect(controller: "user", action:"index" )
    }
    def delete(long id)
    {
         User user = session['user']

        Topic topic = Topic.findByIdAndCreatedBy(id,user)

       // log.error("${topic.topicname}")

        if (user && topic )
        {
            topic.delete(flush: true)

            render flash.message = "topic deleted"

        }
        else
        {
              render flash.error = "could not delete topic"
        }
    }
}
