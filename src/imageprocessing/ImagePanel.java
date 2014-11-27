/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author MELON
 */
public class ImagePanel extends JPanel{
    private BufferedImage image;

    public ImagePanel() {
        setLayout(new GridBagLayout());
    }

    public void setImage(File imgFile) {
        try {                
          image = ImageIO.read(imgFile);
          repaint();
       } catch (IOException ex) {
       }
        
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        g.drawImage(image, getWidth()/2 - image.getWidth()/2, getHeight()/2 - image.getHeight()/2, null);         
    }
}
