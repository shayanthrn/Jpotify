package Logic;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Tests {
    public static void main(String[] args){
        MyPlayer p=new MyPlayer();
        p.play("C:\\Users\\Shay\\Desktop\\03 Ramin Djawadi - Light of the Seven.mp3",350000);
        System.out.println("123");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("456");
        p.pause();
        Scanner sc=new Scanner(System.in);
        int a;
        a=sc.nextInt();
        if(a==1){
            p.resume();
        }
    }
}
