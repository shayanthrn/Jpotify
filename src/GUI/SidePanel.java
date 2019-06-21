package GUI;
import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidePanel extends JPanel implements ActionListener{
    private JLabel imagePanel;
    private JButton home;
    private JButton songs;
    private JButton albums;
    private JButton add;
    private JButton addPlayList;
    private JLabel playlist_label;
    private JLabel library_label;

    public SidePanel() {
        setPreferredSize(new Dimension(200, 600));
        setLayout(new GridLayout(10,1));
        setBackground(new Color(50, 50, 50));
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


        JSeparator sep1 = new JSeparator();
        sep1.setOrientation(SwingConstants.VERTICAL);
        sep1.setMaximumSize(new Dimension(200,2));
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
        add.setText("Add Song");
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
        addPlayList.addActionListener(this);

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
        songs.addActionListener(this);

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

        playlist_label = new JLabel(" Playlists");
        playlist_label.setFont(new Font("Lato" , Font.PLAIN , 15));
        playlist_label.setForeground(Color.white);

        library_label = new JLabel(" Your Library");
        library_label.setFont(new Font("Lato" , Font.PLAIN , 15));
        library_label.setForeground(Color.white);

//        list of playlist
        DefaultListModel model = new DefaultListModel();
        JList countryList = new JList(model);
        countryList.setBackground(new Color(50, 50, 50));
        countryList.setBorder(null);

        add(home);
        add(sep1);
        add(library_label);
        add(add);
        add(songs);
        add(albums);
        add(playlist_label);
        add(addPlayList);
        add(new JScrollPane(countryList));
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addPlayList) {
            AddPlayList addPlayList = new AddPlayList();
        }
        if(e.getSource() == songs){
            JspitiFrame.getSpl().setVisible(true);
            JspitiFrame.getMusic().setVisible(false);
        }
        if(e.getSource() == home){
            JspitiFrame.getSpl().setVisible(false);
            JspitiFrame.getMusic().setVisible(true);
        }


    }
}
