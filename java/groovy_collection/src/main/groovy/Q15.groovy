/**
 * Created by priyanka on 20/4/17.
 */
class Q15 {

    public static void main(String[] args) {


        (1..100).each {
            if(it%3==0 && it%5==0){
                println"$it : fizzBuzz "
            }else if(it%3==0) {
                println "$it :fizz "
            }else if(it%5==0) {
                println "$it :buzz "
            } else println()
        }
    }
}
