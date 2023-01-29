package modudev;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import metodos.MetodosComunes;

/**
 * FXML Controller class
 *
 * @author guillermo
 */
public class SigInController implements Initializable {

    @FXML
    private TextField emailTF;
    @FXML
    private TextField contraseñaTF;
    @FXML
    private Button iniciarSesionBtn;
    @FXML
    private Button iniciarSalirBtn;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Carga función Salir
        MetodosComunes.salirBtn(iniciarSalirBtn);
    }    
    
}
