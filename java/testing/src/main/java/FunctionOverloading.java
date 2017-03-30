/**
 * Created by priyanka on 22/3/17.
 */
public class FunctionOverloading
{


    public static int addNums(int n1 , int n2){
        return n1+n2;
    }

    public static float addNums(float n1 , float n2){
        return (float) n1+n2;
    }

    public static int multiplyNums(int n1 , int n2){
        return n1*n2;
    }

    public static float multiplyNums(float n1 , float n2){
        return n1*n2;
    }

    public static String concateStr(String s1, String s2){
        return s1.concat(s2);
    }

    public static String concateStr(String s1, String s2, String s3){
        return s1.concat(s2.concat(s3));
    }
}