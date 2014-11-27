/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 *
 * @author MELON
 */
public class ButtonAction implements ActionListener {

    private int buttonNo;
    private ImagePanel img;

    public ButtonAction(int buttonNo) {
        this.buttonNo = buttonNo;
    }

    public ButtonAction(int buttonNo, ImagePanel imgPanel) {
        this.buttonNo = buttonNo;
        img = imgPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (buttonNo == 1) {
            File f = new FileChooser().retrunFile();
            if (f != null) {
                ImageProcessing.imageFile = f;
                img.setImage(f);
            }
        } else if(ImageProcessing.imageFile != null){
            new ShowImage(buttonNo);
        }

    }
}
