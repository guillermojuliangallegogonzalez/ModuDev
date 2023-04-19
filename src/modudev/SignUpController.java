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
public class SignUpController implements Initializable {

    @FXML
    private TextField nombreTF;
    @FXML
    private TextField apellidosTF;
    @FXML
    private TextField dniTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField contraseñaTF;
    @FXML
    private TextField contraseñaRepetidaTF;
    @FXML
    private Button crearCuentaBtn;
    @FXML
    private Button crearSalirBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Cargamos las restricciones
        MetodosComunes.salirBtn(crearSalirBtn);
        MetodosComunes.dniPattern(dniTF);
        MetodosComunes.restringirEspacios(emailTF);
        MetodosComunes.restringirEspacios(nombreTF);
        MetodosComunes.restringirEspacios(apellidosTF);
    }    
    
}
