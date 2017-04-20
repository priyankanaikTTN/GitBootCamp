/**
 * Created by priyanka on 18/4/17.
 */
class ListClosure {


    public static  void findElement()
    {

     

        def ispresent = { list,id ->

                 println list.any{it->it==id}
        }

        List list = Arrays.asList("a","b","c");


        ispresent(list,'c')

    }

    public static void main(String[] args) {

        findElement()

    }
}
