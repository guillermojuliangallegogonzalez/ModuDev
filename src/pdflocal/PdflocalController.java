/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pdflocal;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author galle
 */
public class PdflocalController implements Initializable {
    @FXML
    private TableView<pdflocalconstructor> tableView;
    @FXML
    private TableColumn<pdflocalconstructor, String> nameColumn;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Configurar las columnas
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));


        // Obtener la lista de archivos PDF en la carpeta
        File folder = new File("desacargas");

        // Crear la ruta si no existe
        if (!folder.exists()) {
            folder.mkdirs();
        }
        System.out.println(folder.getAbsolutePath());
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));

        // Agregar los archivos PDF a la tabla
        if (files != null) {
            for (File file : files) {
                pdflocalconstructor pdfFile = new pdflocalconstructor(file.getName(), file.getAbsolutePath());
                tableView.getItems().add(pdfFile);
            }
        }
    }
}
