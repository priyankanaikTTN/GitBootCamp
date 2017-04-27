package utils

class Employee {

    String firstname;
    String lastname;
    static transients = ['fullname']

    String getFullname()
    { return "$firstname $lastname"}

    void setFullname(String name){
        firstname=name.split(" ")[0]
        lastname=name.split(" ")[1]
    }

    int getAge()
    {
        return 12
    }

    void setAge(int age)
    {

    }

    static constraints = {


    }
}
