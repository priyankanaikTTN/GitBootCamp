import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by priyanka on 22/3/17.
 */
class RepeatedOnceSpec extends Specification{


    int[] arr
    List repeatonce

    void setup(){



    }

    @Unroll
    void repeatOnce_1() {
        expect:
        ElementRepeatedOnce.repeatedOnce(arr) == repeatonce as List

        where:
         arr                | repeatonce
         [1,2,3,3,4,4]      | [1,2]
         []                 | null


    }

}
