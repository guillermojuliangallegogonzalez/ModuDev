package alumno;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
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

/**
 * FXML Controller class
 *
 * @author guillermo
 */
public class InterfazAlumnoController implements Initializable {

    @FXML
    private ImageView logoModudev;
    @FXML
    public static JFXComboBox<?> asignaturasComboBox;
    @FXML
    private JFXComboBox<?> profesoresComboBox;
    @FXML
    private ImageView perfilImg;
    @FXML
    private ImageView ajustesImg;
    @FXML
    private HBox menuSuperior;
    @FXML
    private JFXButton añadirBtn;
    @FXML
    private JFXButton calendarioBtn;
    @FXML
    private JFXButton navegadorBtn;
    @FXML
    private JFXButton comprimirBtn;
    @FXML
    private JFXButton soporteBtn;
    @FXML
    private BorderPane modudevAplicacion;

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
    
    //Ejecutar Ajustes perfil
    @FXML
    public void iniciarAjustesBarra() throws IOException {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("AñadirMenu.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AñadirMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.getIcons().add(new Image("/recursos/ModuDev.png"));
        stage.setTitle("ModuDev - Ajustes ShortCuts");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }
    
    
}
