/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author MELON
 */
public class ImageProcessing extends JFrame {

    public static File imageFile = null;

    public ImageProcessing() {
        setTitle("Image Processing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 400));
        try {
            setIconImage(ImageIO.read(new File(ImageProcessing.class.getResource("logo.png").toURI())));
        } catch (Exception ex) {
        }

        ImagePanel imagePanel = new ImagePanel();
        try {
            imageFile = new File(ImageProcessing.class.getResource("icon.png").toURI());
            imagePanel.setImage(imageFile);
        } catch (URISyntaxException ex) {
        }
        add(new ButtonPanel(imagePanel), BorderLayout.SOUTH);
        add(imagePanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (java.lang.Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (java.lang.Exception ex) {
            }
        }
        new ImageProcessing();
    }
}
