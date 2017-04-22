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


        def employees_0_5000 =  employees.groupBy {
            element -> (element.getSalary()>0 && element.getSalary()<=5000)
        }
        println()
        println "employees with salary range 0-5000: ${employees_0_5000.get(true)}"

        def employees_5001_10000 =  employees.groupBy {element -> (element.getSalary()>=5001 && element.getSalary()<=10000)}
        println "employees with salary range 5001-10000: ${employees_5001_10000.get(true)}"

        println "# of employees in department d1: ${employees.count{element -> element.getDepartmentName()=="d1"}}"
        println "# of employees in department d2: ${employees.count{element -> element.getDepartmentName()=="d2"}}"


        println "employees whose age is between 18 and 35: ${employees.groupBy{element -> element.getAge()>=18 && element.getAge()<=35 }.get(true)}"

        def elementWithSameFirstLetter =  employees.groupBy { element -> element.getName().charAt(0) }

        println "element With Same First Letter = ${elementWithSameFirstLetter}"

        elementWithSameFirstLetter.each { e ->
            println "# of employees in each group whose age is > 20: ${e.getValue().count{element -> element.getAge() > 20 } }"
        }

        println "Group the employees according to their department"
        println employees.groupBy { element -> element.getDepartmentName() }

    }

}
