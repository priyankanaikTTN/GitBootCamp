/**
 * Created by priyanka on 18/4/17.
 */
class REplaceWhiteSpace {

    public static void main(String[] args) {

        def fout = new File("test3.txt")

        def line="";

        StringBuilder sb = new StringBuilder();

        int i=1;

        new File("test.txt").withReader {

            reader->
                while(line = reader.readLine())
                {

                    sb.append(line.replaceAll("[\\s\\n\\t]","")+"\n")

                }
        }



        fout.write(sb.toString())
    }
}
