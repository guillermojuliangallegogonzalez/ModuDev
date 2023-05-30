/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gestionAlumnos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DAO.AlumnoDAO;
import alumno.alumno;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import metodos.AlumnoHolder;

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
    private JFXButton bajaBtn;
    @FXML
    private JFXButton altaBtn;
    @FXML
    private JFXButton guardarBtn;
    @FXML
    private JFXButton cancelarBtn;
    @FXML
    private AnchorPane anchorPane;
    private alumno usuarioCargado = AlumnoHolder.getAlumno();
    Tabla_AlumnoVO talum = new Tabla_AlumnoVO();
    int id = -1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        talum.visualizar_AlumnoVO(vistaAlumno);
        cancelarBtn.setOnAction(event -> {
            Stage stage = (Stage) cancelarBtn.getScene().getWindow();
            stage.close();
        });
        bajaAlumno();
    }    

    public void accionClick(){
        int column = vistaAlumno.getSelectionModel().getSelectedCells().get(0).getColumn();
        int row = vistaAlumno.getSelectionModel().getSelectedCells().get(0).getRow();
        if(row < vistaAlumno.getRoot().getChildren().size() && row >= 0 && column < vistaAlumno.getColumns().size() && column >= 0){
            this.id = row + 1;
            System.out.println(id);
        }
    }

    private void updateTableData() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gestionAlumnos/gestionAlumnos.fxml"));
        AnchorPane pdfAnchorPane = null;
        try {
            pdfAnchorPane = (AnchorPane) fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(pdfAnchorPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void bajaAlumno(){

        if(usuarioCargado.getDi()){
            bajaBtn.setOnAction(event -> {
                System.out.println(id);
                AlumnoDAO alumnoDAO = new AlumnoDAO();
                alumno vo = new alumno();
                vo.setIdalumno(id);
                alumnoDAO.Baja_DI(vo);
                updateTableData();
            });
        }
    }

}
