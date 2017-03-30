/**
 * Created by priyanka on 22/3/17.
 */
public class StaticPrint
{


    static String firstName ;
    static String lastName ;
    static int age ;

    static
    {
        System.out.println("\n Static block");
        String firstName = "Priyanka";
        String lastName = "Naik";
        int age = 23;
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Age: " + age);
    }

    {
        System.out.println("\n  Non Static Block run");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Age: " + age);

    }


    static String display()
    {
        System.out.println("\n Static Method");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Age: " + age);

        return "First Name: "+firstName+" Last Name: "+lastName+" Age: "+age;
    }

    public static String staticPrint(String[] args)
    {


        if(args.length==0)
            return null;

        firstName=args[0];
        lastName=args[1];
        age=Integer.parseInt(args[2]);


        StaticPrint sp = new StaticPrint();
        String str=display();
        StaticPrint sp2= new StaticPrint();

        return str;
    }

}
