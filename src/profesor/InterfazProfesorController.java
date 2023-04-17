/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package profesor;

import about.AboutController;
import chatgpt.ChatGPTController;
import com.jfoenix.controls.JFXButton;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import modudev.SplashScreenAlumnoController;
import nomenglaturaZip.ZipController;

import static java.awt.Desktop.getDesktop;

/**
 * FXML Controller class
 *
 * @author guillermogallegogonzalez
 */
public class InterfazProfesorController implements Initializable {

    @FXML
    private ImageView logoModudev;
    @FXML
    private HBox menuSuperior;
    @FXML
    private JFXButton calendarioBtn;
    @FXML
    private JFXButton navegadorBtn;
    @FXML
    private JFXButton comprimirBtn;
    @FXML
    private JFXButton glosarioBtn;
    @FXML
    private JFXButton soporteBtn;
    @FXML
    private ImageView perfilImg;
    @FXML
    private ImageView ajustesImg;
    @FXML
    private JFXButton altaBtn;
    @FXML
    private JFXButton bajaBtn;
    @FXML
    private JFXButton subirpdfBtn;
    @FXML
    private JFXButton pdfBtn;
    @FXML
    private JFXButton pdfBtn1;
    @FXML
    private JFXButton aboutBtn;
    @FXML
    private Button cerrarSesionBtn;
    @FXML
    private BorderPane modudevInterfaz;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    //Ejecutar Ajustes perfil
    @FXML
    public void iniciarAjustes() throws IOException {

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/perfil/AjustesPerfil.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(SplashScreenAlumnoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.getIcons().add(new Image("/recursos/ModuDev.png"));
        stage.setTitle("ModuDev - Ajustes Perfil");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    //Ejecutar Herramienta de Compresión
    @FXML
    public void iniciarZip() throws IOException {

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/nomenglaturaZip/Zip.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(ZipController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.getIcons().add(new Image("/recursos/ModuDev.png"));
        stage.setTitle("ModuDev - Herramienta Compresión");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    //Ejecutar Herramienta de Compresión
    @FXML
    public void iniciarAbout() throws IOException {

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/about/about.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(AboutController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.getIcons().add(new Image("/recursos/ModuDev.png"));
        stage.setTitle("ModuDev - About");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void iniciarNavegador() throws URISyntaxException, IOException {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI("https://www.google.es/"));
        }
    }

    @FXML
    public void iniciarSoporte() throws URISyntaxException, IOException {
        Desktop desktop = getDesktop();
        desktop.mail(new URI("mailto:guillermojulian.gallegogonzalez@gmail.com"));
    }

    //Ejecutar chatGPT
    @FXML
    public void iniciarGPT() throws IOException {

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/chatgpt/chatGPT.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(ChatGPTController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.getIcons().add(new Image("/recursos/ModuDev.png"));
        stage.setTitle("ModuDev - ChatGPT");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void OnActionButtonAboutSeccion() throws IOException {
        FXMLLoader fxmlLoader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/manejarpdf/manejarpdf.fxml")));
        BorderPane aboutAnchorPane = (BorderPane) fxmlLoader.load();
        try {
            modudevInterfaz.getChildren().clear();
            modudevInterfaz.getChildren().add(aboutAnchorPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
