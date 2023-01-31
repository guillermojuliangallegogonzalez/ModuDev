package perfil;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import metodos.MetodosComunes;

/**
 * FXML Controller class
 *
 * @author guillermogallegogonzalez
 */
public class AjustesPerfilController implements Initializable {

    @FXML
    private ImageView fotoPerfilAjustes;
    @FXML
    private JFXTextField nombreTF;
    @FXML
    private JFXTextField apellidosTF;
    @FXML
    private JFXTextField dniTF;
    @FXML
    private JFXTextField telefonoTF;
    @FXML
    private JFXComboBox<?> generoCB;
    @FXML
    private JFXDatePicker nacimientoDP;
    @FXML
    private Button cancelarBtn;
    @FXML
    private Button guardarBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MetodosComunes.salirBtn(cancelarBtn);
    }    
    
}
