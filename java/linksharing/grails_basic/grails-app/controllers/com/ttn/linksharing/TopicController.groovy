package com.ttn.linksharing

import co.ResourceSearchCO
import enums.Visibility

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


    def save(String topicName, String visibility)
    {

        if(session['user'])
        {
            Visibility visible = Visibility.toString(visibility)

            Topic topic = new Topic(topicname:topicName,createdBy: session['user'] , visibility: visible)

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

        render flash.message
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
