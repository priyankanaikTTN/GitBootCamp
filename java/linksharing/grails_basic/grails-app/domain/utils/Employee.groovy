package utils

class Employee {

    String firstname;
    String lastname;
    int age;
    static transients = ['fullname']

    String getFullname()
    { return "$firstname $lastname"}

    void setFullname(String name){
        firstname=name.split(" ")[0]
        lastname=name.split(" ")[1]
    }



    static constraints = {


    }



    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}
