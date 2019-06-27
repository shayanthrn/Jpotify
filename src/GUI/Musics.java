package GUI;

import Logic.Albums;
import Logic.Music;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Musics extends JPanel {

    public Musics(){
        super();
        setLayout(new GridLayout(2,3,10,-20));
        setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 20));
        setBackground(new Color(60, 60, 60));
        setVisible(true);
    }
    public void ShowHome(){
       this.removeAll();
       LinkedList<Music> musicLinkedList=new LinkedList<>();
       musicLinkedList.add(new Music("./behnam.mp3"));
        for(Music music:musicLinkedList){
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
        Main.getF().revalidate();
        Main.getF().repaint();
    }
    public void ShowSongs(){
        this.removeAll();
        for(Music music:Main.MainController.getSongs()){
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
        Main.getF().revalidate();
        Main.getF().repaint();
    }
    public void ShowAlbums(){
        this.removeAll();
        for(Albums albums:Main.MainController.getAlbums()){
            AlbumMusic albumMusic=new AlbumMusic(albums);
            this.add(albumMusic);
        }
        Main.getF().revalidate();
        Main.getF().repaint();
    }
}

