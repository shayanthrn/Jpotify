package Logic;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Tests {
    public static void main(String[] args){
        MyPlayer m=new MyPlayer();
        m.play("C:\\Users\\Shay\\Desktop\\03 Ramin Djawadi - Light of the Seven.mp3",0.5f);
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m.pause();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m.resume();
        System.out.println(m.getCurrentTime());
    }
}
