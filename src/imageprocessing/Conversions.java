/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author MELON
 */
public class Conversions {

    public BufferedImage ConvertedImage(BufferedImage original, int type) {

        int alpha, red, green, blue;
        int newPixel;

        BufferedImage avg_gray = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());

        for (int i = 0; i < original.getWidth(); i++) {
            for (int j = 0; j < original.getHeight(); j++) {

                // Get pixels by R, G, B
                alpha = new Color(original.getRGB(i, j)).getAlpha();
                red = new Color(original.getRGB(i, j)).getRed();
                green = new Color(original.getRGB(i, j)).getGreen();
                blue = new Color(original.getRGB(i, j)).getBlue();

                if (type == 2) {
                    newPixel = (red + green + blue) / 3;
                    avg_gray.setRGB(i, j, new Color(newPixel, newPixel, newPixel, alpha).getRGB());
                } else if (type == 3) {
                    newPixel = (red + green + blue) / 3 > 128 ? 255 : 0;
                    avg_gray.setRGB(i, j, new Color(newPixel, newPixel, newPixel, alpha).getRGB());
                }
            }
        }

        return avg_gray;

    }

    public BufferedImage brightnessContrast(BufferedImage original, int increasingFactor, int type) {
        int alpha, red, green, blue;

        BufferedImage avg_gray = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());

        for (int i = 0; i < original.getWidth(); i++) {
            for (int j = 0; j < original.getHeight(); j++) {

                // Get pixels by R, G, B
                alpha = new Color(original.getRGB(i, j)).getAlpha();
                red = new Color(original.getRGB(i, j)).getRed();
                green = new Color(original.getRGB(i, j)).getGreen();
                blue = new Color(original.getRGB(i, j)).getBlue();

                if(type==4){
                red += increasingFactor;
                green += increasingFactor;
                blue += increasingFactor;
                }
                else{
                    float factor = (259 * (increasingFactor + 255)) / (255 * (259 - increasingFactor));
                    red   = (int) (factor * (red   - 128) + 128);
                    green  = (int) (factor * (green   - 128) + 128);
                    blue   = (int) (factor * (blue   - 128) + 128);
                }

                //r,g,b values which are out of the range 0 to 255 should set to 0 or 255
                red = red > 255 ? 255 : red;
                red = red < 0 ? 0 : red;

                green = green > 255 ? 255 : green;
                green = green < 0 ? 0 : green;

                blue = blue > 255 ? 255 : blue;
                blue = blue < 0 ? 0 : blue;

                avg_gray.setRGB(i, j, new Color(red, green, blue, alpha).getRGB());
            }
        }

        return avg_gray;
    }
}
