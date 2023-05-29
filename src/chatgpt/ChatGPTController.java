package chatgpt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import org.json.JSONObject;


/**
 * FXML Controller class
 *
 * @author guillermogallegogonzalez
 */
public class ChatGPTController implements Initializable {

    @FXML
    private TextField barraChat;
    @FXML
    private Button enviarBtn;
    @FXML
    private TextArea chat;
    
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        barraChat.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                try {
                    enviarMensaje();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        chat.setWrapText(true);
        chat.setEditable(false);
        chat.appendText("ChatGPT: " + "Hola soy una integración de ChatGPT creada por Guillermo Julián Gallego González, estoy aquí\n" + "para resover tus dudas. ¿Qué duda quieres que te resuelva?." + "\n");
    }

    public void enviarMensaje() throws Exception {

        // Obtener la respuesta del modelo de GPT-3.5 Turbo
        String message = chatGPT(barraChat.getText());
        
        // Mostrar la respuesta en la ventana de la aplicación
        chat.appendText("\n Tu: " + barraChat.getText() + "\n");
        chat.appendText("\n ChatGPT: " + message + "\n");

        // Borrar el contenido del campo de entrada
        barraChat.clear();

    }

    // Método para obtener una respuesta del modelo de GPT-3.5 Turbo utilizando la API de OpenAI
    public static String chatGPT(String text) throws Exception {
        String url = "https://api.openai.com/v1/completions";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer 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");

        JSONObject data = new JSONObject();
        data.put("model", "text-davinci-003");
        data.put("prompt", text);
        data.put("max_tokens", 4000);
        data.put("temperature", 1.0);

        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());

        String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
                .reduce((a, b) -> a + b).get();

        String mensaje;
        mensaje = new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text");

        return mensaje;
    }

    public void reiniciarChat(){
        chat.setText("");
        barraChat.setText("");
        chat.appendText("ChatGPT: " + "Hola soy una integración de ChatGPT creada por Guillermo Julián Gallego González, estoy aquí\n" + "para resover tus dudas. ¿Qué duda quieres que te resuelva?." + "\n");
    }

}
