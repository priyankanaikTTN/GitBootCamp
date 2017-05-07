package utils

import demoCo.EmployeeCo
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EmployeeController {

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

    def download()
    {
        byte[] bytes = new File("/home/priyanka/Desktop/bootstrap/test.txt").bytes

        response.setHeader("Content-disposition","attachment; filename=" + "demofile")

        response.setContentType("text/plain")

        response.outputStream << bytes


    }
}
