/**
 * Created by priyanka on 19/4/17.
 */
class Q8 {

    public static void main(String[] args) {

        List list = [14,12, 11,10, 16, 15,12, 10, 99, 90, 14, 16, 35]





        list.unique().sort {element1,element2->
            element1 < element2 ? 1 : element1==element2 ? 0 : -1}

        println(list)

    }
}
