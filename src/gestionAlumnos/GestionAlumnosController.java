/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gestionAlumnos;

import java.net.URL;
import java.util.ResourceBundle;
import alumno.alumno;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author galle
 */
public class GestionAlumnosController implements Initializable {

    @FXML
    private JFXTreeTableView<alumno> vistaAlumno;
    @FXML
    private TextField buscarUsuario;
    @FXML
    private JFXButton nuevoBtn;
    @FXML
    private JFXButton eliminarBtn;
    @FXML
    private JFXButton modificarBtn;
    @FXML
    private JFXButton guardarBtn;
    @FXML
    private JFXButton cancelarBtn;
    @FXML
    private AnchorPane anchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
