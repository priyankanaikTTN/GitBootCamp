import java.util.HashSet;

/**
 * Created by priyanka on 22/3/17.
 */
public class CommonElements {


    public static String[] commonElements(String[] var1,String[] var2)
    {



        if(var1.length==0||var2.length==0)
            return null;
        HashSet var3 = new HashSet();

        for(int var4 = 0; var4 < var1.length; ++var4) {
            for(int var5 = 0; var5 < var2.length; ++var5) {
                if(var1[var4].equals(var2[var5])) {
                    var3.add(var1[var4]);
                }
            }
        }

        System.out.println(var3);


        return (String[]) var3.toArray(new String[var3.size()]);

    }
}