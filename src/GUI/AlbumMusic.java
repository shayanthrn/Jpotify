package GUI;

import Logic.Music;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;


public class AlbumMusic extends JPanel {

    String Music_name;
    JButton b;
    JLabel l;
    Music m;

    public AlbumMusic(Music m){

        Music_name = m.getName();
        this.m = m;
        Music_name = m.getName();
        setVisible(true);
        setLayout(new GridLayout(2,1,-30,-40));
        setBackground(new Color(60, 60, 60));
        setPreferredSize(new Dimension(300,300));

        try {
            b = new JButton(Utils.resize(ImageIO.read(new ByteArrayInputStream(m.getArtWork())),200,200));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public JButton getB() {
        return b;
    }

    public Music getM() {
        return m;
    }
}
