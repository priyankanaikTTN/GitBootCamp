import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by priyanka on 21/3/17.
 */
public class StringReplace {
    public static String stringReplace(String args, String replace) throws IOException {



        if(args==null||args=="")
            return "null string or empty string";

        //BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Original String: " +args);
        System.out.println("String to be replaced with : "+replace);


        args= args.replace(args.substring(4),replace);
        System.out.println("replaced string : "+args);
        return args;
    }
}
