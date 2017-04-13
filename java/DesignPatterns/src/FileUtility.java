import java.io.*;
import java.util.Scanner;

/**
 * Created by priyanka on 12/4/17.
 */

class File_Reader
{
    static  File_Reader fileReader=null;

    /*private  File_Reader()
    {
        getInstance();
    }
*/
    public  static File_Reader getInstance()
    {
        if(fileReader==null)
        {

            synchronized (File_Reader.class) {
                if(fileReader==null)
                { fileReader=new File_Reader();
                  return fileReader;}

                  return fileReader;

               }

            }
            return fileReader;
        }

    public void readFile(File file)
    {
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(file);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println("************");
                System.out.println(line);
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            file + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + file + "'");
        }


    }

    public void writeFile(File file)
    {
        Scanner scn = new Scanner(System.in);

        try {
        // Assume default encoding.
        FileWriter fileWriter =
                new FileWriter(file);

        // Always wrap FileWriter in BufferedWriter.
        BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

        // Note that write() does not automatically
        // append a newline character.
            boolean b=true;
            System.out.println("Enter data to file");
            while(b) {
                String line = scn.nextLine();


                bufferedWriter.write(line);

                System.out.println("do you want to write more?");
                b=scn.nextBoolean();

            }
        // Always close files.
        bufferedWriter.close();
    }
        catch(IOException ex) {
        System.out.println(
                "Error writing to file '"
                        + file + "'");
        // Or we could just do this:
        // ex.printStackTrace();
    }
    }

    private void writeObject(ObjectOutputStream os) throws NotSerializableException {
        throw new NotSerializableException("This class cannot be Serialized");
    }

    private void readObject(ObjectInputStream os)throws NotSerializableException{
        throw new NotSerializableException("This object cannot be serialized");
    }



}
public class FileUtility {


    public static void main(String[] args) {


        File file = new File("fileutility");

        Thread thread=new Thread(()->{File_Reader file_reader=File_Reader.getInstance();
            file_reader.readFile(file);
        });
        Thread thread1=new Thread(()->{File_Reader file_reader=File_Reader.getInstance();

            file_reader.readFile(file);});

        thread.start();
        thread1.start();

        try {

            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
