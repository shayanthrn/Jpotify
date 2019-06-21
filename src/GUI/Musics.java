package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Musics extends JPanel implements ActionListener {

    AlbumMusic M1;
    AlbumMusic M2;
    AlbumMusic M3;
    AlbumMusic M4;
    AlbumMusic M5;

    public Musics(){
        super();
        setLayout(new GridLayout(2,3,10,-20));
        setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 20));
        setBackground(new Color(60, 60, 60));
        setVisible(true);

        M1 = new AlbumMusic();
        M2 = new AlbumMusic();
        M3 = new AlbumMusic();
        M4 = new AlbumMusic();
        M5 = new AlbumMusic();

        M1.setMusic_name("Mosaic");
        M1.setPath("./assets/image/Mosaic.jpg");
        M2.setMusic_name("Havana");
        M2.setPath("./assets/image/havana.jpg");
        M3.setMusic_name("Reputation");
        M3.setPath("./assets/image/Reputation.png");
        M4.setMusic_name("Jane Javani");
        M4.setPath("./assets/image/jane_javani.png");
        M5.setMusic_name("Kenya_East");
        M5.setPath("./assets/image/kenya_east.png");


        M1.getB().addActionListener(this);
        M2.getB().addActionListener(this);
        M3.getB().addActionListener(this);
        M4.getB().addActionListener(this);
        M5.getB().addActionListener(this);


        this.add(M1);
        this.add(M2);
        this.add(M3);
        this.add(M4);
        this.add(M5);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == M1.getB()){

        }
        if(e.getSource() == M2.getB()){

        }
        if(e.getSource() == M3.getB()){

        }
        if(e.getSource() == M4.getB()){

        }
        if(e.getSource() == M5.getB()){

        }
    }
}

