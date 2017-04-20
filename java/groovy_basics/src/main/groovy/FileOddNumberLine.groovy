/**
 * Created by priyanka on 18/4/17.
 */
class FileOddNumberLine {


    public static void main(String[] args) {

        def fout = new File("test2.txt")

        def line="";

        StringBuilder sb = new StringBuilder();

        int i=1;

        new File("test.txt").withReader {

            reader->
                while(line = reader.readLine())
                {  if (i%2!=0)
                            sb.append(line+"\n")

                    ++i;
                }
        }



        fout.write(sb.toString())
    }
}
