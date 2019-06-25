package Logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

public class PlayList implements Serializable {
    LinkedList<Music> Songs;
    String name;
    boolean deleteable;
    boolean changename;
    private byte[] playphoto;

    public PlayList(String name, boolean deleteable, boolean changename,String Pathphoto) {
        Songs = new LinkedList<Music>();
        this.name = name;
        this.deleteable = deleteable;
        this.changename = changename;
        BufferedImage bimage=null;
        try {
            bimage= ImageIO.read(new File(Pathphoto));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream bOS=new ByteArrayOutputStream();
        try {
            ImageIO.write(bimage,"jpg",bOS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        playphoto=bOS.toByteArray();
    }

    public String getName() {
        return name;
    }

    public boolean isDeleteable() {
        return deleteable;
    }

    public void add(Music m) {
        Songs.add(m);
    }

    public void swap(Music m1, Music m2) {
        int indexm1 = Songs.indexOf(m1);
        int indexm2 = Songs.indexOf(m2);
        Songs.remove(indexm1);
        Songs.remove(indexm2);
        Songs.add(indexm1, m2);
        Songs.add(indexm2, m1);
    }

    public void setName(String name) {
        if (changename)
            this.name = name;
    }

    public void remove(Music m) {
        Songs.remove(m);
    }

}
