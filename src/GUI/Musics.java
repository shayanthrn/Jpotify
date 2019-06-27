package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Musics extends JPanel {

    AlbumMusic M1;
    AlbumMusic M2;
    AlbumMusic M3;
    AlbumMusic M4;
    AlbumMusic M5;

    public Musics(){
        super();
        setLayout(new GridLayout(2,3,10,-20));
        setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 20));
        setBackground(new Color(60, 60, 60));
        setVisible(true);



    }
}

