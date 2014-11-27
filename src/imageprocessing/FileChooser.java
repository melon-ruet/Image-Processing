
package imageprocessing;

import com.sun.java.swing.plaf.windows.resources.windows;
import java.awt.Window;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author MELON
 */
public class FileChooser extends JFileChooser {

    private File imageFile = null;

    public FileChooser() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG, GIF & PNG Images", "jpg", "gif", "png");
        setFileFilter(filter);
        if (showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            imageFile = getSelectedFile();
        }
    }

    public File retrunFile() {
        return imageFile;
    }
}
