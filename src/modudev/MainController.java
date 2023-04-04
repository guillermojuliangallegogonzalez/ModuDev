package modudev;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author guillermogallego
 */
public class MainController implements Initializable {

    @FXML
    private VBox vbox;
    private Parent fxml;
    @FXML
    public AnchorPane anchorPrincipal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(vbox.getLayoutX() * 20);
        t.play();
        t.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SigIn.fxml")));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            } catch (IOException ex) {

            }
        });
    }

    @FXML
    private void open_signin(ActionEvent event) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(vbox.getLayoutX() * 20);
        t.play();
        t.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SigIn.fxml")));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            } catch (IOException ex) {

            }
        });
    }

    @FXML
    private void open_signup(ActionEvent event) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(0);
        t.play();
        t.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignUp.fxml")));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            } catch (IOException ex) {

            }
        });
    }
    
    public void closeLogin(){
        anchorPrincipal.getScene().getWindow().hide();
    }

}
