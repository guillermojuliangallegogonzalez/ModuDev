package alumno;

import static alumno.InterfazAlumnoController.asignaturasComboBox;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author guillermo
 */
public class AñadirMenuController implements Initializable {

    @FXML
    private JFXToggleButton asignaturasTB;
    @FXML
    private JFXToggleButton profesoresTB;
    @FXML
    private JFXToggleButton calendarioTB;
    @FXML
    private JFXToggleButton navegadorTB;
    @FXML
    private JFXToggleButton homeTB;
    @FXML
    private JFXToggleButton comprimirTB;
    @FXML
    private JFXToggleButton soporteTB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cambiarShortCuts();
    }    
    
    public static void cambiarShortCuts(){
    
        asignaturasComboBox.hide();
        
    }
    
}
