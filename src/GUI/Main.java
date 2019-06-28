package GUI;

import Logic.Controller;
import Logic.Music;
import Logic.MyPlayer;
import Logic.PlayList;

import javax.swing.*;
import java.awt.*;

public class  Main {

    public static JspitiFrame f;
    public static Controller MainController= new Controller();
    public static MyPlayer mainPlayer=new MyPlayer();

    public static JspitiFrame getF() {
        return f;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(laf.getName())) {
                        UIManager.setLookAndFeel(laf.getClassName());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            f = new JspitiFrame();
            f.setUser("ss");
        });


    }



}



