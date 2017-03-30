import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by priyanka on 22/3/17.
 */
class StaticPrintSpec extends Specification {


    String[] str
    String staticprint

    void setup(){



    }

    @Unroll
    void repeatOnce_1() {
        expect:
       StaticPrint.staticPrint(str) == staticprint

        where:
        str                           | staticprint
        ["Priyanka","Naik","23"]      | "First Name: Priyanka Last Name: Naik Age: 23"
        []                            | null


    }

}
