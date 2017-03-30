import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by priyanka on 22/3/17.
 */
class CommonElementsSpec extends Specification {

    String[] commonelements
    String[] str1
    String[] str2

    void setup(){




    }

     @Unroll
    void commonElement()
    {
         expect:CommonElements.commonElements(str1,str2) == commonelements


        where:
        str1                                               | str2                                                | commonelements
       ["ONE", "TWO", "THREE", "FOUR", "FIVE", "FOUR"]     | ["THREE", "FOUR", "FIVE", "SIX", "SEVEN", "FOUR"]   | ["FIVE","FOUR","THREE"]
               []                                          |[]                                                   |  null
     }


}
