package alumno;

import DAO.PdfDAO;
import about.AboutController;
import chatgpt.ChatGPTController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.awt.Desktop;
import static java.awt.Desktop.getDesktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import metodos.AlumnoHolder;
import modudev.SplashScreenAlumnoController;
import nomenglaturaZip.ZipController;
import sql.Conectar;

/**
 * FXML Controller class
 *
 * @author guillermo
 */
public class InterfazAlumnoController implements Initializable {

    @FXML
    private ImageView logoModudev;
    @FXML
    private AnchorPane profesorAnchorPane;
    @FXML
    private ImageView perfilImg;
    @FXML
    private ImageView ajustesImg;
    @FXML
    private HBox menuSuperior;
    @FXML
    private JFXButton calendarioBtn;
    @FXML
    private JFXButton navegadorBtn;
    @FXML
    private JFXButton comprimirBtn;
    @FXML
    private JFXButton soporteBtn;
    @FXML
    private BorderPane modudevInterfaz;
    @FXML
    private JFXButton glosarioBtn;
    @FXML
    private JFXButton diBtn;
    @FXML
    private JFXButton sgiBtn;
    @FXML
    private JFXButton hlcBtn;
    @FXML
    private JFXButton pmmBtn;
    @FXML
    private JFXButton pspBtn;
    @FXML
    private JFXButton adBtn;
    @FXML
    private JFXButton empBtn;
    @FXML
    private JFXButton pdfBtn;
    @FXML
    private JFXButton aboutBtn;
    @FXML
    private Button cerrarSesionBtn;
    public String valorAsignatura;
    private alumno usuarioCargado = AlumnoHolder.getAlumno();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        diBtn.setOnAction(event -> {
            try {
                System.out.println(usuarioCargado.getDni());
                Conectar conec = new Conectar();
                String sen = usuarioCargado.getDni();
                String sql = "UPDATE alumnos SET valorasignatura = ? WHERE dnialumnos = ?";
                PreparedStatement ps = null;
                try {
                    ps = conec.getConnection().prepareStatement(sql);
                    ps.setString(1, "DI");
                    ps.setString(2, sen);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                } finally {
                    try {
                        ps.close();
                        conec.desconectar();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                iniciarVisorPDF();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        sgiBtn.setOnAction(event -> {
            try {
                iniciarVisorPDF();
                this.valorAsignatura = "SGE";
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        hlcBtn.setOnAction(event -> {
            try {
                iniciarVisorPDF();
                this.valorAsignatura = "HLC";
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        pmmBtn.setOnAction(event -> {
            try {
                iniciarVisorPDF();
                this.valorAsignatura = "PMM";
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        pspBtn.setOnAction(event -> {
            try {
                iniciarVisorPDF();
                this.valorAsignatura = "PSP";
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        adBtn.setOnAction(event -> {
            try {
                iniciarVisorPDF();
                this.valorAsignatura = "AD";
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        empBtn.setOnAction(event -> {
            try {
                iniciarVisorPDF();
                this.valorAsignatura = "EMP";
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public String getValorAsignatura(){return valorAsignatura;}

    //Ejecutar Ajustes perfil
    @FXML
    public void iniciarAjustes() throws IOException {

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/perfil/AjustesPerfil.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(SplashScreenAlumnoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.getIcons().add(new Image("/recursos/ModuDev.png"));
        stage.setTitle("ModuDev - Ajustes Perfil");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    //Ejecutar Herramienta de Compresión
    @FXML
    public void iniciarZip() throws IOException {

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/nomenglaturaZip/Zip.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(ZipController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.getIcons().add(new Image("/recursos/ModuDev.png"));
        stage.setTitle("ModuDev - Herramienta Compresión");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    //Ejecutar Herramienta de Compresión
    @FXML
    public void iniciarCalendario() throws IOException {

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/calendario/calendarioApp.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(ZipController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.getIcons().add(new Image("/recursos/ModuDev.png"));
        stage.setTitle("ModuDev - Calendario");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    //Ejecutar Herramienta de Compresión
    @FXML
    public void iniciarAbout() throws IOException {

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/about/about.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(AboutController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.getIcons().add(new Image("/recursos/ModuDev.png"));
        stage.setTitle("ModuDev - About");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    //Ejecutar Herramienta de Compresión
    @FXML
    public void iniciarGlosario() throws IOException {

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/glosario/glosarioApp.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(AboutController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.getIcons().add(new Image("/recursos/ModuDev.png"));
        stage.setTitle("ModuDev - Glosario");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    public void iniciarNavegador() throws URISyntaxException, IOException {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI("https://www.google.es/"));
        }
    }

    @FXML
    public void iniciarSoporte() throws URISyntaxException, IOException {
        Desktop desktop = getDesktop();
        desktop.mail(new URI("mailto:guillermojulian.gallegogonzalez@gmail.com"));
    }

    @FXML
    private void iniciarVisorPDF() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mostrarpdf/mostrarpdf.fxml"));
        AnchorPane pdfAnchorPane = (AnchorPane) fxmlLoader.load();
        try {
            profesorAnchorPane.getChildren().clear();
            profesorAnchorPane.getChildren().add(pdfAnchorPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void iniciarPDFLocal() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/pdflocal/pdflocal.fxml"));
        AnchorPane pdfAnchorPane = (AnchorPane) fxmlLoader.load();
        try {
            profesorAnchorPane.getChildren().clear();
            profesorAnchorPane.getChildren().add(pdfAnchorPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Ejecutar chatGPT
    @FXML
    public void iniciarGPT() throws IOException {

        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/chatgpt/chatGPT.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(ChatGPTController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.getIcons().add(new Image("/recursos/ModuDev.png"));
        stage.setTitle("ModuDev - ChatGPT");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }
    
}
