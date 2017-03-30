import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by priyanka on 21/3/17.
 */
public class EmployeeSort   {

    private String name;
    private int age;
    private int salary;

    public EmployeeSort(String name,int salary,int age)
    {this.name=name;
        this.salary=salary;
        this.age=age;}

    public int getAge()
    { return this.age;}

    public int getSalary()
    {return this.salary;}

    public String getName()
    {return this.name;}

    @Override
    public String toString() {
        System.out.println();
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';

    }

    public static String employeeSort(EmployeeSort[] E)throws NullPointerException
    {


        if(E.length==0)
            return "Empty Employee Object";


        CompareEmployee comp = new CompareEmployee();


        /*for (Employee e : E
             ) {
            System.out.println(e.getAge());
            System.out.println(e.getName());
            System.out.println(e.getSalary());

        }*/
        System.out.println("*****************Before sorting*********************");
        System.out.println(Arrays.toString(E));

        Arrays.sort(E,comp);


        System.out.println("******************After sorting************************");
        System.out.println(Arrays.toString(E));




        return Arrays.toString(E);

    }
}



class CompareEmployee implements Comparator<EmployeeSort> {
    public int compare(EmployeeSort o1, EmployeeSort o2) {


        return o1.getAge()-o2.getAge();


    }

}