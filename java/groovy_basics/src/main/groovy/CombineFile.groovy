/**
 * Created by priyanka on 18/4/17.
 */
class CombineFile {


    public static void listFiles(String directoryName){


        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        File file1=new File("file4.txt")
        def line="";

        StringBuilder sb = new StringBuilder();


        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getName());

                file.withReader {
                    reader->while(line=reader.readLine())
                {
                    sb.append(line+'\n')
                }


                }
                file1.write(sb.toString())
            }
        }
    }


    public static void main(String[] args) {

        listFiles("groovyDirectory");
    }
}
