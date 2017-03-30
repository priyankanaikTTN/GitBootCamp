import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.System.in;

/**
 * Created by priyanka on 22/3/17.
 */
public class ElementRepeatedOnce {

    public static List repeatedOnce(int[] arg) {



         if(arg.length==0)
             return null;

        Set<Integer> set = new HashSet<Integer>();

        for (int item : arg) {
            if (!set.remove(item)) {
                set.add(item);
            }
        }

        System.out.println("elements that occur only once");
        for (int i : set) {
            System.out.println(i);
        }

        List<Integer> list = set.parallelStream().collect(Collectors.toList());

       return list;
    }


}

