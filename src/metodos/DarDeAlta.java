package metodos;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class DarDeAlta {

    public static boolean comprobarCampos(TextField nombreTF, TextField apellidosTF, TextField dniTF, TextField emailTF, TextField contraseñaTF, TextField contraseñaRepetidaTF){

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

    public static void crearCuenta(TextField nombreTF, TextField apellidosTF, TextField dniTF, TextField emailTF, TextField contraseñaTF, TextField contraseñaRepetidaTF){
        if (comprobarCampos(nombreTF,apellidosTF,dniTF,emailTF,contraseñaTF,contraseñaRepetidaTF)){
            
        }
    }

}
