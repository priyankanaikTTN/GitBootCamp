/**
 * Created by priyanka on 19/4/17.
 */
class Q1 {

    public static void main(String[] args) {
        List list = [1,2,3,4,5,"ele1",9,11,21,55,32,0,45]

        println("list[11] : ${list[11]}")
        println("list.get(5) :  ${list.get(5)}")
        println("list : $list")


        assert list[11] == 0 // passed
       // assert list[11]==45 passed
        assert list.get(5) == "ele1" // passed

        assert list== [1, 2, 3, 4, 5, "ele1", 9, 11, 21, 55, 32, 0, 45] // passed



    }
}
