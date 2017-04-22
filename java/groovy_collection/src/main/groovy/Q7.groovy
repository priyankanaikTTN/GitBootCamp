/**
 * Created by priyanka on 19/4/17.
 */
class Q7 {


    public static void main(String[] args) {
        List list = [1, 2, 3, "element1", 0.3, [2, 4, 6], 0..10 ]

        list.forEach{element->println("$element : ${element.getClass()}")}

        println("list.get(6).get(9):::" +list.get(6).get(9) )
        println("list.get(5).get(1)::: " +list.get(5).get(1))

        assert list[0].getClass()==java.lang.Integer
        assert list[3].getClass()==java.lang.String
        assert list[4].getClass()==java.math.BigDecimal
        assert list[5].getClass()==java.util.ArrayList
        assert list[6].getClass()==groovy.lang.IntRange


    }
}