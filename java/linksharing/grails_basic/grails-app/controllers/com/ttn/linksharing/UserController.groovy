package com.ttn.linksharing

class UserController {

    def index() {

        render "${flash.error}  user dashboard :::: ${session.user.username}"

    }

    def list =
            {
                List<User> users = User.createCriteria().list() {

                    or
                            {
                                eq("firstname", "Priyanka")
                            }
                }

                render "Result -> ${users.size()} ${users.firstname} ${users.username}"

            }
    def listPaginate =
            {

                List<User> users = User.createCriteria().list(max: 10, offset: 0) {

                    ilike("firstname", "Pri%")

                }

            }

    def listDistinct =
            {
                List<User> users = User.createCriteria().listDistinct {
                    ilike("firstname", "Pri%")
                    order("firstname", "desc")
                }

                render "Result -> ${users.size()} ${users.firstname} ${users.username}"

            }

    def and =
            {
                List<Topic> topicList = Topic.createCriteria().list {
                    and {

                        'createdBy' {
                            eq("username", "admin")
                        }
                    }

                }

                render "Result-> ${topicList*.id} ${topicList*.createdBy*.username}"
            }


    def property =
            {
                def projectUser = User.createCriteria().list() {


                    projections
                            {
                                'topic' {
                                    property("id")
                                }
                                property("username")
                            }
                }
                render "Result -> ${projectUser}"
            }


    def distinct =
            {


                def userdistinct = User.createCriteria().list() {

                    projections {


                        distinct("firstname")
                    }

                }

                render "Result -> ${userdistinct}"
            }

    def groupProperty =
            {

                List result = Topic.createCriteria().list() {


                    projections{

                        groupProperty("createdBy")
                        rowCount()
                    }
                }

                render " Result -> ${result}"
            }

    def alias =
            {

                List result = ResourceRating.createCriteria().list() {


                    projections
                            {
                                groupProperty("user")
                                sum('score',"totalscore")
                            }
                    order("totalscore","desc")
                }

                render "Result -> ${result}"
            }

    def executeQuery =
            {

                User createdBy= User.findByUsername("admin")
                List list= Topic.executeQuery("select t.topicname from Topic as t where createdBy=:createdBy",[createdBy:createdBy])
                render "Topic_info: ${list}"
            }

    def namequery ={

        Date date = new Date()
        List topics = Topic.recentTopics(date).list()

        render " Success -> ${topics}"
    }
}
