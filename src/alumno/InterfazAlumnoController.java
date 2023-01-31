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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    private JFXComboBox<?> asignaturasComboBox;
    @FXML
    private JFXComboBox<?> profesoresComboBox;
    @FXML
    private JFXButton calendarioComboBox;
    @FXML
    private ImageView perfilImg;
    @FXML
    private ImageView ajustesImg;

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
        stage.setScene(scene);
        stage.show();

    }
    
}
