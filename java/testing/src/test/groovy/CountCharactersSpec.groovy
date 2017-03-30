import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by priyanka on 22/3/17.
 */
class CountCharactersSpec extends Specification{

    float[] countchar
    String str

    void setup(){


    }

    @Unroll
    void countChar_1() {
        expect:
        CountCharacters.countCharacters(str) == countchar as float[]

        where:
        str                 | countchar
        null                | null
        "This is string 42" | [11.0,1.0,2.0,3.0,64.70588,5.882353,11.764706,17.647058]


    }
    void countChar_2()
    {
        given:

        def str=2;

        when:

        CountCharacters.countCharacters(str)

        then:

        thrown(MissingMethodException)

    }
}
