/**
 * Created by priyanka on 19/4/17.
 */
class Q6
{

    public static void main(String[] args)
    {

        List list = ['a','b',1,4,'e',8,10,'p']
        List list1=[]
        list.eachWithIndex{ entry, i ->



            if(i%2!=0)
                list1.add(entry)
        }


println(list1)


    }

}
