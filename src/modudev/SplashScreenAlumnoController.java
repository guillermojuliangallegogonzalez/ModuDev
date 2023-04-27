package modudev;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import alumno.alumno;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import metodos.AlumnoHolder;


/**
 * FXML Controller class
 *
 * @author guillermogallegogonzalez
 */
public class SplashScreenAlumnoController implements Initializable {

    //Variables
    @FXML
    private VBox rootPane;
    private double xOffset;
    private double yOffset;
    @FXML
    private ImageView imagenPerfil;
    @FXML
    private Label nombreUsuarioLabel;

    private alumno usuarioCargado = AlumnoHolder.getAlumno();


    class SplashScreen extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(5000);

                Platform.runLater(() -> {
                    Parent root = null;
                    System.out.println(usuarioCargado.getApellido());
                    nombreUsuarioLabel.setText(usuarioCargado.getNombre());
                    try {
                        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/alumno/InterfazAlumno.fxml")));
                    } catch (IOException ex) {
                        Logger.getLogger(SplashScreenAlumnoController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    
                    //Movimiento Escena undecorated
                    scene.setOnMousePressed(event -> {
                        xOffset = stage.getX() - event.getScreenX();
                        yOffset = stage.getY() - event.getScreenY();
                    });

                    scene.setOnMouseDragged(event -> {
                        stage.setX(event.getScreenX() + xOffset);
                        stage.setY(event.getScreenY() + yOffset);
                    });

                    stage.getIcons().add(new Image("/recursos/ModuDev.png"));
                    stage.setTitle("ModuDev");
                    stage.setScene(scene);
                    stage.show();

                    rootPane.getScene().getWindow().hide();
                });

            } catch (InterruptedException ex) {
                Logger.getLogger(SplashScreenAlumnoController.class.getName()).log(Level.SEVERE, null, ex);

            }

        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        new SplashScreen().start();
    }

}
