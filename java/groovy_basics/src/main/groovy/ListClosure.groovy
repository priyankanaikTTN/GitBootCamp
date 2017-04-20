/**
 * Created by priyanka on 18/4/17.
 */
class ListClosure {


    public static  void findElement()
    {

       boolean flag =false;

        def ispresent = { ele,id ->

                   if(id==ele)
                           (true)

                             else
                               (false)
        }

        List list = Arrays.asList("a","b","c");

        list.any {

           flag=  ispresent(it,"a")
        }


        if(flag)
             println(true)
        else
            println(false)
    }

    public static void main(String[] args) {

        findElement()

    }
}
