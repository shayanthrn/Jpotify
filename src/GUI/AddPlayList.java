package GUI;
import Logic.PlayList;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class AddPlayList extends JDialog implements ActionListener {

    String name_PlayList = "palyList1";
    String path_playList = "./assets/image/Default.jpg";
    private final int WIDTH = 400, HEIGHT = 200;
    private final int X = 200, Y = 200;
    JTextField namePlayList;
    JFileChooser playListPicture;
    JButton B;
    JButton ok;
    JButton cancel;
    ImageIcon img ;

    public AddPlayList() {
        super(Main.getF(), "Create PlayList");
        namePlayList = new JTextField();
        playListPicture = new JFileChooser();
        B = new JButton();
        ok = new JButton();
        cancel = new JButton();
//        img = new ImageIcon("./assets/image/Default.jpg");

        this.setLayout(new GridLayout(2, 2,20,30));
        this.setLocation(X, Y);
        this.setSize(WIDTH, HEIGHT);
        setBackground(new Color(60, 60, 60));

        namePlayList.setFont(new Font("Lato", Font.PLAIN, 14));
        namePlayList.setPreferredSize(new Dimension(100, 10));
        setVisible(true);

        B = new JButton(new ImageIcon("./assets/image/plus.png"));
        B.setBorder(null);
        B.setForeground(Color.white);
        B.setHorizontalAlignment(SwingConstants.LEFT);
        B.setFont(new Font("Arial", Font.PLAIN, 14));
        B.setBorderPainted(false);
        B.setContentAreaFilled(true);
        B.setBackground(new Color(49, 49, 49));
        B.setOpaque(false);
        B.setIconTextGap(5);
        B.setPreferredSize(new Dimension(50, 20));
        B.setText("Choose PlayList Picture");
        B.addActionListener(this);

        ok.setBorderPainted(false);
        ok.setBackground(new Color(100, 100, 100));
        ok.setText("OK");
        ok.setContentAreaFilled(true);
        ok.setPreferredSize(new Dimension(50, 20));
        ok.addActionListener(this);

        cancel.setBorderPainted(false);
        cancel.setBackground(new Color(100, 100, 100));
        cancel.setText("Cansel");
        cancel.setContentAreaFilled(true);
        cancel.setPreferredSize(new Dimension(50, 20));
        cancel.addActionListener(this);

        add(namePlayList);
        add(B);
        add(cancel);
        add(ok);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == B) {
            int result = playListPicture.showOpenDialog(this);
            if(result == JFileChooser.APPROVE_OPTION){
                File selectedFile = playListPicture.getSelectedFile();
                path_playList = selectedFile.getAbsolutePath();
            }
        }
        if(e.getSource() == ok) {
            if (!namePlayList.getText().equals("")) {
                name_PlayList = namePlayList.getText();
            }
            PlayList created_playlist = new PlayList(name_PlayList,true,true,path_playList);
            Main.MainController.NewPlaylist(created_playlist);
            JspitiFrame.sp.addPlaylist(created_playlist);

            this.dispose();

        }
        if(e.getSource() == cancel) {
            this.dispose();
        }


    }


}
