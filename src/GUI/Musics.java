package GUI;

import Logic.Albums;
import Logic.Music;
import Logic.PlayList;

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

    public void ShowPlaylist(String Playlistname) {
        if(!Playlistname .equals( "null")){
            this.removeAll();
            this.setLayout(new BorderLayout());
            JPanel top=new JPanel();
            top.setLayout(new GridLayout(1,3));
            JButton addmusic=new JButton("add");
            JButton swapmusic=new JButton("swap");
            JButton removemusic=new JButton("remove");
            top.add(addmusic);
            top.add(swapmusic);
            top.add(removemusic);
            top.setBackground(new Color(60,60,60));
            this.add(top,BorderLayout.PAGE_START);
            JPanel bot=new JPanel();
            bot.setBackground(new Color(50,50,50));
            JLabel l=new JLabel(Playlistname);
            l.setForeground(Color.WHITE);
            bot.add(l);
            this.add(bot,BorderLayout.CENTER);
            Main.getF().revalidate();
            Main.getF().repaint();
        }
    }
}

