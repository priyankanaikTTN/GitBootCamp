/**
 * Created by priyanka on 18/4/17.
 */
class Employee extends Person{

    int empid;
    float salary;
    String company;


    public static void main(String[] args) {
        Employee emp = new Employee();

        emp.empid=1;
        emp.salary=23000;
        emp.company="TTN";
        emp.name="Priyanka";
        emp.@age=23;
        emp.@gender=Gender.F;
        emp.@address="Rzh 17 dwarka";


       /* println(emp.name+" "+emp.age+" "+emp.address+" "+emp.gender+" "+emp.empid+" "+emp.company+" "+emp.salary);
        println("${emp}")*/
        println("${emp.name} ${emp.@age} ${emp.@address} ${emp.@gender} ${emp.empid} ${emp.company} ${emp.salary}");

        emp.toString();

    }

    @Override
    public String toString() {

        println("$name is a girl aged $age who lives at $address. She works for $company with employee id $empid and draws $salary lots of money !!!!.")
    }
}
