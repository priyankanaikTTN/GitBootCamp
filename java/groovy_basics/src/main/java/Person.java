

/**
 * Created by priyanka on 18/4/17.
 */
enum Gender{F,M}
public class Person
{

    String name;
    int age;
    Gender gender;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    String address;

    public String getName() {
        System.out.println("in getter of name field");
        return name;
    }

    public void setName(String name) {
        System.out.println("in setter of name field");
        this.name = name;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Priyanka Naik");
        person.setAddress("Rzh/17 mahavir enclave");
        person.setAge(23);

        person.setGender(Gender.F);

        System.out.println(person);
    }
}
