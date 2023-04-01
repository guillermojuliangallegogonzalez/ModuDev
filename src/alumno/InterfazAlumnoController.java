package alumno;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.awt.Desktop;
import static java.awt.Desktop.getDesktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import modudev.SplashScreenAlumnoController;
import nomenglaturaZip.ZipController;

/**
 * FXML Controller class
 *
 * @author guillermo
 */
public class InterfazAlumnoController implements Initializable {

    @FXML
    private ImageView logoModudev;
    @FXML
    private JFXComboBox<?> asignaturasComboBox;
    @FXML
    private JFXComboBox<?> profesoresComboBox;
    @FXML
    private ImageView perfilImg;
    @FXML
    private ImageView ajustesImg;
    @FXML
    private HBox menuSuperior;
    @FXML
    private JFXButton calendarioBtn;
    @FXML
    private JFXButton navegadorBtn;
    @FXML
    private JFXButton comprimirBtn;
    @FXML
    private JFXButton soporteBtn;
    @FXML
    private BorderPane modudevInterfaz;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    //Ejecutar Ajustes perfil
    @FXML
    public void iniciarAjustes() throws IOException {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/perfil/AjustesPerfil.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(SplashScreenAlumnoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.getIcons().add(new Image("/recursos/ModuDev.png"));
        stage.setTitle("ModuDev - Ajustes Perfil");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    //Ejecutar Herramienta de Compresión
    @FXML
    public void iniciarZip() throws IOException {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/nomenglaturaZip/Zip.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ZipController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.getIcons().add(new Image("/recursos/ModuDev.png"));
        stage.setTitle("ModuDev - Herramienta Compresión");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    public void iniciarNavegador() throws URISyntaxException, IOException {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI("https://www.google.es/"));
        }
    }

    public void iniciarSoporte() throws URISyntaxException, IOException {
        Desktop desktop = getDesktop();
        desktop.mail(new URI("mailto:guillermojulian.gallegogonzalez@gmail.com"));
    }

}
