/**
 * Created by priyanka on 19/4/17.
 */
class Q5 {

    public static void main(String[] args) {

        List list = [11, 12, 13, 14]
        List list1 = [13, 14, 15]

        println("list 1 : $list")

        println("list 2 : $list1")

        println("have common elements : ${!list1.disjoint(list)}")
    }
}
