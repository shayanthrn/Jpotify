package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class JspitiFrame extends JFrame {

    private final String WINDOWS_TITLE = "Jpotify";
    private final int WIDTH = 1000, HEIGHT = 600;
    private final int X = 100, Y = 100;

    String user;
    MusicBar MBar = new MusicBar();
    SidePanel sp = new SidePanel();
    FriendList fl = new FriendList();
    SearchBar Search = new SearchBar();
    static Musics Music = new Musics();
    static SongPlayList Spl = new SongPlayList();


    public JspitiFrame() {
        super();
        user = "Parham\n Tm_Bax \n Sansor";

        this.setLocation(X, Y);
        this.setSize(WIDTH, HEIGHT);
        this.setTitle(WINDOWS_TITLE);
        this.setLayout(new BorderLayout());
        setBackground(new Color(60, 60, 60));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(sp, BorderLayout.WEST);
        this.add(fl, BorderLayout.EAST);
        this.add(Spl, BorderLayout.CENTER);
        this.add(MBar, BorderLayout.SOUTH);
        this.add(Music, BorderLayout.CENTER);
        this.add(Search, BorderLayout.PAGE_START);

//        Music.setVisible(false);
        Spl.setVisible(false);
        this.setVisible(true);
    }

    public void setUser(String s) {
//        fl.setUser(s);
        fl.addUser("Parham " + "\n" + "Tm_Bax " + "\n" + "Sansor ");
    }

    public static Musics getMusic() {
        return Music;
    }

    public static SongPlayList getSpl() {
        return Spl;
    }

    public MusicBar getMBar() {
        return MBar;
    }
}
