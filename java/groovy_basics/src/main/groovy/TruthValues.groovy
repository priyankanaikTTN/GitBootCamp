/**
 * Created by priyanka on 18/4/17.
 */
class TruthValues {


    public static void main(String[] args) {

        println "unintialized list"
         List list1 ; //false

        if(list1){

            println true
        }
        else
        { println false}


         println "empty list"
         List list2=new ArrayList();//false

        if(list2){
            println true
        }
        else
        { println false}


        println "list initialized to null"
        List list3 =null; //false

        if(list3){
            println true
        }
        else
        { println false}


        println "Object initialized to null"
        Object obj1=null//  false

        if(obj1){
            println true
        }
        else
        { println false}


        println "Empty string"
        // EMPTY sTRING = falsr

        if("")
        {println true}
        else
        {println false;}

        println "NUll value"
        // null =false
         if(null)
         {println true}
        else
         { println false}

        println "non empty list"
        List list = new ArrayList()
        list.add(obj1)//true
        if(list){
            println true
        }
        else
        { println false}


    }
}
