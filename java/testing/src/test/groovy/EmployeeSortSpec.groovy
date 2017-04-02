import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by priyanka on 21/3/17.
 */
class EmployeeSortSpec extends Specification {


    EmployeeSort[] sample

    def expectedMessage

    void setup(){
        sample = [
            new EmployeeSort("ashutosh", 30000, 20),
            new EmployeeSort("nisha", 50000, 22),
            new EmployeeSort("ravi", 40000, 21),
            new EmployeeSort("sampark", 40000, 23),
            new EmployeeSort("ashima", 50000, 21)
        ]
    }

    @Unroll
    void Sorted_1() {
       given:


        when:
        expectedMessage=EmployeeSort.employeeSort(sample)
        then:
        expectedMessage=="[Employee{name='ashutosh', age=20, salary=30000}, Employee{name='ravi', age=21, salary=40000}, Employee{name='ashima', age=21, salary=50000}, Employee{name='nisha', age=22, salary=50000}, Employee{name='sampark', age=23, salary=40000}]"


    }
    void UniqueChar_2()
    {
        given:

       EmployeeSort[] sample2


        when:

        EmployeeSort.employeeSort(sample2)

        then:
       thrown(NullPointerException)

    }
}
