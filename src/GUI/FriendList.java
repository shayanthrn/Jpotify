package GUI;

import javax.swing.*;
import java.awt.*;

public class FriendList extends JPanel {

    String user;
    private DefaultListModel model;
    private JList list;

    public FriendList(){
        super();
        user = null;
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(160,20));
        setBackground(new Color(50, 50, 50));
        JLabel label = new JLabel("Friend Activity");
        label.setFont(new Font("Arial",Font.BOLD,14));

        label.setForeground(Color.WHITE);
        this.add(label, BorderLayout.PAGE_START);

        model = new DefaultListModel();
        list = new JList(model);
        list.setBackground(new Color(50, 50, 50));
        list.setForeground(Color.WHITE);

        this.add(list);

    }

    // Initialize the list with users
    public void addUser(String user) {
        model.addElement(user);
    }

    public void removeUser(String user) {
        model.removeElement(user);
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }
}
