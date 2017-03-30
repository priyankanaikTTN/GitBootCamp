import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by priyanka on 17/3/17.
 */
public class NoOfChar {




    public static String noOfChar(String args)
        {



            if(args==null)
            { return "String is null";}


            if(args=="")
            { return "String is empty";}





            String lowerCase = args.toLowerCase();
            char arr[] = lowerCase.toCharArray();


            Map<Character,Integer> unique = new HashMap<Character, Integer>();

            for(int i=0;i<arr.length;i++) {



                if(unique.get(arr[i])==null) {

                    unique.put(arr[i],1);

                }else {
                    int count=unique.get(arr[i]);
                    unique.put(arr[i],count+1);

                }

            }


            System.out.println("Total occurences of unique arr are ");


            Iterator entries = unique.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry thisEntry = (Map.Entry) entries.next();
                System.out.println("arr :  "+ thisEntry.getKey() +"     occurences  :  " + thisEntry.getValue());

            }

            return "String is parsed successfully";


        }







}
