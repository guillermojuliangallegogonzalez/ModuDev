package manejarPdf;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import sql.sql;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * FXML Controller class
 *
 * @author guillermogallegogonzalez
 */
public class ManejarpdfController implements Initializable {

    @FXML
    private JFXTreeTableView<PdfVO> vistaPDF;
    @FXML
    private TextField nombreArchivoBtn;
    @FXML
    private Button subirArchivoBtn;
    @FXML
    private JFXButton nuevoBtn;
    @FXML
    private JFXButton eliminarBtn;
    @FXML
    private JFXButton modificarBtn;
    @FXML
    private JFXButton guardarBtn;
    @FXML
    private JFXButton cancelarBtn;
    @FXML
    private AnchorPane anchorPane;

    Tabla_PdfVO tpdf = new Tabla_PdfVO();
    String ruta_archivo = "";
    int id = -1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tpdf.visualizar_PdfVO(vistaPDF);
        activarBotones(true,true,true);
        nombreArchivoBtn.setDisable(true);
    }

    //Función para establecer el inicio del gestor de pdfs
    public void activarBotones(boolean guardar, boolean modificar, boolean eliminar){
        guardarBtn.setDisable(guardar);
        modificarBtn.setDisable(modificar);
        eliminarBtn.setDisable(eliminar);
        nombreArchivoBtn.setText("");
        subirArchivoBtn.setText("Seleccionar...");
    }

    public void guardar_pdf(int codigo, String nombre, File ruta) {
        PdfDAO pa = new PdfDAO();
        PdfVO po = new PdfVO();
        po.setCodigopdf(codigo);
        po.setNombrepdf(nombre);
        try {
            byte[] pdf = new byte[(int) ruta.length()];
            InputStream input = Files.newInputStream(ruta.toPath());
            input.read(pdf);
            po.setArchivopdf(pdf);
        } catch (IOException ex) {
            po.setArchivopdf(null);
        }
        pa.Agregar_PdfVO(po);
    }

    public void modificar_pdf(int codigo, String nombre, File ruta) {
        PdfDAO pa = new PdfDAO();
        PdfVO po = new PdfVO();
        po.setCodigopdf(codigo);
        po.setNombrepdf(nombre);
        try {
            byte[] pdf = new byte[(int) ruta.length()];
            InputStream input = Files.newInputStream(ruta.toPath());
            input.read(pdf);
            po.setArchivopdf(pdf);
        } catch (IOException ex) {
            po.setArchivopdf(null);
            //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
        }
        pa.Modificar_PdfVO(po);
    }

    public void modificar_pdf(int codigo, String nombre) {
        PdfDAO pa = new PdfDAO();
        PdfVO po = new PdfVO();
        po.setCodigopdf(codigo);
        po.setNombrepdf(nombre);
        pa.Modificar_PdfVO2(po);
    }

    public void eliminar_pdf(int codigo) {
        PdfDAO pa = new PdfDAO();
        PdfVO po = new PdfVO();
        po.setCodigopdf(codigo);
        pa.Eliminar_PdfVO(po);
    }

    public void seleccionar_pdf() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        File selectedFile = fileChooser.showOpenDialog(anchorPane.getScene().getWindow());
        if (selectedFile != null) {
            ruta_archivo = selectedFile.getAbsolutePath();
            subirArchivoBtn.setText(selectedFile.getName());
        }
    }

    @FXML
    public void accionGuardar(){
        String nombre = nombreArchivoBtn.getText();
        sql s = new sql();
        int codigo = s.auto_increment("SELECT MAX(codigopdf) FROM pdf;");
        File ruta = new File(ruta_archivo);
        if (nombre.trim().length() != 0 && ruta_archivo.trim().length() != 0) {
            guardar_pdf(codigo, nombre, ruta);
            tpdf.visualizar_PdfVO(vistaPDF);
            ruta_archivo = "";
            activarBotones(true, true, true);
            nombreArchivoBtn.setDisable(true);
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error Campos!");
            alerta.setHeaderText("Rellena todos los campos");
            alerta.setContentText("Rellena todos los campos necesarios para la correcta subida del pdf a la base de datos");
        }
    }

    @FXML
    public void accionModificar(){
        String nombre = nombreArchivoBtn.getText();
        File ruta = new File(ruta_archivo);
        if (nombre.trim().length() != 0 && ruta_archivo.trim().length() != 0) {
            modificar_pdf(id, nombre, ruta);
            tpdf.visualizar_PdfVO(vistaPDF);
        } else if (ruta_archivo.trim().length() == 0) {
            modificar_pdf(id, nombre);
            tpdf.visualizar_PdfVO(vistaPDF);
        }
        ruta_archivo = "";
        activarBotones(true, true, true);
        nombreArchivoBtn.setDisable(true);
    }

    @FXML
    public void accionClick() {
        int column = vistaPDF.getSelectionModel().getSelectedCells().get(0).getColumn();
        int row = vistaPDF.getSelectionModel().getSelectedCells().get(0).getRow();
        activarBotones(true, false, false);
        nombreArchivoBtn.setDisable(false);

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
                nombreArchivoBtn.setText(name);
            }
        }
    }

    @FXML
    public void accionEliminar(){
        eliminar_pdf(id);
        tpdf.visualizar_PdfVO(vistaPDF);
        activarBotones(true, true, true);
        nombreArchivoBtn.setDisable(true);
        ruta_archivo = "";
    }

    @FXML
    public void accionCancelar(){
        activarBotones(true,true,true);
        ruta_archivo = "";
        nombreArchivoBtn.setDisable(true);
    }

    @FXML
    public void accionNuevo(){
        activarBotones(false,true,true);
        nombreArchivoBtn.setDisable(false);
        ruta_archivo = "";
    }

}
