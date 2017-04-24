/**
 * Created by priyanka on 20/4/17.
 */
class Q24 {


    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>()
        (1..50).each
                { employees.add(new Employee(it,
                        ((it%2)==0)?"n${it}":"e${it}",
                        it+10,
                        ((it%2)==0)?"d1":"d2",
                        it*1000))
                }
        employees.each {println it
            println ()
        }

        println "Group the employees on the basis of the bracket in which their salary falls. The ranges are 0-5000, 5001 and 10000, and so on"


        def employees_salary_group =  employees.groupBy {
            element ->
                ((element.getSalary()>0 && element.getSalary()<=5000) ?
                        '0-5000':(element.getSalary()>=5001
                &&element.getSalary()<=10000)?'5000-10000':'10000&above')



        }

        println(employees_salary_group)



       def employee_count_byDepartment= employees.groupBy {element->element.getDepartmentName()}

        employee_count_byDepartment.each {element->


            println("# of employee in department "+element.getKey()+": "+element.getValue().size())


        }

       println "employees whose age is between 18 and 35: ${employees.findAll {element->element.getAge()>=18&&element.getAge()<=35}}"

        def elementWithSameFirstLetter =  employees.groupBy { element -> element.getName().charAt(0) }

      println "element With Same First Letter = ${elementWithSameFirstLetter}"

        elementWithSameFirstLetter.each { e ->
            println "# of employees in group ${e.getKey()} whose age is > 20: ${e.getValue().count{element -> element.getAge() > 20 } }"
        }

        println "Group the employees according to their department"
        println employees.groupBy { element -> element.getDepartmentName() }

    }

}
