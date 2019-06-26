package Logic;


import GUI.Main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Tests {
    public static void main(String[] args){
        MyPlayer myPlayer=new MyPlayer();
        myPlayer.play("C:\\Users\\Shay\\Desktop\\03 Ramin Djawadi - Light of the Seven.mp3",0);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myPlayer.play("C:\\Users\\Shay\\Desktop\\03 Ramin Djawadi - Light of the Seven.mp3",0.5f);
    }
}
