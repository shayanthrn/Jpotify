package GUI;

import Logic.Albums;
import Logic.Music;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;


public class AlbumMusic extends JPanel {

    String name;
    JButton b;
    JLabel l;
    Music m;
    Albums album;

    public AlbumMusic(Music m){

        name = m.getName();
        this.m = m;
        name = m.getName();
        this.setVisible(true);
        setLayout(new GridLayout(2,1,-30,-40));
        setBackground(new Color(60, 60, 60));
        setPreferredSize(new Dimension(300,300));

        try {
            b = new JButton(Utils.resize(ImageIO.read(new ByteArrayInputStream(m.getArtWork())),200,200));
        } catch (IOException e) {
            e.printStackTrace();
        }
        l = new JLabel(name);

        b.setBorder(null);
        b.setContentAreaFilled(false);

        l.setForeground(Color.WHITE);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setFont(new Font("Arial",Font.BOLD,16));

        this.add(b);
        this.add(l);

    }
    public AlbumMusic(Albums albums){
        name = albums.getName();
        this.album=albums;
        name = albums.getName();
        this.setVisible(true);
        setLayout(new GridLayout(2,1,-30,-40));
        setBackground(new Color(60, 60, 60));
        setPreferredSize(new Dimension(300,300));
        try {
            b = new JButton(Utils.resize(ImageIO.read(new ByteArrayInputStream(albums.getSongs().get(0).getArtWork())),200,200));
        } catch (IOException e) {
            e.printStackTrace();
        }
        l = new JLabel(name);

        b.setBorder(null);
        b.setContentAreaFilled(false);

        l.setForeground(Color.WHITE);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setFont(new Font("Arial",Font.BOLD,16));

        this.add(b);
        this.add(l);
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
        l.setText(name);
    }
    public JButton getB() {
        return b;
    }

    public Music getM() {
        return m;
    }
}
