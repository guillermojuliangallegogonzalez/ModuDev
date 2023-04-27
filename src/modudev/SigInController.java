package modudev;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import alumno.alumno;
import com.jfoenix.controls.JFXPasswordField;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import metodos.AlumnoHolder;
import metodos.MetodosComunes;
import modudev.MainController;
import sql.Conectar;

/**
 * FXML Controller class
 *
 * @author guillermo
 */
public class SigInController implements Initializable {

    @FXML
    private  TextField emailTF;
    @FXML
    private JFXPasswordField contraseñaTF;
    @FXML
    private  Button iniciarSesionBtn;
    @FXML
    private Button iniciarSalirBtn;

    //Variables
     alumno usuario = new alumno();

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

    @FXML
    public void iniciarSesion() throws IOException {
        this.usuario = login(emailTF.getText(), contraseñaTF.getText());
        if (this.usuario != null){
            try {
                iniciarAlumno();
                System.out.println(usuario.getDni());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Inicio Sesión");
            alert.setHeaderText("Error correo/contraseña");
            alert.setContentText("Compruebe que la contraseña y el correo electrónico proporcionado. Asegurese de tener cuenta en ModuDev, si el problema persiste contacte con el administrador");
            alert.show();
        }
    }

    //Ejecutar Interfaz
    public void iniciarAlumno() throws IOException {

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(SigInController.class.getResource("SplashScreenAlumno.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(SplashScreenAlumnoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.getIcons().add(new Image("/recursos/ModuDev.png"));
        stage.setTitle("ModuDev");
        stage.setScene(scene);
        stage.show();
        
        //Cerramos la ventana
        stage = (Stage) iniciarSesionBtn.getScene().getWindow();
        stage.close();

    }

    public alumno login(String correo, String contrasena) {
        // Conexión a la base de datos
        Conectar conexion = new Conectar();
        Connection connection = conexion.getConnection();

        // Consulta SQL para obtener los datos del usuario con el correo y contraseña ingresados
        String sql = "SELECT * FROM alumnos WHERE correo = ? AND contraseña = ?";

        try {
            // Preparar la consulta SQL
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, correo);
            statement.setString(2, contrasena);

            // Ejecutar la consulta SQL
            ResultSet result = statement.executeQuery();

            // Verificar si existe un usuario con los datos ingresados
            if (result.next()) {
                this.usuario.setDni(result.getString("dnialumnos"));
                this.usuario.setNombre(result.getString("nombre"));
                this.usuario.setApellido(result.getString("apellido"));
                this.usuario.setCorreo(result.getString("correo"));
                this.usuario.setContrasena(result.getString("contraseña"));
                this.usuario.setEsalumno(result.getBoolean("esalumno"));
                this.usuario.setEsprofesor(result.getBoolean("esprofesor"));
                this.usuario.setEsadmin(result.getBoolean("esadmin"));
                this.usuario.setDi(result.getBoolean("di"));
                this.usuario.setSge(result.getBoolean("sge"));
                this.usuario.setHlc(result.getBoolean("hlc"));
                this.usuario.setPmm(result.getBoolean("pmm"));
                this.usuario.setPsp(result.getBoolean("psp"));
                this.usuario.setAd(result.getBoolean("ad"));
                this.usuario.setEmp(result.getBoolean("emp"));
                this.usuario.setSexo(result.getBoolean("sexo"));
                this.usuario.setBiografia(result.getString("biografia"));
                AlumnoHolder.setAlumno(this.usuario);
                return this.usuario;

            } else {
                System.out.println("Usuario no encontrado");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    //Metodo para obtener el alumno
    public alumno obtenerAlumno() {
        return this.usuario;
    }


}
