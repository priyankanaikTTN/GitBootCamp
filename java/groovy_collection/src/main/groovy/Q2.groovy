/**
 * Created by priyanka on 19/4/17.
 */
class Q2 {

    public static void main(String[] args) {



        Range range = 1..12

        List list= range.findAll { if(it%2==0)it}

        println(list)

        assert list==[2, 4, 6, 8, 10, 12] // passed
        //assert list==[2, 4, 6, 8, 10] passed
    }
}


