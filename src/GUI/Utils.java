package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Utils {

    //resizing Image
    public static ImageIcon resize(String path, int w, int h) {
        BufferedImage imgage = null;
        try {
            imgage = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = imgage.getScaledInstance(w, h , Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);

        return imageIcon;
    }
    public static ImageIcon resize(BufferedImage imgage, int w, int h) {

        Image dimg = imgage.getScaledInstance(w, h , Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);

        return imageIcon;
    }
}
