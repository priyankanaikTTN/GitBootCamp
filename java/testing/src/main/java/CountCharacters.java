import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by priyanka on 22/3/17.
 */
public class CountCharacters {
    public static float[] countCharacters(String str) {

        float lower = 0, upper = 0, digits = 0, specialChars = 0;
        float lowerper=0, upperper=0, digitsper=0, specialCharsper=0;



         float[] a =null;

        if(str==null||str=="")
            return a;


        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                lower++;
            else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                upper++;
            else if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                digits++;
            else
                specialChars++;
        }


              a= new float[8];


        lowerper= (lower * 100) / str.length();
        upperper= (upper * 100) / str.length();
        digitsper= (digits * 100) / str.length();
        specialCharsper= (specialChars * 100) / str.length();
        a[0]=lower;
        a[1]=upper;
        a[2]=digits;
        a[3]=specialChars;
        a[4]=lowerper;
        a[5]=upperper;
        a[6]=digitsper;
        a[7]=specialCharsper;

        System.out.println("In" + str );
        System.out.println("characters  ||  count    ||  percentage");
        System.out.println("Lower case  || " + lower + "        || " + lowerper+ "%.");
        System.out.println("Upper case  || " + upper + "         || " + upperper + "%.");
        System.out.println("Digits      || " + digits + "         || " + digitsper + "%.");
        System.out.println("Special     || " + specialChars + "         || " + specialCharsper + "%.");

        return a;
    }
}

