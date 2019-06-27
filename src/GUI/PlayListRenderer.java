package GUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import Logic.PlayList;

/**
 * Custom renderer to display a country's flag alongside its name
 *
 * @author wwww.codejava.net
 */
public class PlayListRenderer extends JButton implements ListCellRenderer<PlayList> {

    public PlayListRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends PlayList> list, PlayList playList, int index,
                                                  boolean isSelected, boolean cellHasFocus) {

        String name = playList.getName();
        ImageIcon imageIcon = null;
        try {
            imageIcon = Utils.resize(ImageIO.read(new ByteArrayInputStream(playList.getPlayphoto())),30,30);
        } catch (IOException e) {
            e.printStackTrace();
        }

        setIcon(imageIcon);
        setText(name);


        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        return this;
    }
}