/**
 * Created by priyanka on 19/4/17.
 */
class Q10 {


    public static void main(String[] args) {

        String s = "this string needs to be split";
        println("s :: " +s)
        println ('s.tokenize(" ") ::' + s.tokenize(" "))
        println ("s.tokenize() :: "+s.tokenize())



        println ('s.split(" ") :: '+s.split(" "))
        println ('s.split(/\\s/) ::'+s.split(/\s/))



        String s1 = "are.you.trying.to.split.me.mister?"

        println()
        println("s1 :" +s1)

       println ('s1.tokenize(".") ::' +s1.tokenize("."))
        println ('s1.split(".") ::'+ s1.split("."))
    }
}
