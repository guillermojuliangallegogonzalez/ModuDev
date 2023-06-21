/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mostrarpdf;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import DAO.PdfDAO;
import VO.PdfVO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;
import manejarPdf.Tabla_PdfVO;

/**
 * FXML Controller class
 *
 * @author guillermogallegogonzalez
 */
public class MostrarpdfController implements Initializable {

    @FXML
    private JFXTreeTableView<PdfVO> vistaPDF;
    @FXML
    private Button descargarArchivoBtn;

    Tabla_PdfVO tpdf = new Tabla_PdfVO();
    int id = -1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tpdf.visualizar_PdfVO(vistaPDF);
    }

    @FXML
    public void accionClick() {
        int column = vistaPDF.getSelectionModel().getSelectedCells().get(0).getColumn();
        int row = vistaPDF.getSelectionModel().getSelectedCells().get(0).getRow();


        if (row < vistaPDF.getRoot().getChildren().size() && row >= 0 && column < vistaPDF.getColumns().size() && column >= 0) {
            id = vistaPDF.getRoot().getChildren().get(row).getValue().getCodigopdf();
            TreeTableColumn<PdfVO, ?> col = vistaPDF.getColumns().get(column);
            ObservableValue<?> obsVal = col.getCellObservableValue(row);
            Object value = obsVal.getValue();
            if (value instanceof Button) {
                ((Button) value).fire();
                Button boton = (Button) value;

                if (boton.getText().equals("Vacio")) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error Archivo!");
                    alerta.setHeaderText("No se encuentra el archivo");
                    alerta.setContentText("El archivo que ha seleccionado no se encuentra en la base de datos");
                    alerta.showAndWait();
                } else {
                    PdfDAO pd = new PdfDAO();
                    pd.ejecutar_archivoPDF(id);
                    System.out.println("hola");
                    try {
                        Desktop.getDesktop().open(new File("new.pdf"));
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }

            } else {
                String name = "" + vistaPDF.getRoot().getChildren().get(row).getValue().getNombrepdf();

            }
        }
    }

    @FXML
    public void descargarArchivo(){
        PdfDAO pd = new PdfDAO();
        pd.descargarPDF(id);
    }

}
