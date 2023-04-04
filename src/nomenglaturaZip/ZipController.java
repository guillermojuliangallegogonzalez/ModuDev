package nomenglaturaZip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author guillermo
 */
public class ZipController implements Initializable {

    //Variables
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Button SelecArch;
    private List<File> archivos = null;
    private String ruta = null;
    @FXML
    private Button selectRuta;
    @FXML
    private Label archText;
    @FXML
    private Label rutaText;
    @FXML
    private ComboBox asignaturaCB;
    ObservableList<String> asignaturas = FXCollections.observableArrayList("DI", "SGE", "HLC", "PMM", "PSP", "AD", "EMP");
    @FXML
    private TextField temaTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        asignaturaCB.setItems(asignaturas);
        temaTF.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                temaTF.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    //Función para añadir los archivos que se van a comprimir
    @FXML
    public void AñadirZip() {

        ListView<File> filesList = new ListView<>();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar archivos");
        this.archivos = fileChooser.showOpenMultipleDialog(AnchorPane.getScene().getWindow());

        if (archivos != null) {

            archText.setText("Seleccionado");
            archText.setTextFill(Color.web("#62B988"));

        } else {

            archText.setText("No Seleccionado");
            archText.setTextFill(Color.web("#EA1F1B"));

        }

    }

    //Función para añadir la ruta donde se va a guardar el zip
    @FXML
    public void añadirRuta() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar ruta salida");
        this.ruta = fileChooser.showOpenDialog(AnchorPane.getScene().getWindow()).toString();

        if (ruta != null) {

            rutaText.setText("Seleccionado");
            rutaText.setTextFill(Color.web("#62B988"));

        } else {

            rutaText.setText("No Seleccionado");
            rutaText.setTextFill(Color.web("#EA1F1B"));

        }

    }

    //Función para comprimir el zip
    @FXML
    public void comprimirZip() {

        if (archivos != null) {
            try {
                // Crear el archivo ZIP
                FileOutputStream fos = new FileOutputStream(asignaturaCB.getValue() + "_" + "T" + temaTF.getText() + ".zip");
                ZipOutputStream zipOut = new ZipOutputStream(fos);

                // Recorrer los archivos seleccionados y agregarlos al archivo ZIP
                for (File file : archivos) {
                    FileInputStream fis = new FileInputStream(file);
                    ZipEntry zipEntry = new ZipEntry(file.getName());
                    zipOut.putNextEntry(zipEntry);

                    byte[] bytes = new byte[1024];
                    int length;
                    while ((length = fis.read(bytes)) >= 0) {
                        zipOut.write(bytes, 0, length);
                    }

                    fis.close();
                    zipOut.closeEntry();
                }

                // Cerrar el archivo ZIP
                zipOut.close();
                fos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}
