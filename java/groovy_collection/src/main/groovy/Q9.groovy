/**
 * Created by priyanka on 19/4/17.
 */

class Employee
{
    int EmployeeNumber
    String Name
    int age
    String DepartmentName
    Double salary

    Employee() {
    }

    Employee(int employeeNumber, String name, int age, String departmentName, Double salary) {
        EmployeeNumber = employeeNumber
        Name = name
        this.age = age
        DepartmentName = departmentName
        this.salary = salary
    }


    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeNumber=" + EmployeeNumber +
                ", Name='" + Name + '\'' +
                ", age=" + age +
                ", DepartmentName='" + DepartmentName + '\'' +
                ", salary=" + salary +
                '}';
    }
}


public class Q9 {

    public static void main(String[] args) {



        Employee employee = new Employee()
        employee.setName("priyanka")
        employee.setAge(23);
        employee.setSalary(5500)

        Employee employee1 = new Employee()
        employee1.setName("ankur")
        employee1.setAge(20)
        employee1.setSalary(3000)


        Employee employee2 = new Employee()
        employee2.setName("rivam")
        employee2.setAge(25)
        employee2.setSalary(6000)


        Employee employee3 = new Employee()
        employee3.setName("abhijit")
        employee3.setAge(25)
        employee3.setSalary(4000)



        List list=[];
        list.add(employee)
        list.add(employee1)
        list.add(employee2)
        list.add(employee3)

        println(list)
       println()
       println("Employees with salary greater than 5000")
        println list.findAll{ it.getSalary()>5000


         }

        println()
         println("Name of youngest employee")
        Employee employee6 = list.min{it.age}
        println employee6.name

        println()
        println "Name of oldest employee"
        Employee employee4=list.max{it.age}
        println employee4.name

        println()
        println "Name of employee with greatest salary"
        Employee employee5 = list.max{it.salary}
        println employee5.name


        println()
        println("list of name of all employee")
        println list*.name;


    }


}



