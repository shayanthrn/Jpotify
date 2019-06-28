package GUI;

import Logic.*;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class  Main {

    public static JspitiFrame f;
    public static Controller MainController= new Controller();
    public static MyPlayer mainPlayer=new MyPlayer();

    public static JspitiFrame getF() {
        return f;
    }

    public static void main(String[] args) {
        JTextArea friendMusic = new JTextArea();
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
        MainController.getIP_Address().put("Paye_Band","127.0.0.1");
        MainController.getIP_Address().put("Haude","128.0.0.1");
        MainController.getFreiends().put("Paye_Band",friendMusic);
        MainController.getFreiends().put("Haude",friendMusic);

        try {
            new Thread() {
                @Override
                public void run() {
                    SendServer client= new SendServer();
                }
            }.start();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("server Created");
        GetServer server = new GetServer();
        server.start();
        while (true){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!server.isAlive()){
                server = new GetServer();
                server.start();
            }
        }
    }



}



