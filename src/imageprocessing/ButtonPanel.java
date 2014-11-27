/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author MELON
 */
public class ButtonPanel extends JPanel{
    private JButton [] btnProcess = new JButton[5]; 
    private String [] buttonString = {"Choose Image","Grey","Black & White","Brightness", "Contrast"};
    
    public ButtonPanel(ImagePanel imgPanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        c.weightx = 0.5;
        
        for(int buttonCount=0; buttonCount<5; buttonCount++){
            btnProcess[buttonCount] = new JButton(buttonString[buttonCount]);
            c.gridx = buttonCount;
            add(btnProcess[buttonCount],c);
            if(buttonCount == 0)
                btnProcess[buttonCount].addActionListener(new ButtonAction(1,imgPanel));
            else
                btnProcess[buttonCount].addActionListener(new ButtonAction(buttonCount+1));
        }
    }
    
}
