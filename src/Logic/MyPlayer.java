package Logic;

import GUI.Main;
import GUI.Utils;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Map;

public class MyPlayer {
    private FileInputStream FIS;
    private BufferedInputStream BIS;
    private long PauseLocation;
    private long TotalSongLenght;
    private long currentTime;
    private Player player;
    private String Path;

    public long getTotalTime() {
        Mp3File mp3File = null;
        try {
            mp3File = new Mp3File(Path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedTagException e) {
            e.printStackTrace();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
        return mp3File.getLengthInSeconds();
    }

    public long getCurrentTime() {
        Mp3File mp3File = null;
        try {
            mp3File = new Mp3File(Path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedTagException e) {
            e.printStackTrace();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
        long temp = 0;
        try {
            temp = FIS.available();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (long) (((TotalSongLenght - temp - mp3File.getStartOffset()) / (float) (mp3File.getEndOffset() - mp3File.getStartOffset())) * mp3File.getLengthInSeconds());
    }

    public MyPlayer() {
        FIS = null;
        BIS = null;
        player = null;
        PauseLocation = 0;
        TotalSongLenght = 0;
        Path = null;
    }

    public long getPauseLocation() {
        return PauseLocation;
    }

    public long getTotalSongLenght() {
        return TotalSongLenght;
    }

    public void pause() {
        if (player != null) {
            try {
                PauseLocation = FIS.available();
            } catch (IOException e) {
                e.printStackTrace();
            }
            player.close();
        }
    }

    public void resume() {
        if (player != null)
            player.close();
        try {
            FIS = new FileInputStream(Path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BIS = new BufferedInputStream(FIS);
        try {
            FIS.skip(TotalSongLenght - PauseLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            player = new Player(FIS);
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
        new Thread() {
            @Override
            public void run() {
                try {
                    Main.f.getMBar().getMt1().getTotalTime().setText(Main.mainPlayer.getTotalTime()+"");
                    while(player.play(1)){
                        Main.f.getMBar().getMt1().getCurrentTimel().setText(Main.mainPlayer.getCurrentTime()+"");
                        Main.f.getMBar().getMt1().getTimeslider().setValue((int) ((Main.mainPlayer.getCurrentTime()/(float)Main.mainPlayer.getTotalTime())*100));
                    }
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
                player.close();
            }
        }.start();
    }

    public void Stop() {
        player.close();
    }

    public void play(String Path, float Start) {
        if (player != null)
            player.close();
        long songlenghtbyte;
        Mp3File mp3File = null;
        JButton play=Main.getF().getMBar().getMb1().getPlay();
        ImageIcon pus;
        Main.getF().getMBar().getMb1().setFlagPlay(1);
        pus = new ImageIcon("./assets/image/pause.png");
        play.setIcon(pus);
        play.setRolloverIcon(pus);
        try {
            mp3File = new Mp3File(Path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedTagException e) {
            e.printStackTrace();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
        try {
            this.Path = Path;
            try {
                FIS = new FileInputStream(Path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                TotalSongLenght = FIS.available();
            } catch (IOException e) {
                e.printStackTrace();
            }
            songlenghtbyte = mp3File.getEndOffset() - mp3File.getStartOffset();
            try {
                FIS.skip((long) (Start * songlenghtbyte) + mp3File.getStartOffset());
            } catch (IOException e) {
                e.printStackTrace();
            }
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
        try {
            Main.getF().getMBar().getMp1().setLabel_pic(Utils.resize(ImageIO.read(new ByteArrayInputStream(new Music(Path).getArtWork())),30,30));
            Main.getF().getMBar().getMp1().setLabel_name(new Music(Path).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread() {
            @Override
            public void run() {
                try {
                    Main.f.getMBar().getMt1().getTotalTime().setText(Main.mainPlayer.getTotalTime()+"");
                    while(player.play(1)){
                        Main.f.getMBar().getMt1().getCurrentTimel().setText(Main.mainPlayer.getCurrentTime()+"");
                        Main.f.getMBar().getMt1().getTimeslider().setValue((int) ((Main.mainPlayer.getCurrentTime()/(float)Main.mainPlayer.getTotalTime())*100));
                    }
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
                player.close();
            }
        }.start();
    }

    public void changeVoloum(Float voloum) {
        if (AudioSystem.isLineSupported((Port.Info.SPEAKER))) {
            try {
                Port outline = (Port) AudioSystem.getLine(Port.Info.SPEAKER);
                outline.open();
                FloatControl voloumControl = (FloatControl) outline.getControl(FloatControl.Type.VOLUME);
                voloumControl.setValue(voloum);                         // shayad niaz bashe kamtar az ye mqdari 0 she
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
        }
    }
}
