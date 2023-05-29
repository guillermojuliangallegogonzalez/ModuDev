/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package glosario;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import sql.Conectar;

/**
 * FXML Controller class
 *
 * @author galle
 */
public class GlosarioAppController implements Initializable {

    @FXML
    private Button cancelarBtn;
    @FXML
    private Button enviarBtn;
    @FXML
    private TextArea areaTexto;
    Conectar conectar = new Conectar();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        areaTexto.isEditable();
        conectar = new Conectar();
        cargarDatosDesdeBaseDeDatos();
    }

    private void cargarDatosDesdeBaseDeDatos() {
        try (Connection connection = conectar.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT mensaje FROM glosario")) {
            StringBuilder sb = new StringBuilder();
            while (resultSet.next()) {
                String mensaje = resultSet.getString("mensaje");
                sb.append(mensaje).append("\n");
            }
            areaTexto.setText(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void guardarEnBaseDeDatos() {
        Conectar conectar1 = new Conectar();
        String mensaje = areaTexto.getText();
        String sql = "UPDATE glosario SET mensaje = ?";
        try {
            Connection connection = conectar1.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, mensaje);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conectar1.desconectar();
    }


    @FXML
    void cancelar(){
        conectar.desconectar();
        Stage stage = (Stage) cancelarBtn.getScene().getWindow();
        stage.close();
    }
}
