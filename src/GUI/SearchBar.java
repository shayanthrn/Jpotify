package GUI;
import javax.swing.*;
import java.awt.*;

public class SearchBar extends JPanel {


    JLabel l = new JLabel();

    public SearchBar() {
        super();


        this.setLayout(new BorderLayout());

        roundTextField textField = new roundTextField(10);
        setBackground(new Color(60, 60, 60));
        textField.setPreferredSize(new Dimension(10, 30));
        textField.setBackground(new Color(120,120,120));
        textField.setCaretColor(Color.WHITE);
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Lato",Font.PLAIN,14));



        JButton b = new JButton(new ImageIcon("./assets/image/search.png"));
        b.setBorder(null);
        b.setContentAreaFilled(false);

        l.setPreferredSize(new Dimension(700,30));
        l.setBackground(new Color(50,50,50));


        this.add(b,BorderLayout.WEST);
        this.add(textField,BorderLayout.CENTER);
        this.add(l,BorderLayout.EAST);


    }

}
