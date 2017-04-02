import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by priyanka on 22/3/17.
 */
class ReadWriteSpec extends Specification {


    String path
    String message

    @Unroll
    void readwritefile()
    {  expect:
       ReadWriteFile.readWriteFile(path)== message

        where:
        path                                     | message
        "/home/priyanka/coreJava/file.txt"       | "File successfully read"
         ""                                      | "File not found"
    }
}
