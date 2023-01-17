package modudev;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import org.controlsfx.control.textfield.CustomTextField;

/**
 * FXML Controller class
 *
 * @author guillermogallegogonzalez
 */
public class IniciarSesionController implements Initializable {

    @FXML
    private VBox iniciarSesionVBox;
    @FXML
    private JFXButton backBtn;
    @FXML
    private CustomTextField emailTF;
    @FXML
    private CustomTextField contraseñaTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void volverInicio() throws IOException{
    
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        VBox iniciarSesion = (VBox) fxmlLoader.load();
        
        try {
            iniciarSesionVBox.getChildren().clear();
            iniciarSesionVBox.getChildren().add(iniciarSesion);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    
}
