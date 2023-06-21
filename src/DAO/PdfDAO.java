package DAO;

import alumno.alumno;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.stage.FileChooser;
import metodos.AlumnoHolder;
import modudev.SigInController;
import sql.Conectar;
import VO.PdfVO;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import alumno.InterfazAlumnoController;

public class PdfDAO extends RecursiveTreeObject<PdfDAO> {

    alumno usuario = new alumno();
    private String asignatura;
    private alumno usuarioCargado = AlumnoHolder.getAlumno();
    SigInController controller;
    /*Metodo listar*/

    public String getAsignatura(){
        Conectar conec = new Conectar();
        String sql = "SELECT valorasignatura FROM alumnos WHERE dnialumnos = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1,usuarioCargado.getDni());
            rs = ps.executeQuery();
            while (rs.next()) {
                String asignatura = rs.getString(11);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
        return asignatura;
    }


    public ArrayList<PdfVO> Listar_PdfVO() {

        //usuario = controller.obtenerAlumno();
        ArrayList<PdfVO> list = new ArrayList<PdfVO>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM pdf;";
        System.out.println(usuarioCargado.getDi());
        if(usuarioCargado.getDi()){
            sql = "SELECT * FROM pdf WHERE di = 1;";
        } else if (usuarioCargado.getSge()) {
            sql = "SELECT * FROM pdf WHERE sge = 1;";
        }else if (usuarioCargado.getHlc()) {
            sql = "SELECT * FROM pdf WHERE hlc = 1;";
        }else if (usuarioCargado.getPmm()) {
            sql = "SELECT * FROM pdf WHERE pmm = 1;";
        }else if (usuarioCargado.getPsp()) {
            sql = "SELECT * FROM pdf WHERE psp = 1;";
        }else if (usuarioCargado.getAd()) {
            sql = "SELECT * FROM pdf WHERE ad = 1;";
        }else if (usuarioCargado.getEmp()) {
            sql = "SELECT * FROM pdf WHERE emp = 1;";
        }
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PdfVO vo = new PdfVO();
                vo.setCodigopdf(rs.getInt(1));
                vo.setNombrepdf(rs.getString(2));
                vo.setArchivopdf(rs.getBytes(3));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
        return list;
    }

    /*Metodo agregar*/
    public void Agregar_PdfVO(PdfVO vo) {
        Conectar conec = new Conectar();
        String sql = "INSERT INTO pdf (codigopdf, nombrepdf, archivopdf,di,sge,hlc,pmm,psp,ad,emp) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getCodigopdf());
            ps.setString(2, vo.getNombrepdf());
            ps.setBytes(3, vo.getArchivopdf());
            if(usuarioCargado.getDi()){
                ps.setInt(4,1);
                ps.setInt(5,0);
                ps.setInt(6,0);
                ps.setInt(7,0);
                ps.setInt(8,0);
                ps.setInt(9,0);
                ps.setInt(10,0);
            }else if(usuarioCargado.getSge()){
                ps.setInt(4,0);
                ps.setInt(5,1);
                ps.setInt(6,0);
                ps.setInt(7,0);
                ps.setInt(8,0);
                ps.setInt(9,0);
                ps.setInt(10,0);
            }else if(usuarioCargado.getHlc()){
                ps.setInt(4,0);
                ps.setInt(5,0);
                ps.setInt(6,1);
                ps.setInt(7,0);
                ps.setInt(8,0);
                ps.setInt(9,0);
                ps.setInt(10,0);
            }else if(usuarioCargado.getPmm()){
                ps.setInt(4,0);
                ps.setInt(5,0);
                ps.setInt(6,0);
                ps.setInt(7,1);
                ps.setInt(8,0);
                ps.setInt(9,0);
                ps.setInt(10,0);
            }else if(usuarioCargado.getPsp()){
                ps.setInt(4,0);
                ps.setInt(5,0);
                ps.setInt(6,0);
                ps.setInt(7,0);
                ps.setInt(8,1);
                ps.setInt(9,0);
                ps.setInt(10,0);
            }else if(usuarioCargado.getAd()){
                ps.setInt(4,0);
                ps.setInt(5,0);
                ps.setInt(6,0);
                ps.setInt(7,0);
                ps.setInt(8,0);
                ps.setInt(9,1);
                ps.setInt(10,0);
            }else if(usuarioCargado.getEmp()){
                ps.setInt(4,0);
                ps.setInt(5,0);
                ps.setInt(6,0);
                ps.setInt(7,0);
                ps.setInt(8,0);
                ps.setInt(9,0);
                ps.setInt(10,1);
            }
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
            }
        }
    }


    /*Metodo Modificar*/
    public void Modificar_PdfVO(PdfVO vo) {
        Conectar conec = new Conectar();
        String sql = "UPDATE pdf SET nombrepdf = ?, archivopdf = ?  WHERE codigopdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombrepdf());
            ps.setBytes(2, vo.getArchivopdf());
            ps.setInt(3, vo.getCodigopdf());
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
            }
        }
    }

    public void Modificar_PdfVO2(PdfVO vo) {
        Conectar conec = new Conectar();
        String sql = "UPDATE pdf SET nombrepdf = ? WHERE codigopdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombrepdf());
            ps.setInt(2, vo.getCodigopdf());
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
            }
        }
    }

    //Descargar PDF
    public void descargarPDF(int id) {
        Conectar cn = new Conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] archivoPDF = null;

        try {
            ps = cn.getConnection().prepareStatement("SELECT archivopdf FROM pdf WHERE codigopdf = ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                archivoPDF = rs.getBytes("archivopdf");
            }

            if (archivoPDF != null) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Guardar archivo PDF");
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos PDF", "*.pdf"));
                File file = fileChooser.showSaveDialog(new Stage());
                if (file != null) {
                    Path path = Paths.get(file.getAbsolutePath());
                    FileOutputStream fileOutputStream = new FileOutputStream(path.toFile());
                    fileOutputStream.write(archivoPDF);
                    fileOutputStream.close();
                }
            }
        } catch (Exception ex) {
            System.out.println("Error al descargar el archivo PDF: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                cn.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar las conexiones: " + ex.getMessage());
            }
        }
    }

    /*Metodo Eliminar*/
    public void Eliminar_PdfVO(PdfVO vo) {
        Conectar conec = new Conectar();
        String sql = "DELETE FROM pdf WHERE codigopdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getCodigopdf());
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
            }
        }
    }

    //Permite mostrar PDF contenido en la base de datos
    public void ejecutar_archivoPDF(int id) {

        Conectar cn = new Conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;

        try {
            ps = cn.getConnection().prepareStatement("SELECT archivopdf FROM pdf WHERE codigopdf = ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            OutputStream out = Files.newOutputStream(Paths.get("new.pdf"));
            out.write(datosPDF);

            //abrir archivo
            out.close();
            bos.close();
            ps.close();
            rs.close();
            cn.desconectar();

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF " + ex.getMessage());
        }
    }

}

