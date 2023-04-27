package metodos;

import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author guillermo
 */
public class MetodosComunes {

    //Función Salir Aplicación con Btn
    public static void salirBtn(Button btn){
    
        btn.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        
    }

    //Función Cerrar ventana
    public static void cerrarBtn(Button btn){

        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();

    }

    //Función máxima longitud caracteres
    public static EventHandler<KeyEvent> maxLength(final int i) {

        return (KeyEvent arg0) -> {
            TextField textfield = (TextField) arg0.getSource();
            if (textfield.getText().length() >= i) {
                arg0.consume();
            }
        };

    }

    //Función calcular DNI automáticamente
    public static void dniPattern(TextField textField) {

        textField.addEventFilter(KeyEvent.KEY_TYPED, maxLength(8));
        textField.focusedProperty().addListener((obs, oldValue, newValue) -> {
            if (oldValue) {
                if (!textField.getText().isEmpty()) {

                    //Pattern creation
                    Pattern pattern = Pattern.compile("^\\d{8}$");
                    char[] alfabeto = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

                    String valorDNI = textField.getText();
                    Matcher matcher = pattern.matcher(valorDNI);

                    if (matcher.matches()) {
                        int dniNumber = Integer.parseInt(valorDNI);
                        //Cálculo letra de DNI
                        dniNumber %= 23;

                        if (valorDNI.length() == 8) {
                            textField.setText(valorDNI + alfabeto[dniNumber]);
                        }
                    } else {
                        textField.clear();
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("¡ERROR!");
                        alert.setContentText("El DNI introducido no contiene 8 digitos rellénelo de nuevo");
                        alert.showAndWait();
                    }

                }
            }
        });
    }

    //Validar contraseñas
    public static boolean validarContraseñas(TextField contraseña1, TextField contraseña2) {

        String password1 = contraseña1.getText();
        String password2 = contraseña2.getText();

        return password1.equals(password2);

    }

    //Restringir espacios
    public static void restringirEspacios(TextField tf){

        TextFormatter<String> formatter = new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.contains(" ")) {
                return null; // Ignorar el cambio si contiene espacios
            }
            return change;
        });

        tf.setTextFormatter(formatter);

    }

    //Comprobar si un textfield está vacío
    public static boolean comprobarCampoVacío(TextField campo){

        String contenido = campo.getText();

        return contenido.isEmpty();

    }

    //Limpiar un textfield
    public static void limpiarTF(TextField tf){
        tf.clear();
    }

    //Limpiar passwordfield
    public static void limpiarPWTF(PasswordField pas){
        pas.clear();
    }

}
