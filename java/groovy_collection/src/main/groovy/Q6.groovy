/**
 * Created by priyanka on 19/4/17.
 */
class Q6
{

    public static void main(String[] args)
    {

        List list = ['a','b',1,4,'e',8,10,'p']
        List list1=[]

        int count=1;
        list.removeAll { ++count%2!=0


        }


        println(list)



    }

}
