/**
 * Created by priyanka on 24/4/17.
 */
class Q12 {

    public static void main(String[] args) {


        println("***********Table of 2*************")
        println()
        (1..10).each {id -> println( "$id * 2 = ${id*2}" )}

        println("***********Table of 12************")
        println()
        1.upto(10,{ println( "$it * 12 = ${it*12}")
        })

    }
}
