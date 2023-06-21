package perfil;

import alumno.alumno;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import metodos.AlumnoHolder;
import metodos.MetodosComunes;
import sql.Conectar;

/**
 * FXML Controller class
 *
 * @author guillermogallegogonzalez
 */
public class AjustesPerfilController implements Initializable {

    @FXML
    private ImageView fotoPerfilAjustes;
    @FXML
    private JFXTextField nombreTF;
    @FXML
    private JFXTextField apellidosTF;
    @FXML
    private JFXTextField dniTF;
    @FXML
    private JFXTextField telefonoTF;
    @FXML
    private JFXComboBox generoCB;
    ObservableList<String> generos = FXCollections.observableArrayList("Hombre", "Mujer");
    @FXML
    private JFXDatePicker nacimientoDP;
    @FXML
    private Button cancelarBtn;
    @FXML
    private Button guardarBtn;
    @FXML
    private TextArea biografíaTA;

    private alumno usuarioCargado = AlumnoHolder.getAlumno();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        generoCB.setItems(generos);
        cancelarBtn.setOnAction(event -> {
            Stage stage = (Stage) cancelarBtn.getScene().getWindow();
            stage.close();
        });
        cargarDatosAlumno();
    }

    public void cargarDatosAlumno() {
        Platform.runLater(() -> {
            dniTF.setText(usuarioCargado.getDni());
            nombreTF.setText(usuarioCargado.getNombre());
            apellidosTF.setText(usuarioCargado.getApellido());
            telefonoTF.setText(String.valueOf(usuarioCargado.getTelefono()));
            generoCB.setValue(usuarioCargado.getSexo() ? "Mujer" : "Hombre");
            nacimientoDP.setValue(usuarioCargado.getFechaNacimiento());
            biografíaTA.setText(usuarioCargado.getBiografia());
        });
    }

    public void actualizarPerfil() {
        String nombre = nombreTF.getText();
        String apellido = apellidosTF.getText();
        String dni = dniTF.getText();
        String telefono = telefonoTF.getText();
        String genero = generoCB.getValue().toString();
        LocalDate nacimiento = nacimientoDP.getValue();
        String biografia = biografíaTA.getText();

        boolean esMujer = genero.equals("Mujer");

        // Obtener el alumno desde AlumnoHolder
        alumno alumnoActualizado = AlumnoHolder.getAlumno();
        alumnoActualizado.setNombre(nombre);
        alumnoActualizado.setApellido(apellido);
        alumnoActualizado.setDni(dni);
        alumnoActualizado.setTelefono(Integer.parseInt(telefono));
        alumnoActualizado.setSexo(esMujer);
        alumnoActualizado.setBiografia(biografia);
        alumnoActualizado.setFechaNacimiento(nacimiento);

        actualizarAlumno(alumnoActualizado);
    }


    public void actualizarAlumno(alumno alumno) {
        Conectar con = new Conectar();
        Connection connection = con.getConnection();

        try {
            String query = "UPDATE alumnos SET nombre = ?, apellido = ?, dnialumnos = ?, telefono = ?, sexo = ?, fecha_nacimiento = ?, biografia = ? WHERE idalumno = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, alumno.getNombre());
            statement.setString(2, alumno.getApellido());
            statement.setString(3, alumno.getDni());
            statement.setInt(4, alumno.getTelefono());
            statement.setBoolean(5, alumno.getSexo());
            statement.setDate(6, java.sql.Date.valueOf(alumno.getFechaNacimiento()));
            statement.setString(7, alumno.getBiografia());
            statement.setInt(8, alumno.getIdalumno());

            statement.executeUpdate();
            System.out.println("Alumno actualizado correctamente en la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción de acuerdo a tus necesidades
        } finally {
            con.desconectar();
        }
    }



}
