package Logic;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.*;

public class MyPlayer {
    private FileInputStream FIS;
    private BufferedInputStream BIS;
    private long PauseLocation;
    private long TotalSongLenght;
    private Player player;
    private String Path;
    private Thread playThread=new Thread(){
        @Override
        public void run() {
            try {
                while (!interrupted())
                    player.play();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }
            player.close();
        }
    };

    public MyPlayer() {
        FIS=null;
        BIS=null;
        player=null;
        PauseLocation=0;
        TotalSongLenght=0;
        Path=null;
    }

    public long getPauseLocation() {
        return PauseLocation;
    }

    public long getTotalSongLenght() {
        return TotalSongLenght;
    }

    public void pause(){
        if(player!=null) {
            try {
                PauseLocation = FIS.available();
            } catch (IOException e) {
                e.printStackTrace();
            }
            player.close();
        }
    }
    public void resume(){
        try {
            FIS=new FileInputStream(Path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BIS=new BufferedInputStream(FIS);
        try {
            FIS.skip(TotalSongLenght-PauseLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            player=new Player(FIS);
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
        playThread.start();
    }
    public void Stop(){
        player.close();
    }
    public void play(String Path,long Start){
        try {
            this.Path=Path;
            try {
                FIS=new FileInputStream(Path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                TotalSongLenght=FIS.available();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                FIS.skip(Start);                // bug dare
            } catch (IOException e) {
                e.printStackTrace();
            }
            BIS=new BufferedInputStream(FIS);
            player = new Player(BIS);
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
        playThread.start();
    }
}
