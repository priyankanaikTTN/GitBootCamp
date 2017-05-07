package com.ttn.linksharing

import enums.Seriousness
import enums.Visibility

class SubscriptionController {

    def index() { }



    def save(long id, String serious) {

        Topic topic = Topic.get(id)

        if (session['user']&& topic) {

            Seriousness seriousness = Seriousness.toString(serious)

            Subscription subscription = new Subscription(topic: topic, user: session['user'], seriousness: seriousness)

            //log.error("${topic.topicname} :: ${topic.createdBy} :: ${topic.visibility}")

            if (topic.visibility == Visibility.PUBLIC)

            {
                //log.error("${subscription.topic.topicname} :: ${subscription.user} :: ${subscription.seriousness}")


                if (subscription.save(flush: true)) {

                    flash.message = "User subscribed to ${topic.topicname}"

                }
                else {
                    flash.message = "User cannot be subscribed to topic"

                }


            }
                else {
                flash.message ="User cannot subscribe as Topic is private"
            }
        }

            else {
                flash.error = " User session no set"
            }

            render flash.message


    }
    def delete(long id)
    {
        User user = session['user']

        Topic topic = Topic.get(id)

        Subscription subscription = Subscription.findByTopicAndUser(topic,user)

        flash.message=""

        // log.error("${topic.topicname}")

        if (user && subscription )
        {
            subscription.delete(flush: true)

             flash.message = "subscription deleted"

        }
        else
        {
            flash.message = "could not delete subscription"
        }

        render flash.message
    }


    def update(long id, String serious)
    {
        Seriousness seriousness = Seriousness.toString(serious)
        Topic topic = Topic.load(id)

        if(session['user']&&topic)
        {
            Subscription subscription = Subscription.findByTopicAndUser(topic,session['user'])

            if(subscription&&subscription.seriousness!=seriousness)
            {
                    subscription.seriousness=seriousness
                    if(subscription.save(flush:true))

                         render flash.message = "Seriousness updated"


                    else
                        render flash.message= "Subscription cannot be set"

            }
            else
            {
                render flash.message ="Subscription not found"
            }

        }
        else {

            render flash.message= 'User not set'
        }


    }


}

