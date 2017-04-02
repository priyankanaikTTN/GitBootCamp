
import spock.lang.Specification

/**
 * Created by priyanka on 21/3/17.
 */
class StringReplaceSpec extends Specification {


    def stringOriginal
    def stringReplace
    def replacedString

    void stringreplace_1()
    {

        expect:
        StringReplace.stringReplace(stringOriginal,stringReplace) == replacedString

        where:
        stringOriginal | stringReplace         | replacedString
        null           | ""                    | "null string or empty string"
        ""             | ""                    | "null string or empty string"
        "hello java"   | "new"                 | "hellnew"

     }


    void stringReplace_2()
    {

        given:

        stringOriginal=2;

        when:

        StringReplace.stringReplace(stringOriginal,stringReplace)

        then:

        thrown(MissingMethodException)

    }
}
