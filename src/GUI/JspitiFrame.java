package GUI;

import Logic.IOClass;
import Logic.Music;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class JspitiFrame extends JFrame {

    private final String WINDOWS_TITLE = "Jpotify";
    private final int WIDTH = 1000, HEIGHT = 600;
    private final int X = 100, Y = 100;

    String user;
    MusicBar MBar = new MusicBar();
    static SidePanel sp = new SidePanel();
    FriendList fl = new FriendList();
    SearchBar Search = new SearchBar();
    Musics Spl = new Musics();

    public JspitiFrame() {
        super();
        user = "Parham\nSansor\n";

        this.setLocation(X, Y);
        this.setSize(WIDTH, HEIGHT);
        this.setTitle(WINDOWS_TITLE);
        this.setLayout(new BorderLayout());
        setBackground(new Color(60, 60, 60));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(sp, BorderLayout.WEST);
        this.add(MBar, BorderLayout.SOUTH);
        this.add(Search, BorderLayout.PAGE_START);
        this.add(new JScrollPane(fl), BorderLayout.EAST);
        this.add(new JScrollPane(Spl), BorderLayout.CENTER);
        Spl.setVisible(true);
        this.setVisible(true);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                IOClass.saveAlbums(Main.MainController.getAlbums());
                IOClass.savePlaylists(Main.MainController.getPlayLists());
                IOClass.saveSongs(Main.MainController.getSongs());
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public Musics getSpl() {
        return Spl;
    }
    public void setUser(String s) {
        fl.addUser("Parham " + "\n" + "Tm_Bax " + "\n" + "Sansor ");
    }
    public MusicBar getMBar() {
        return MBar;
    }
}
