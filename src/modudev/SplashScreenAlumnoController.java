package modudev;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


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

    class SplashScreen extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(5000);

                Platform.runLater(() -> {
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/alumno/InterfazAlumno.fxml"));
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
