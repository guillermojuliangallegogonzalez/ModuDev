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
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    @FXML
    private Button cancelarBtn;
    @FXML
    private Button comprimirBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cancelarBtn.setOnAction(event -> {
            Stage stage = (Stage) cancelarBtn.getScene().getWindow();
            stage.close();
        });
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
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Seleccionar ruta salida");
        File selectedDirectory = directoryChooser.showDialog(AnchorPane.getScene().getWindow());

        if (selectedDirectory != null) {
            this.ruta = selectedDirectory.getAbsolutePath();
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
        if (archivos != null && ruta != null) {
            try {
                String asignatura = asignaturaCB.getValue().toString();
                String tema = temaTF.getText();
                String nombreArchivo = asignatura + "_" + "T" + tema + ".zip";
                String rutaArchivo = ruta + File.separator + nombreArchivo;

                // Crear el archivo ZIP
                FileOutputStream fos = new FileOutputStream(rutaArchivo);
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

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Archivo comprimido");
                alert.setHeaderText("Archivo comprimido correctamente");
                alert.setContentText("El archivo se ha comprimido correctamente en la ruta: " + rutaArchivo);
                alert.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}
