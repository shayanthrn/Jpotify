package GUI;

import Logic.Music;
import Logic.PlayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidePanel extends JPanel implements ActionListener {
    private JLabel imagePanel;
    private JButton home;
    private JButton songs;
    private JButton albums;
    private JButton add;
    private JButton addPlayList;
    private JLabel playlist_label;
    private JLabel library_label;
    DefaultListModel model;
    JList listofplaylists;

    public SidePanel() {
        setPreferredSize(new Dimension(200, 600));
        setLayout(new GridLayout(10, 1));
        setBackground(new Color(50, 50, 50));
        model = new DefaultListModel();
        listofplaylists = new JList(model);
        home = new JButton(new ImageIcon("image/Capture_32x32.png"));
        home.setBorder(null);
        home.setForeground(Color.white);
        home.setHorizontalAlignment(SwingConstants.LEFT);
        home.setFont(new Font("Arial", Font.PLAIN, 14));
        home.setBorderPainted(false);
        home.setContentAreaFilled(true);
        home.setBackground(new Color(50, 50, 50));
        home.setOpaque(false);
        home.setIconTextGap(5);
        home.setPreferredSize(new Dimension(200, 50));
        home.setText("Home");
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getF().getSpl().ShowHome();
            }
        });


        JSeparator sep1 = new JSeparator();
        sep1.setOrientation(SwingConstants.VERTICAL);
        sep1.setMaximumSize(new Dimension(200, 2));
        sep1.setVisible(false);


        add = new JButton(new ImageIcon("./completed.png"));
        add.setBorder(null);
        add.setForeground(Color.white);
        add.setHorizontalAlignment(SwingConstants.LEFT);
        add.setFont(new Font("Arial", Font.PLAIN, 14));
        add.setBorderPainted(false);
        add.setContentAreaFilled(true);
        add.setBackground(new Color(49, 49, 49));
        add.setOpaque(false);
        add.setIconTextGap(5);
        add.setPreferredSize(new Dimension(200, 50));
        add.setText("Add To Library");
        add.addActionListener(this);


        addPlayList = new JButton(new ImageIcon("./assets/image/plus.png"));
        addPlayList.setBorder(null);
        addPlayList.setForeground(Color.white);
        addPlayList.setHorizontalAlignment(SwingConstants.LEFT);
        addPlayList.setFont(new Font("Arial", Font.PLAIN, 14));
        addPlayList.setBorderPainted(false);
        addPlayList.setContentAreaFilled(true);
        addPlayList.setBackground(new Color(49, 49, 49));
        addPlayList.setOpaque(false);
        addPlayList.setIconTextGap(5);
        addPlayList.setPreferredSize(new Dimension(200, 50));
        addPlayList.setText("Add PlayList");
        addPlayList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddPlayList addPlayList = new AddPlayList();

            }
        });

        songs = new JButton(new ImageIcon("./completed.png"));
        songs.setBorder(null);
        songs.setForeground(Color.white);
        songs.setHorizontalAlignment(SwingConstants.LEFT);
        songs.setFont(new Font("Arial", Font.PLAIN, 14));
        songs.setBorderPainted(false);
        songs.setContentAreaFilled(true);
        songs.setBackground(new Color(49, 49, 49));
        songs.setOpaque(false);
        songs.setIconTextGap(5);
        songs.setPreferredSize(new Dimension(200, 50));
        songs.setText("Songs");
        songs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.f.getSpl().ShowSongs();
            }
        });

        albums = new JButton(new ImageIcon("com/company/queue.png"));
        albums.setBorder(null);
        albums.setForeground(Color.white);
        albums.setHorizontalAlignment(SwingConstants.LEFT);
        albums.setFont(new Font("Arial", Font.PLAIN, 14));
        albums.setBorderPainted(false);
        albums.setContentAreaFilled(true);
        albums.setBackground(new Color(49, 49, 49));
        albums.setOpaque(false);
        albums.setIconTextGap(5);
        albums.setPreferredSize(new Dimension(200, 50));
        albums.setText("Albums");
        albums.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getF().getSpl().ShowAlbums();
            }
        });

        playlist_label = new JLabel(" Playlists");
        playlist_label.setFont(new Font("Lato", Font.PLAIN, 15));
        playlist_label.setForeground(Color.white);

        library_label = new JLabel(" Your Library");
        library_label.setFont(new Font("Lato", Font.PLAIN, 15));
        library_label.setForeground(Color.white);

//        list of playlist

        listofplaylists.setBackground(new Color(50, 50, 50));
        listofplaylists.setBorder(null);
        listofplaylists.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listofplaylists.setDragEnabled(false);
        listofplaylists.setCellRenderer(new PlayListRenderer());
        listofplaylists.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Main.f.getSpl().ShowPlaylist(listofplaylists.getSelectedValue()+"");
                listofplaylists.clearSelection();
            }
        });
        for(PlayList p:Main.MainController.getPlayLists()){
            model.addElement(p);
        }
        add(home);
        add(sep1);
        add(library_label);
        add(add);
        add(songs);
        add(albums);
        add(playlist_label);
        add(addPlayList);
        add(new JScrollPane(listofplaylists));
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            JFileChooser jf = new JFileChooser();
            int result = jf.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                Music music = new Music(jf.getSelectedFile().getAbsolutePath());
                Main.MainController.addToLibrary(music);
                Main.getF().getSpl().ShowSongs();
            }
        }
    }

    public void addPlaylist(PlayList playList) {
        model.addElement(playList);
    }
}
