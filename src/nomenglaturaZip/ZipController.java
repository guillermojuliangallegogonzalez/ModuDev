package nomenglaturaZip;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author guillermo
 */
public class ZipController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Button SelecArch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void AñadirZip() {

        Stage stage = new Stage();
        ListView<File> filesList = new ListView<>();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar archivos");
        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(stage);
        Scene scene = new Scene(AnchorPane);
        stage.setScene(scene);
        stage.show();

    }

}
