package modudev;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author guillermogallegogonzalez
 */
public class LoginController implements Initializable {
    
    //Variables
    @FXML
    private JFXButton iniciarSesionBtn;
    @FXML
    private JFXButton crearCuentaBtn;
    @FXML
    private VBox loginVBox;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    
    //Función carga inicio de sesión
    @FXML
    private void OnActionButtonIniciarSesion() throws IOException{
    
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IniciarSesion.fxml"));
        VBox iniciarSesion = (VBox) fxmlLoader.load();
        try {
            loginVBox.getChildren().clear();
            loginVBox.getChildren().add(iniciarSesion);
        } catch (Exception e) {
        }
    
    }
    
    //Función carga crear cuenta
    @FXML
    private void OnActionButtonCrearCuenta() throws IOException{
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CrearCuenta.fxml"));
        VBox iniciarSesion = (VBox) fxmlLoader.load();
        
        try {
            loginVBox.getChildren().clear();
            loginVBox.getChildren().add(iniciarSesion);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    
}
