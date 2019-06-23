package Logic;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Tests {
    public static void main(String[] args){
        Music m=new Music("C:\\Users\\Shay\\Desktop\\03 Ramin Djawadi - Light of the Seven.mp3","sample");
        InputStream in = new ByteArrayInputStream(m.ArtWork);
        try {
            BufferedImage bImage = ImageIO.read(in);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos );
            byte [] data = bos.toByteArray();
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            BufferedImage bImage2 = ImageIO.read(bis);
            ImageIO.write(bImage2, "jpg", new File("output.jpg") );
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
