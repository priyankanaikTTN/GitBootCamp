import spock.lang.Specification

/**
 * Created by priyanka on 22/3/17.
 */
class FunctionOverloadingSpec  extends Specification{

    def i,j,result
    String s1,s2,s3


       void addNums_1(){

           expect:
           FunctionOverloading.addNums(i,j)==result

           where:

           i  |  j   | result
           1  |  2   | 3
           1.0|  3.5 | 4.5
        }



        void  multiplyNums_1()
        {
            expect:
            FunctionOverloading.multiplyNums(i,j)==result as float

            where:

            i     | j          | result
            2     | 4          | 8
            2.3   | 3.4        | 7.82
        }



        void  concateStr_1()
        {


            expect:
            FunctionOverloading.concateStr(s1,s2)==result

            where:
              s1         |  s2       | result
             "Hello"     | "World"   | 'HelloWorld'
        }


    void concateStr_2()
    {

        expect:
        FunctionOverloading.concateStr(s1,s2,s3)==result

        where:
        s1          | s2        | s3                 | result
        "Hello"     |" Java"    | " World"           | "Hello Java World"

    }

}
