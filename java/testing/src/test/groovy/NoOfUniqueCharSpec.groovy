import groovy.lang.MissingMethodException
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by priyanka on 21/3/17.
 */
class NoOfUniqueCharSpec extends Specification {



    def sample
    def noofchar
    def expectedMessage

    void setup(){
        sample = new NoOfUniqueChar()
    }

    @Unroll
    void UniqueChar_1() {
        expect:
        sample.noOfUniqueChar(noofchar) == expectedMessage

        where:
        noofchar         | expectedMessage
        null             | "String is null"
        "This is string" | "No of Unique Characters are 8"
        ""               | "String is empty"
        "     "          | "No of Unique Characters are 1"


    }
    void UniqueChar_2()
    {
        given:

        noofchar=2;

        when:

        sample.noOfChar(noofchar)

        then:

        thrown(MissingMethodException)

    }
}


