package modudev;

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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import metodos.MetodosComunes;
import modudev.MainController;

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
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Carga función Salir
        MetodosComunes.salirBtn(iniciarSalirBtn);
    }

    //Ejecutar Interfaz
    @FXML
    public void iniciarAlumno() throws IOException {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("SplashScreenAlumno.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(SplashScreenAlumnoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/recursos/ModuDev.png"));
        stage.setTitle("ModuDev");
        stage.setScene(scene);
        stage.show();

    }

}
