import java.io.*;

/**
 * Created by priyanka on 22/3/17.
 */
public class ReadWriteFile
{
    private static String FILE_PATH ;

    public static String readWriteFile(String args)
    {
        FILE_PATH=args;


        StringBuilder builder=new StringBuilder();
        String line;
        File file=new File(FILE_PATH);


        if(!file.exists()){

            return "File not found";
        }

        BufferedReader br=null;
        try{
//			InputStream in=new FileInputStream(file);
            InputStreamReader reader;
            reader = new InputStreamReader(new FileInputStream(file));
            br=new BufferedReader(reader);

            while((line=br.readLine())!=null){
                builder.append(line).append("\n");
            }

            System.out.println(builder.toString());
            br.close();
        }catch (IOException e){
            e.printStackTrace();
            return "File cannot be read successfully";
        }

        return "File successfully read";
    }
}

