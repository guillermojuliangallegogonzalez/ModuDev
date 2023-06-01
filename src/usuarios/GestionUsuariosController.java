/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package usuarios;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DAO.AlumnoDAO;
import alumno.alumno;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import metodos.AlumnoHolder;

/**
 * FXML Controller class
 *
 * @author galle
 */
public class GestionUsuariosController implements Initializable {

    @FXML
    private JFXTreeTableView<alumno> vistaUsuario;
    @FXML
    private JFXButton alumnoBtn;
    @FXML
    private JFXButton profesorBtn;
    @FXML
    private JFXButton adminBtn;
    @FXML
    private AnchorPane anchorPane;
    private alumno usuarioCargado = AlumnoHolder.getAlumno();
    Tabla_UsuariosVO tusu = new Tabla_UsuariosVO();
    int id = -1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tusu.visualizar_Usuario(vistaUsuario);
        alumnoBtn.setOnAction(event -> {
            altaAlumno();
            bajaAdmin();
            bajaProfesor();
        });
        profesorBtn.setOnAction(event -> {
            altaProfesor();
            bajaAdmin();
            bajaAlumno();
        });
        adminBtn.setOnAction(event -> {
            altaAdmin();
            bajaProfesor();
            bajaAlumno();
        });
    }

    private void updateTableData() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/usuarios/gestionUsuarios.fxml"));
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

    public void accionClick(){
        int column = vistaUsuario.getSelectionModel().getSelectedCells().get(0).getColumn();
        int row = vistaUsuario.getSelectionModel().getSelectedCells().get(0).getRow();
        if(row < vistaUsuario.getRoot().getChildren().size() && row >= 0 && column < vistaUsuario.getColumns().size() && column >= 0){
            this.id = row + 1;
            System.out.println(id);
        }
    }

    void altaAlumno(){
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        alumno vo = new alumno();
        vo.setIdalumno(id);
        alumnoDAO.Alta_ALUMNO(vo);
        updateTableData();
    }

    void bajaAlumno(){
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        alumno vo = new alumno();
        vo.setIdalumno(id);
        alumnoDAO.Baja_ALUMNO(vo);
        updateTableData();
    }

    void altaProfesor(){
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        alumno vo = new alumno();
        vo.setIdalumno(id);
        alumnoDAO.Alta_PROFESOR(vo);
        updateTableData();
    }

    void bajaProfesor(){
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        alumno vo = new alumno();
        vo.setIdalumno(id);
        alumnoDAO.Baja_PROFESOR(vo);
        updateTableData();
    }

    void altaAdmin(){
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        alumno vo = new alumno();
        vo.setIdalumno(id);
        alumnoDAO.Alta_ADMIN(vo);
        updateTableData();
    }

    void bajaAdmin(){
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        alumno vo = new alumno();
        vo.setIdalumno(id);
        alumnoDAO.Baja_ADMIN(vo);
        updateTableData();
    }

}
