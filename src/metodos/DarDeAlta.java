package metodos;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import sql.Conectar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DarDeAlta {

    public static boolean comprobarCampos(TextField nombreTF, TextField apellidosTF, TextField dniTF, TextField emailTF, PasswordField contraseñaTF, PasswordField contraseñaRepetidaTF){

        //comprobamos si los campos están vacions
        if (MetodosComunes.comprobarCampoVacío(nombreTF) || MetodosComunes.comprobarCampoVacío(apellidosTF) || MetodosComunes.comprobarCampoVacío(dniTF) || MetodosComunes.comprobarCampoVacío(emailTF) || MetodosComunes.comprobarCampoVacío(contraseñaTF) || MetodosComunes.comprobarCampoVacío(contraseñaRepetidaTF)){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Campos vacíos");
            alert.setHeaderText("Tienes campos sin rellenar");
            alert.setContentText("Por favor, comprueba los campos e introduzca los datos necesarios.");
            alert.showAndWait();
            return false;
        }else {
            //Validamos que las contraseñas sean iguales
            if (MetodosComunes.validarContraseñas(contraseñaTF, contraseñaRepetidaTF)) {
                return true;
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Contraseñas diferentes");
                alert.setHeaderText("Tienes contraseñas diferentes");
                alert.setContentText("Por favor, comprueba las contraseñas, recuerde que deben ser iguales.");
                alert.showAndWait();
                return false;
            }
        }

    }

    public static void crearCuenta(TextField nombreTF, TextField apellidosTF, TextField dniTF, TextField emailTF, PasswordField contraseñaTF, PasswordField contraseñaRepetidaTF){
        if (comprobarCampos(nombreTF,apellidosTF,dniTF,emailTF,contraseñaTF,contraseñaRepetidaTF)){
            Connection connection = null;
            PreparedStatement preparedStatement = null;

            try {
                //Variables
                boolean existe = false;
                Conectar con = new Conectar();
                connection = con.getConnection();

                // Crea la consulta SQL
                String query1 = "SELECT * FROM alumnos WHERE dni = ?";

                // Crea el objeto PreparedStatement y establece el valor del parámetro
                PreparedStatement pstmt = connection.prepareStatement(query1);
                pstmt.setString(1, dniTF.getText());

                // Ejecuta la consulta
                ResultSet rs = pstmt.executeQuery();

                // Si la consulta devuelve algún resultado, significa que el DNI existe en la base de datos
                if (rs.next()) {
                    existe = true;
                }

                if(!existe) {
                    String query = "INSERT INTO alumnos (dnialumnos, nombre, apellido, correo, contraseña, esalumno, esprofesor, esadmin, di, sge, hlc, pmm, psp, ad, emp, sexo, biografia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    preparedStatement = connection.prepareStatement(query);

                    preparedStatement.setString(1, dniTF.getText());
                    preparedStatement.setString(2, nombreTF.getText());
                    preparedStatement.setString(3, apellidosTF.getText());
                    preparedStatement.setString(4, emailTF.getText());
                    preparedStatement.setString(5, contraseñaTF.getText());
                    preparedStatement.setBoolean(6, true);
                    preparedStatement.setBoolean(7, false);
                    preparedStatement.setBoolean(8, false);
                    preparedStatement.setBoolean(9, false);
                    preparedStatement.setBoolean(10, false);
                    preparedStatement.setBoolean(11, false);
                    preparedStatement.setBoolean(12, false);
                    preparedStatement.setBoolean(13, false);
                    preparedStatement.setBoolean(14, false);
                    preparedStatement.setBoolean(15, false);
                    preparedStatement.setBoolean(16, false);
                    preparedStatement.setString(17, "");

                    preparedStatement.executeUpdate();
                }else{
                    //Alerta avisando que el usuario ya se ha registrado
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error! Usuario");
                    alert.setHeaderText("Usuario ya registrado");
                    alert.setContentText("El usuario se encuentra ya registrado en la base de datos. Por favor contacte con el administrador.");
                    alert.showAndWait();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                try {

                    if (preparedStatement != null) preparedStatement.close();
                    if (connection != null) connection.close();

                    //Alerta confirmando la creación de la cuenta
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Usuario registrado correctamente");
                    alert.setHeaderText("Usuario añadido a modudev");
                    alert.setContentText("El usuario " + nombreTF.getText() + " con DNI " + dniTF.getText() + " ha sido registrado correctamente dentro de ModuDev. Inicia sesión para empezar a usar ModuDev");
                    alert.show();

                    //Limpiamos el formulario
                    MetodosComunes.limpiarTF(nombreTF);
                    MetodosComunes.limpiarTF(apellidosTF);
                    MetodosComunes.limpiarTF(dniTF);
                    MetodosComunes.limpiarTF(emailTF);
                    MetodosComunes.limpiarPWTF(contraseñaTF);
                    MetodosComunes.limpiarPWTF(contraseñaRepetidaTF);

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

}
