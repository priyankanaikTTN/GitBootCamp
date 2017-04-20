/**
 * Created by priyanka on 18/4/17.
 */
class MultipleOfThree {

     public static void multiple()
     {

         println("----------using each")
         (1..10).each {id -> println( "$id * 3 = ${id*3}" )}

         println("--------------using upto")
         1.upto(10,{ println( "$it * 3 = ${it*3}")
         })

         println("=============using step")
         1.step 11, 1, {
             println( "$it * 3 = ${it*3}")
         }

     }


    public static void main(String[] args) {

        multiple();

    }

}


