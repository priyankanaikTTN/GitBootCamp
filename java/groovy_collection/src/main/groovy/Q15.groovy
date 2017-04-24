/**
 * Created by priyanka on 20/4/17.
 */
class Q15 {

    public static void main(String[] args) {



        (1..100).each {
            print it
            if(it%3==0) {
                print " fizz "
            }
            if(it%5==0) {
                print " buzz "
            }
            println()
        }
    }
}
