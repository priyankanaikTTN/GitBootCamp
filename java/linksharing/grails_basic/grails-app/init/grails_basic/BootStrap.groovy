package grails_basic


import com.ttn.linksharing.DocumentResource
import com.ttn.linksharing.LinkResource
import com.ttn.linksharing.ReadingItem
import com.ttn.linksharing.Resource
import com.ttn.linksharing.ResourceRating
import com.ttn.linksharing.Subscription
import com.ttn.linksharing.Topic
import com.ttn.linksharing.User
import constants.Constants
import enums.Visibility
import utils.Employee

import grails.config.Config

class BootStrap {

    def grailsApplication

    def init = { servletContext ->
        // Get configuration from GrailsApplication.
        final Config configuration = grailsApplication.config

        // Get the value for sample.config.
        final String sampleConfigValue = configuration.getProperty('grails.app.context')

        log.info("Value for sample.config configuration property = ${sampleConfigValue}")


       /* servletContext ->
        Employee employee = new Employee()

        employee.firstname='priyanka'
        employee.lastname='naik'
       // employee.setAge(23)
        employee.save(flush:true)

            Employee employee1 = new Employee()

            employee1.firstname='sargam'
            employee1.lastname='sachdeva'
            // employee.setAge(23)
            employee1.save(flush:true)

            Employee employee2 = new Employee()

            employee2.firstname='gaurav'
            employee2.lastname='arora'
            // employee.setAge(23)
            employee2.save(flush:true)

            getAndFind()
            findorcreate()


*/


            List<User> users = createUser()
            List<Topic> topics = createTopic(users)
            createResources(topics)
             createSubscription(users, topics)
             createReadingItems(users, topics)
            createResourceRatings(users)



        }

        List<User> createUser() {
            List<User> users = []
            User normalUser = new User(username: "normalUser",
                    firstname: "Priyanka",
                    lastname: "Naik",
                    email: "user@ttnd.com",
                    confirmPassword: Constants.PASSWORD,
                    password:Constants.PASSWORD,admin: false, active: true)

            User adminUser = new User(username: "admin",
                    firstname: "Priyanka",
                    lastname: "Naik",
                    email: "admin@ttnd.com",
                    confirmPassword: Constants.PASSWORD,
                    password: Constants.PASSWORD,admin : true,active :true)

            Integer countUsers = User.count()

            if (!countUsers)
            {
                log.info "Creating new users "
                if (normalUser.save(flush:true)) {
                    log.info "${normalUser} saved"
                    users.add(normalUser)
                }
                else {
                    log.error "${normalUser} cannot be saved--- ${normalUser.errors.allErrors}"
                }

                if (adminUser.save(flush:true)) {
                    log.info "${adminUser} saved"
                    users.add(adminUser)
                } else {
                    log.error "${adminUser} cannot be saved--- ${adminUser.errors.allErrors}"
                }

            }
            else
            {
                log.info "Users exists in the system "
                users = User.findAll()
            }
            return users
        }

        List<Topic> createTopic(List<User> users) {
            List<Topic> topics = []

            users.each { User user ->
                Integer countTopics = Topic.countByCreatedBy(user)
                if (!countTopics) {
                    log.info "Creating 5 Topics for ${user}"

                    (1..5).each {
                        Topic topic = new Topic(topicname: "Topic${it}", visibility: Constants.VISIBILITY,
                                createdBy: user)
                        if (topic.save(flush:true))
                        {
                            log.info "${topic} saved for ${user}"
                            topics.add(topic)
                            user.addToTopic(topic)
                        }
                        else {
                            log.error "${topic} is not saved for ${user}"
                        }
                    }
                }
                else {
                    log.info "${user} already have some topics created "
                    topics += Topic.findAllByCreatedBy(user) }
            }
            return topics
        }

        def createResources(List<Topic> topics) {


            topics.each { Topic topic ->
                Integer countResources = Resource.countByTopic(topic)
                if (!countResources)
                {
                    2.times {
                        Resource documentResource = new DocumentResource(description: "topic ${topic} doc", createdBy: topic
                                .createdBy, filePath: "file/path", topic: topic)


                        Resource linkResource = new LinkResource(description: "topic ${topic} link", createdBy: topic
                                .createdBy, url: "https://www.google.co.in", topic: topic)

                        if (documentResource.save(flush:true)) {

                            log.info "${documentResource} saved by ${topic.createdBy} for ${topic}"

                            topic.addToResources(documentResource)
                            topic.createdBy.addToResources(documentResource)

                        }
                        else
                        {
                            log.error "${documentResource} not saved--- ${documentResource.errors.allErrors}"
                        }
                        if (linkResource.save(flush : true))
                        {
                            log.info "${linkResource} saved by ${topic.createdBy} for ${topic}"

                            topic.addToResources(linkResource)
                            topic.createdBy.addToResources(linkResource)
                        }
                        else
                        {
                            log.error "${linkResource} not saved--- ${linkResource.errors.allErrors}"
                        }
                    }
                }

            }

        }

        def createSubscription(List<User> users, List<Topic> topics) {



            users.each { User user ->
                topics.each { Topic topic ->
                    if (Subscription.findByUserAndTopic(user, topic) == null) {
                        Subscription subscription = new Subscription(user: user, topic: topic, seriousness:Constants.SERIOUSNESS)

                        if (subscription.save(flush:true))
                        {
                            log.info "${subscription}-> ${user} subscribed for ${topic}"

                            topic.addToSubscriptions(subscription)
                            user.addToSubscriptions(subscription)
                        }
                        else {
                            log.error "Subscription does not occurs--- ${subscription.errors.allErrors}"
                        }
                    } else
                    {
                        log.info "User ${user} already subscribed to Topic ${topic}"
                    }
                }
            }

        }

       def createReadingItems(List<User> users, List<Topic> topics) {



            users.each { User user ->
                topics.each { Topic topic ->
                    if (Subscription.findByUserAndTopic(user, topic)) {
                        topic.resources.each { resource ->
                            if (resource.createdBy != user && !user.readingItems?.contains(resource))
                            {
                                ReadingItem readingItem = new ReadingItem(user: user, resource: resource, isRead: false)
                                if (readingItem.save(flush:true))
                                {
                                    log.info "${readingItem} saved in ${user}'s list"

                                    resource.addToReadingItems(readingItem)
                                    user.addToReadingItems(readingItem)
                                }
                                else {
                                    log.error "${readingItem} is not saved in ${user}'s list--- ${readingItem.errors.allErrors}"
                                }
                            }
                        }
                    }
                }
            }

        }

        def createResourceRatings(List<User> users) {



            users.each { User user ->
                user.readingItems?.each { ReadingItem readingItem ->
                    if (!readingItem.isRead) {

                        ResourceRating resourceRating = new ResourceRating(score: 4, user: readingItem.user,
                                resource: readingItem.resource)

                        if (resourceRating.save(flush:true)) {
                            log.info "${resourceRating} rating for ${readingItem.resource} by ${readingItem.user}"

                            readingItem.resource.addToRatings(resourceRating)
                            readingItem.user.addToResourceRatings(resourceRating)
                        }
                        else {
                            log.error "${resourceRating} rating not set for ${readingItem.resource} by ${readingItem.user}---" +
                                    " ${resourceRating.errors.allErrors}"
                        }
                    } else {
                        log.info "${readingItem.user} cannot rate"
                    }
                }
            }

        }
  /*  void getAndFind()
    {

        log.info("findindg by id: ")
        Employee employee = Employee.get(1)
        log.info("Name of employee with id 1 :" +employee.firstname)
        log.info("finding by name ")
        employee=Employee.findByFirstnameIlike("%sar%")


    }

    void findorcreate()
    {

        Employee employee = Employee.findOrCreateWhere([firstname: "ashish",lastname: "tanwar"])
        log.info("employee with findor create :" + employee?.firstname)

        employee = Employee.findOrSaveWhere([firstname: "manish",lastname: "dhoundiyal"])
        log.info("employee with findor save :" + employee?.id )

    }*/



    def destroy = {
    }

}

