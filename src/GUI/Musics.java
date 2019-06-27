package GUI;

import Logic.Music;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Musics extends JPanel {

//    Music m1;
//    Music m2;
//    Music m3;
//    AlbumMusic M1;
//    AlbumMusic M2;
//    AlbumMusic M3;
//    AlbumMusic M4;
//    AlbumMusic M5;



//    private ArrayList<AlbumMusic> musics;

    public Musics(LinkedList<Music> songs){
        super();
//        musics =list;
        setLayout(new GridLayout(2,3,10,-20));
        setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 20));
        setBackground(new Color(60, 60, 60));
        for(Music music:songs){
            AlbumMusic albumMusic=new AlbumMusic(music);
            albumMusic.getB().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.MainController.setNowplaying(albumMusic.getM());
                    Main.mainPlayer.play(albumMusic.getM().getPath(),0);
                }
            });
            this.add(albumMusic);
        }

    }
}

