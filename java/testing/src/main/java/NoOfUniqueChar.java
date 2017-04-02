import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.in;

/**
 * Created by priyanka on 21/3/17.
 */
public class NoOfUniqueChar {

    public static String noOfUniqueChar(String args)
    {

        /*System.out.println("Enter a string");
        Scanner sn= new Scanner(in);*/

        if(args==null)
        { return "String is null";}


        if(args=="")
        { return "String is empty";}


        String lowerCase = args.toLowerCase();
        char arr[] = lowerCase.toCharArray();


        Set<Character> freq = new HashSet<Character>();
        for (char c: arr) {
            freq.add(c);
        }

        Iterator t= freq.iterator();
        while(t.hasNext())
        {
            System.out.println(t.next());
        }

        System.out.println("Total unique characters are :"+ freq.size());


        return  "No of Unique Characters are "+freq.size();
    }


}
