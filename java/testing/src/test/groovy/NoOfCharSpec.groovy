/**
 * Created by priyanka on 21/3/17.
 */

import groovy.lang.MissingMethodException
import spock.lang.Specification
import spock.lang.Unroll

class NoOfCharSpec extends Specification{


    def sample
    def noofchar
    def expectedMessage

    void setup(){
        sample = new NoOfChar()
    }

    @Unroll
    void UniqueChar_1() {
        expect:
        sample.noOfChar(noofchar) == expectedMessage

        where:
        noofchar         | expectedMessage
        null             | "String is null"
        "This is string" | "String is parsed successfully"
        ""               | "String is empty"
        "     "          | "String is parsed successfully"


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
