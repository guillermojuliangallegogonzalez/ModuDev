package nomenglaturaZip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.zip.DeflaterOutputStream;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author guillermo
 */
public class ZipController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public static void compressFile(File raw, File compressed)
            throws IOException {
        InputStream in = new FileInputStream(raw);
        OutputStream out
                = new DeflaterOutputStream(new FileOutputStream(compressed));
        shovelInToOut(in, out);
        in.close();
        out.close();
    }

    private static void shovelInToOut(InputStream in, OutputStream out)
            throws IOException {
        byte[] buffer = new byte[1000];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }

}
