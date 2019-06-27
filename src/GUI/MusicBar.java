package GUI;

import Logic.Music;
import Logic.MyPlayer;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class MusicBar extends JPanel {
    public MusicBar_picture getMp1() {
        return Mp1;
    }

    public MusicBar_Button2 getMb2() {
        return Mb2;
    }

    public MusicBar_MusicTime getMt1() {
        return Mt1;
    }

     MusicBar_Button Mb1 = new MusicBar_Button();
     MusicBar_picture Mp1 = new MusicBar_picture();
     MusicBar_Button2 Mb2 = new MusicBar_Button2();
     MusicBar_MusicTime Mt1 = new MusicBar_MusicTime();

    public MusicBar() {

        super();
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.add(Mb1, BorderLayout.CENTER);
        this.add(Mp1, BorderLayout.WEST);
        this.add(Mb2, BorderLayout.EAST);
        this.add(Mt1, BorderLayout.SOUTH);
        this.setPreferredSize(new Dimension(900, 60));
        setBackground(new Color(50, 50, 50));

    }

    //build Slider
    public JSlider makeUI() {
        UIDefaults d = new UIDefaults();
        d.put("Slider:SliderTrack[Enabled].backgroundPainter", new Painter<JSlider>() {
            @Override
            public void paint(Graphics2D g, JSlider c, int w, int h) {
                int arc = 15;
                int trackHeight = 7;
                int trackWidth = w - 2;
                int fillTop = 4;
                int fillLeft = 1;

                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g.setStroke(new BasicStroke(1.5f));
                g.setColor(Color.GRAY);
                g.fillRoundRect(fillLeft, fillTop, trackWidth, trackHeight, arc, arc);

                int fillBottom = fillTop + trackHeight;
                int fillRight = xPositionForValue(
                        c.getValue(), c,
                        new Rectangle(fillLeft, fillTop, trackWidth, fillBottom - fillTop));

                g.setColor(Color.GREEN);
                g.fillRect(fillLeft + 1, fillTop + 1, fillRight - fillLeft, fillBottom - fillTop);

                g.setColor(Color.WHITE);
                g.drawRoundRect(fillLeft, fillTop, trackWidth, trackHeight, arc, arc);
            }

            //@see javax/swing/plaf/basic/BasicSliderUI#xPositionForValue(int value)
            protected int xPositionForValue(int value, JSlider slider, Rectangle trackRect) {
                int min = slider.getMinimum();
                int max = slider.getMaximum();
                int trackLength = trackRect.width;
                double valueRange = (double) max - (double) min;
                double pixelsPerValue = (double) trackLength / valueRange;
                int trackLeft = trackRect.x;
                int trackRight = trackRect.x + (trackRect.width - 1);
                int xPosition;

                xPosition = trackLeft;
                xPosition += Math.round(pixelsPerValue * ((double) value - min));

                xPosition = Math.max(trackLeft, xPosition);
                xPosition = Math.min(trackRight, xPosition);

                return xPosition;
            }
        });

        JSlider slider = new JSlider();
        slider.putClientProperty("Nimbus.Overrides", d);
        return slider;

    }

    public MusicBar_Button getMb1() {
        return Mb1;
    }

    class MusicBar_Button extends JPanel implements ActionListener {

        int i = 0;

        JButton play;
        JButton next;
        JButton previous;
        JButton shuffle;
        JButton repeat;
        JButton like;
        int flagPlay=0;

        public int getFlagPlay() {
            return flagPlay;
        }

        public void setFlagPlay(int flagPlay) {
            this.flagPlay = flagPlay;
        }

        public JButton getPlay() {
            return play;
        }

        ImageIcon pla;
        ImageIcon pla1;
        ImageIcon pus;
        ImageIcon elik;
        ImageIcon flike;
        Icon rflike;
        Icon relike;

        public MusicBar_Button() {

            setBackground(new Color(50, 50, 50));
            this.setPreferredSize(new Dimension(100, 60));
            this.setLayout(new GridLayout(1, 6, 6, 3));
            this.setBorder(BorderFactory.createEmptyBorder(0, 150, 0, 155));

            pla = new ImageIcon("./assets/image/play.png");
            pla1 = new ImageIcon("./assets/image/play1.png");
            pus = new ImageIcon("./assets/image/pause.png");
            flike = new ImageIcon("./assets/image/fullHeart.png");
            elik = new ImageIcon("./assets/image/emptyHeart.png");
            rflike = Utils.resize("./assets/image/fullHeart.png", 25, 25);
            relike = Utils.resize("./assets/image/emptyHeart.png", 25, 25);

            play = new JButton(new ImageIcon("./assets/image/play.png"));
            next = new JButton(new ImageIcon("./assets/image/next.png"));
            previous = new JButton(new ImageIcon("./assets/image/previous.png"));
            shuffle = new JButton(new ImageIcon("./assets/image/shuffle.png"));
            repeat = new JButton(new ImageIcon("./assets/image/repeat.png"));
            like = new JButton(new ImageIcon("./assets/image/emptyHeart.png"));

            play.setBorder(null);
            play.setContentAreaFilled(false);
            play.setPressedIcon(new ImageIcon("./assets/image/pause.png"));
            play.setRolloverIcon(new ImageIcon("./assets/image/play1.png"));
            play.addActionListener(this);

            next.setBorder(null);
            next.setContentAreaFilled(false);
            next.setPressedIcon(Utils.resize("./assets/image/next.png", 20, 20));
            next.setRolloverIcon(Utils.resize("./assets/image/next.png", 25, 25));
            next.addActionListener(this);


            previous.setBorder(null);
            previous.setContentAreaFilled(false);
            previous.setPressedIcon(Utils.resize("./assets/image/previous.png", 20, 20));
            previous.setRolloverIcon(Utils.resize("./assets/image/previous.png", 25, 25));
            previous.addActionListener(this);

            shuffle.setBorder(null);
            shuffle.setContentAreaFilled(false);
            shuffle.setPressedIcon(Utils.resize("./assets/image/shuffle.png", 20, 20));
            shuffle.setRolloverIcon(Utils.resize("./assets/image/shuffle.png", 25, 25));
            shuffle.addActionListener(this);


            repeat.setBorder(null);
            repeat.setContentAreaFilled(false);
            repeat.setPressedIcon(Utils.resize("./assets/image/repeat.png", 20, 20));
            repeat.setRolloverIcon(Utils.resize("./assets/image/repeat.png", 25, 25));
            repeat.addActionListener(this);

            like.setBorder(null);
            like.setContentAreaFilled(false);
            like.setPressedIcon(new ImageIcon("./assets/image/fullHeart.png"));
            like.setRolloverIcon(Utils.resize("./assets/image/emptyHeart.png", 25, 25));
            like.addActionListener(this);

            this.add(shuffle);
            this.add(previous);
            this.add(play);
            this.add(next);
            this.add(repeat);
            this.add(like);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == play) {
                if (flagPlay==0) {
                    play.setIcon(pus);
                    play.setRolloverIcon(pus);
                    flagPlay=1;
                    if(Main.MainController.getNowplaying()!= null)
                         Main.mainPlayer.resume();
                } else {
                    play.setIcon(pla);
                    play.setRolloverIcon(pla1);
                    flagPlay=0;
                    if(Main.MainController.getNowplaying()!= null)
                        Main.mainPlayer.pause();
                }
            }
            if (e.getSource() == like) {
                if (like.getIcon() != flike) {
                    like.setIcon(flike);
                    like.setRolloverIcon(rflike);
                } else {
                    like.setIcon(elik);
                    like.setRolloverIcon(relike);
                    i++;
                }
            }
        }
    }


     public class MusicBar_picture extends JPanel {
        private String name = (Main.MainController.getNowplaying() != null) ? Main.MainController.getNowplaying().getName() : " ";
        JLabel label_pic;
        JLabel label_name;
        public MusicBar_picture() {
            super();
            this.setLayout(new GridLayout(1, 2, 10, 0));
            this.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
            ByteArrayInputStream bis = null;
            if (Main.MainController.getNowplaying() != null)
                bis = new ByteArrayInputStream(Main.MainController.getNowplaying().getArtWork());
            BufferedImage bimage = null;
            if (Main.MainController.getNowplaying() != null) {
                try {
                    bimage = ImageIO.read(bis);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    ImageIO.write(bimage, "jpg", new File("./assets/image/NowPlaying.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            label_pic = new JLabel(Utils.resize( "./assets/image/Default.jpg", 30, 30));
            String newname="<html><p style=\"width:3px\">"+name+"</p></html>";
            label_pic.setMaximumSize(new Dimension(30,30));
            label_name = new JLabel(newname);
            label_name.setForeground(Color.WHITE);
            label_pic.setPreferredSize(new Dimension(100, 60));
            this.setPreferredSize(new Dimension(200,200));
            //add Buttons
            this.add(label_pic);
            this.add(label_name);
            setBackground(new Color(50, 50, 50));
        }

        public void setLabel_pic(ImageIcon Imagea) {
            label_pic.setIcon(Imagea);
        }

        public void setLabel_name(String name) {
            label_name.setText(name);
        }
    }


    class MusicBar_Button2 extends JPanel implements ActionListener {

        int j = 0;
        JButton unmute;
        ImageIcon mute;
        ImageIcon unmut;
        Icon rmute;
        Icon runmut;
        JSlider soundslider;
//        JButton queue;
//        JButton devices_Available;

        public JSlider getSoundslider() {
            return soundslider;
        }

        public MusicBar_Button2() {
            this.setLayout(new GridLayout(1, 2, 0, 3));

            unmute = new JButton(Utils.resize("./assets/image/unmute.jpg", 18, 20));
            mute = Utils.resize("./assets/image/mute.jpg", 20, 20);
            unmut = Utils.resize("./assets/image/unmute.jpg", 20, 20);
            rmute = Utils.resize("./assets/image/mute.jpg", 25, 25);
            runmut = Utils.resize("./assets/image/unmute.jpg", 25, 25);
//            queue = new JButton(Utils.resize("./assets/image/queue.jpg", 20, 20));
//            devices_Available = new JButton(Utils.resize("./assets/image/devices_Available.jpg", 18, 20));

            setBackground(new Color(50, 50, 50));
            this.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 10));
            this.setPreferredSize(new Dimension(150, 60));

//            queue.setContentAreaFilled(false);
//            queue.setPressedIcon(Utils.resize("./assets/image/queue.jpg",20,20));
//            queue.setRolloverIcon(Utils.resize("./assets/image/queue.jpg",25,25));
//            queue.addActionListener(this);
//
//            devices_Available.setContentAreaFilled(false);
//            devices_Available.setPressedIcon(Utils.resize("./assets/image/devices_Available.jpg",20,20));
//            devices_Available.setRolloverIcon(Utils.resize("./assets/image/devices_Available.jpg",25,25));
//            devices_Available.addActionListener(this);

            unmute.setContentAreaFilled(false);
            unmute.setPressedIcon(Utils.resize("./assets/image/unmute.jpg", 20, 20));
            unmute.setRolloverIcon(Utils.resize("./assets/image/unmute.jpg", 25, 25));
            unmute.addActionListener(this);


            //add buttons
//            this.add(queue);
//            this.add(devices_Available);
            this.add(unmute);


            //sound_slider
            soundslider = makeUI();
            soundslider.setSize(new Dimension(100, 8));
            this.add(soundslider);
            soundslider.setValue(0);
            soundslider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {

                    float percent=soundslider.getValue()/(float)(soundslider.getMaximum()-soundslider.getMinimum());
                    Main.mainPlayer.changeVoloum(percent);
                }
            });
        }

        @Override
        public void actionPerformed(ActionEvent e) {
//            if(e.getSource() == queue){
//
//            }
//            if(e.getSource() == devices_Available){
//
//            }
            if (e.getSource() == unmute) {
                if (unmute.getIcon() != mute) {
                    unmute.setIcon(mute);
                    unmute.setRolloverIcon(rmute);
                    j++;
                } else {
                    unmute.setIcon(unmut);
                    unmute.setRolloverIcon(runmut);
                }

            }
        }
    }


    public class MusicBar_MusicTime extends JPanel {
        public JSlider getTimeslider() {
            return Timeslider;
        }

        public void setTimeslider(int value) {
            Timeslider.setValue(value);
        }
        int flagchanging=0;

        public int getFlagchanging() {
            return flagchanging;
        }

        public void setFlagchanging(int flagchanging) {
            this.flagchanging = flagchanging;
        }

        JSlider Timeslider;

        public MusicBar_MusicTime() {

            Timeslider = makeUI();
            Timeslider.setMinimumSize(new Dimension(900, 10));
            this.add(Timeslider);
            setBackground(new Color(50, 50, 50));
            Timeslider.setValue(0);
            Timeslider.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if(Main.MainController.getNowplaying()!=null) {
                        flagchanging=1;
                        Main.mainPlayer.play(Main.MainController.getNowplaying().getPath(), Timeslider.getValue() / (float) (Timeslider.getMaximum() - Timeslider.getMinimum()));
                        flagchanging=0;
                        System.out.println(flagchanging);
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });

        }
    }
}



