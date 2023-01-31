package alumno;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

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
    @FXML
    private ImageView fotoPerfil;
    @FXML
    private Text nombrePerfil;
    @FXML
    private Text apellidosPerfil;
    @FXML
    private Text ajustesPerfil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
