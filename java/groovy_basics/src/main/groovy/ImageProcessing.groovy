import javax.imageio.ImageIO

/**
 * Created by priyanka on 18/4/17.
 */
class ImageProcessing {


    public static void main(String[] args) {

       // def img = ImageIO.read(new File("/home/priyanka/Downloads/beryy1.jpg"));

        def fout = new FileOutputStream("boot-write.jpg")
        def fin = new FileInputStream("boot2.jpg")
        fin.eachByte { fout.write(it)}


    }
}


