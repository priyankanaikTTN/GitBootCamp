package utils

import com.ttn.linksharing.ResourceRating
import com.ttn.linksharing.Topic
import com.ttn.linksharing.User
import demoCo.EmployeeCo
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EmployeeController {

    def employeeService

    def index()
    {
        render (view : 'demoview')
    }

    def index1()
    {
        Employee employee = new Employee(params)

        render employee



    }

    def index2()
    {
        Employee employee = new Employee()
        employee.properties= params

        render employee

    }

    def index3()
    {
        Employee employee = new Employee()
        bindData(employee,params,[include:['firstname','lastname'], exclude:['age']])
        render employee


    }

    def index4(EmployeeCo employeeCo)
    {
        render employeeCo
    }

    def upload()
    {
        def f= params.myFile
        render f.inputStream.text;
    }

    def list =
            {

                List<User> users =employeeService.listUser()
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
    def download()
    {
        byte[] bytes = new File("/home/priyanka/Desktop/bootstrap/test.txt").bytes

        response.setHeader("Content-disposition","attachment; filename=" + "demofile")

        response.setContentType("text/plain")

        response.outputStream << bytes


    }
}
