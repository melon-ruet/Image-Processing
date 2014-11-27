/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author MELON
 */
public class ImageSlider extends JSlider{

    public ImageSlider(final int type, final JLabel imgLabel) {
        setOrientation(JSlider.HORIZONTAL);
        setMinimum(-120);
        setMaximum(120);
        setValue(0);
        setMajorTickSpacing(30);
        setPaintLabels(true);
        
        addChangeListener(new javax.swing.event.ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {

                try {
                    imgLabel.setIcon(new ImageIcon(
                            new Conversions().brightnessContrast(ImageIO.read(ImageProcessing.imageFile), getValue(), type)));
                } catch (IOException ex) {
                }
            }
        });
    }
}
