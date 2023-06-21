/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package offline;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import about.AboutController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import nomenglaturaZip.ZipController;

import static java.awt.Desktop.getDesktop;

/**
 * FXML Controller class
 *
 * @author galle
 */
public class InterfazofflineController implements Initializable {

    @FXML
    private AnchorPane profesorAnchorPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    public void iniciarCalendario() throws IOException {

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/calendario/calendarioApp.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(ZipController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.getIcons().add(new Image("/recursos/ModuDev.png"));
        stage.setTitle("ModuDev - Calendario");
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

    //Ejecutar Herramienta de Compresión
    @FXML
    public void iniciarGlosario() throws IOException {

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/glosario/glosarioApp.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(AboutController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.getIcons().add(new Image("/recursos/ModuDev.png"));
        stage.setTitle("ModuDev - Glosario");
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

    @FXML
    private void iniciarPDFLocal() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/pdflocal/pdflocal.fxml"));
        AnchorPane pdfAnchorPane = (AnchorPane) fxmlLoader.load();
        try {
            profesorAnchorPane.getChildren().clear();
            profesorAnchorPane.getChildren().add(pdfAnchorPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
