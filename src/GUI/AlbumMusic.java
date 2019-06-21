package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;


public class AlbumMusic extends JPanel {

    String Music_name;
    String path;
    JButton b;
    JLabel l;

    public AlbumMusic(){

        Music_name = "none";
        path = "./assets/image/Mosaic.jpg";
        this.Music_name = Music_name;

        setVisible(true);
        setLayout(new GridLayout(2,1,-30,-40));
        setBackground(new Color(60, 60, 60));
        setPreferredSize(new Dimension(300,300));

        b = new JButton(Utils.resize(path,200,200));
        b.setPressedIcon(Utils.resize(path,180,180));
        l = new JLabel(Music_name);

        b.setBorder(null);
        b.setContentAreaFilled(false);

        l.setForeground(Color.WHITE);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setFont(new Font("Arial",Font.BOLD,16));

        this.add(b);
        this.add(l);

    }

    public String getMusic_name() {
        return Music_name;
    }

    public void setMusic_name(String music_name) {
        Music_name = music_name;
        l.setText(music_name);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
        b.setIcon(Utils.resize(path,200,200));
        b.setPressedIcon(Utils.resize(path,180,180));
    }

    public JButton getB() {
        return b;
    }
}
