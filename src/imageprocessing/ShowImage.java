/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSlider;

/**
 *
 * @author MELON
 */
public class ShowImage extends JDialog {

    public ShowImage(int buttonNo) {
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        convertNset(buttonNo);

        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void convertNset(int processNo) {

        if (processNo == 2 || processNo == 3) {

            if(processNo == 2)
                setTitle("RGB to Grey");
            else
                setTitle("RGB to Black & White");
            /*
             ImageFilter filter = new GrayFilter(true, 50);
             ImageProducer producer = null;
             try {
             producer = new FilteredImageSource(
             ImageIO.read(ImageProcessing.imageFile).getSource(), filter);
             } catch (IOException ex) {
             }
             Image mage = Toolkit.getDefaultToolkit().createImage(producer);
             * */

            Image mage = null;
            try {
                mage = new Conversions().ConvertedImage(ImageIO.read(ImageProcessing.imageFile), processNo);
            } catch (IOException ex) {
            }
            add(new JLabel(new ImageIcon(mage)));
        }
        
        else if(processNo>=4){
            if(processNo == 4)
                setTitle("Brightness");
            else
                setTitle("Contrast");
            try {
                JLabel imageLabel = new JLabel(new ImageIcon(
                        new Conversions().brightnessContrast(ImageIO.read(ImageProcessing.imageFile), 0, processNo)));
                add(imageLabel, BorderLayout.CENTER);
                ImageSlider bright = new ImageSlider(processNo,imageLabel);
                add(bright, BorderLayout.SOUTH);
            } catch (IOException ex) {
            }
        }
    }
}
