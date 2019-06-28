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
        setLayout(new GridLayout(((int) (Main.MainController.getSongs().size() / 2)),2,10,-20));
        setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 20));
        setBackground(new Color(60, 60, 60));
        setVisible(true);
    }
    public void ShowHome(){
       this.removeAll();
        setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 20));
        setBackground(new Color(60, 60, 60));
        setLayout(new GridLayout(((int) (Main.MainController.getPlayLists().get(1).getSongs().size() / 2)),2,10,-20)); //todo
        for(Music music:Main.MainController.getPlayLists().get(1).getSongs()){
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
        setLayout(new GridLayout(((int) (Main.MainController.getSongs().size() / 2)),2,10,-20));
        setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 20));
        setBackground(new Color(60, 60, 60));
        for(Music music:Main.MainController.getSongs()){
            AlbumMusic albumMusic=new AlbumMusic(music);
            albumMusic.getB().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.MainController.setNowplaying(albumMusic.getM());
                    Main.MainController.setMusicque(Main.MainController.getSongs().listIterator(Main.MainController.getSongs().indexOf(Main.MainController.getNowplaying())));
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
        setLayout(new GridLayout(((int) Main.MainController.getAlbums().size()/2),2,10,-20));
        setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 20));
        setBackground(new Color(60, 60, 60));
        for(Albums albums:Main.MainController.getAlbums()){
            AlbumMusic albumMusic=new AlbumMusic(albums);
            albumMusic.getB().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.f.getSpl().ShowAlbum(albums);
                }
            });
            this.add(albumMusic);
        }
        Main.getF().revalidate();
        Main.getF().repaint();
    }
    PlayList mainplaylist=null;
    public void ShowPlaylist(String Playlistname) {
        if(!Playlistname .equals( "null")){
            for(PlayList p:Main.MainController.getPlayLists()){
                if(p.getName().equals(Playlistname)){
                    mainplaylist=p;
                }
            }
            this.removeAll();
            this.setLayout(new BorderLayout());
            JPanel top=new JPanel();
            top.setLayout(new GridLayout(1,3));
            JButton addmusic=new JButton("add");
            JButton swapmusic=new JButton("swap");
            JButton removemusic=new JButton("remove");
            JButton changename = new JButton("changeName");
            JDialog changenamedia = new JDialog();
            JDialog addmusicdia=new JDialog();
            JDialog swapmusicdia=new JDialog();
            JDialog removemusicdia=new JDialog();
            DefaultListModel<Music> listModel=new DefaultListModel<>();
            for(Music m:Main.MainController.getSongs()){
                listModel.addElement(m);
            }
            JList<Music> addmuslist=new JList<Music>(listModel);
            addmusicdia.setSize(400,200);
            addmusicdia.setLocation(200,200);
            addmusicdia.setBackground(new Color(60,60,60));
            addmusicdia.setForeground(new Color(60,60,60));
            addmusicdia.setLayout(new BorderLayout());
            swapmusicdia.setSize(400,200);
            swapmusicdia.setLocation(200,200);
            swapmusicdia.setBackground(new Color(61,60,60));
            swapmusicdia.setForeground(new Color(62,60,60));
            swapmusicdia.setLayout(new BorderLayout());
            removemusicdia.setSize(400,200);
            removemusicdia.setLocation(200,200);
            removemusicdia.setBackground(new Color(60,60,60));
            removemusicdia.setForeground(new Color(62,60,60));
            removemusicdia.setLayout(new BorderLayout());
            addmuslist.setBackground(new Color(60,60,60));
            addmuslist.setForeground(Color.WHITE);
            addmusicdia.add(addmuslist,BorderLayout.CENTER);
            changenamedia.setSize(400,200);
            changenamedia.setLocation(200,200);
            changenamedia.setBackground(new Color(60,60,60));
            changenamedia.setForeground(new Color(62,60,60));
            changenamedia.setLayout(new BorderLayout());
            JSpinner jpinner1=new JSpinner();
            JSpinner jSpinner=new JSpinner();
            JSpinner jSpinner2=new JSpinner();
            removemusicdia.add(jSpinner,BorderLayout.CENTER);
            JPanel jPanel=new JPanel();
            jPanel.add(jpinner1);
            jPanel.add(jSpinner2);
            swapmusicdia.add(jPanel);
            JButton selectadd=new JButton("select");
            selectadd.setForeground(Color.WHITE);
            selectadd.setBackground(new Color(70,70,70));
            JButton selectswap=new JButton("select");
            selectswap.setForeground(Color.WHITE);
            selectswap.setBackground(new Color(70,70,70));
            JButton selectremove=new JButton("select");
            selectremove.setForeground(Color.WHITE);
            selectremove.setBackground(new Color(70,70,70));
            JButton okchangename=new JButton("ok");
            okchangename.setForeground(Color.WHITE);
            okchangename.setBackground(new Color(70,71,70));
            JButton cansel=new JButton("cansel");
            JButton cansel1=new JButton("cansel");
            JButton cansel2=new JButton("cansel");
            JButton cansel3=new JButton("cansel");
            cansel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addmusicdia.dispose();
                }
            });
            cansel1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    swapmusicdia.dispose();
                }
            });
            cansel2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removemusicdia.dispose();
                }
            });
            cansel3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    changenamedia.dispose();
                }
            });
            JTextField changetext = new JTextField();
            changenamedia.add(changetext,BorderLayout.CENTER);
            removemusicdia.add(cansel2,BorderLayout.WEST);
            swapmusicdia.add(cansel1,BorderLayout.WEST);
            swapmusicdia.add(selectswap,BorderLayout.EAST);
            removemusicdia.add(selectremove,BorderLayout.EAST);
            changenamedia.add(okchangename,BorderLayout.EAST);
            changenamedia.add(cansel3,BorderLayout.WEST);
            cansel.setForeground(Color.WHITE);
            cansel.setBackground(new Color(70,70,70));
            cansel1.setForeground(Color.WHITE);
            cansel1.setBackground(new Color(70,71,70));
            cansel2.setForeground(Color.WHITE);
            cansel2.setBackground(new Color(71,70,70));
            cansel3.setBackground(new Color(69,70,70));
            cansel3.setForeground(Color.WHITE);
            addmusicdia.add(selectadd,BorderLayout.EAST);
            addmusicdia.add(cansel,BorderLayout.WEST);
            addmusic.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addmusicdia.setVisible(true);
                }
            });
            swapmusic.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    swapmusicdia.setVisible(true);
                }
            });
            removemusic.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removemusicdia.setVisible(true);
                }
            });
            changename.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    changenamedia.setVisible(true);
                }
            });
            top.add(addmusic);
            top.add(swapmusic);
            top.add(changename);
            top.add(removemusic);
            top.setBackground(new Color(60,60,60));
            this.add(top,BorderLayout.PAGE_START);
            JPanel bot=new JPanel();
            addmuslist.setSelectionMode(0);
            bot.setBackground(new Color(50,50,50));
                bot.setLayout(new GridLayout(((int) (mainplaylist.getSongs().size() / 2)),2,10,-20));
                bot.setLayout(new GridLayout(2,2,10,-20));
            for(PlayList playList:Main.MainController.getPlayLists()){
                if(playList.getName().equals(Playlistname)){
                    mainplaylist=playList;
                }
            }
            selectadd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainplaylist.add(addmuslist.getSelectedValue());
                    Main.getF().getSpl().ShowPlaylist(mainplaylist.getName());
                    addmusicdia.dispose();
                }
            });
            okchangename.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainplaylist.setName(changetext.getText());
                    Main.getF().getSpl().ShowPlaylist(mainplaylist.getName());
                    changenamedia.dispose();
                }
            });
            selectremove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainplaylist.remove(mainplaylist.getSongs().get((Integer) jSpinner.getValue()));
                    Main.getF().getSpl().ShowPlaylist(mainplaylist.getName());
                    removemusicdia.dispose();
                }
            });
            selectswap.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainplaylist.swap(mainplaylist.getSongs().get((Integer) jpinner1.getValue()),mainplaylist.getSongs().get((Integer) jSpinner2.getValue()));
                    Main.getF().getSpl().ShowPlaylist(mainplaylist.getName());
                    swapmusicdia.dispose();
                }
            });
            this.add(bot,BorderLayout.CENTER);
            for(Music m:mainplaylist.getSongs()){
                AlbumMusic albumMusic=new AlbumMusic(m,mainplaylist.getSongs().indexOf(m));
                bot.add(albumMusic);
            }
            Main.getF().revalidate();
            Main.getF().repaint();
        }
    }
    public void ShowAlbum(Albums albums){
        this.removeAll();
        setLayout(new GridLayout(((int) (albums.getSongs().size() / 2)),2,10,-20));
        setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 20));
        setBackground(new Color(61, 60, 60));
        for(Music music:albums.getSongs()){
            AlbumMusic albumMusic=new AlbumMusic(music);
            albumMusic.getB().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.MainController.setNowplaying(albumMusic.getM());
                    Main.MainController.setMusicque(albums.getSongs().listIterator(albums.getSongs().indexOf(albumMusic.getM())));
                    Main.mainPlayer.play(albumMusic.getM().getPath(),0);
                }
            });
            this.add(albumMusic);
        }
        Main.getF().revalidate();
        Main.getF().repaint();
    }
}

