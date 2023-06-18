package chatgpt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
import javafx.stage.Stage;
import metodos.MetodosComunes;
import org.json.JSONArray;
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
    @FXML
    private Button cerrarBtn;
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        barraChat.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case ENTER:
                    // Llamar a la función que deseas ejecutar
                    try {
                        enviarMensaje();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    break;
            }
        });
        cerrarBtn.setOnAction(event -> {
            Stage stage = (Stage) cerrarBtn.getScene().getWindow();
            stage.close();
        });
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
        String apiKey = "YOUR_API_KEY"; // Reemplaza con tu clave de API

        String url = "https://api.openai.com/v1/engines/davinci/completions";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer " + "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");

        con.setDoOutput(true); // Habilitar la escritura

        JSONObject data = new JSONObject();
        data.put("prompt", text);
        data.put("max_tokens", 50);
        data.put("temperature", 0.7);

        // Esperar antes de realizar la solicitud
        Thread.sleep(2000); // Pausa de 2 segundos

        try (OutputStream outputStream = con.getOutputStream()) {
            outputStream.write(data.toString().getBytes());
        }

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray choices = jsonResponse.getJSONArray("choices");
                if (choices.length() > 0) {
                    String mensaje = choices.getJSONObject(0).getString("text");
                    return mensaje;
                }
            }
        } else {
            throw new RuntimeException("Error en la solicitud: Código de respuesta " + responseCode);
        }

        return null;
    }

    public void reiniciarChat(){
        chat.setText("");
        barraChat.setText("");
        chat.appendText("ChatGPT: " + "Hola soy una integración de ChatGPT creada por Guillermo Julián Gallego González, estoy aquí\n" + "para resover tus dudas. ¿Qué duda quieres que te resuelva?." + "\n");
    }

}
