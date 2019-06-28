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
        this.setLayout(new GridLayout(7,1));
        this.setPreferredSize(new Dimension(160,20));
        setBackground(new Color(50, 50, 50));
        JLabel label = new JLabel("Friend Activity");
        label.setFont(new Font("Arial",Font.BOLD,14));
        label.setForeground(Color.WHITE);
        this.add(label);
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
    public void updateFriends(String client,String Albumename,String Musicname){
        Main.MainController.getFreiends().get(client).setText(""+client+"\n"+Albumename+"\n"+Musicname);
        Main.MainController.getFreiends().get(client).setBackground(new Color(60,60,60));
        Main.MainController.getFreiends().get(client).setForeground(Color.WHITE);
        Main.MainController.getFreiends().get(client).setEditable(false);
        Main.MainController.getFreiends().get(client).setPreferredSize(new Dimension(200,40));
        add(Main.MainController.getFreiends().get(client));
    }
}
