package metodos;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

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
    
}
