package GUI;
import javax.swing.*;
import java.awt.*;

public class SongPlayList extends JPanel{

    JLabel l;

    public SongPlayList(){
        super();
        setVisible(true);
        setLayout(new GridLayout(5,1,10,-10));
        setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        setBackground(new Color(60, 60, 60));

        l = new JLabel();
        l.setText("All Your Song ");
        l.setForeground(Color.WHITE);
        l.setFont(new Font("Arial",Font.BOLD,20));


        add(l,BorderLayout.CENTER);


    }
}
