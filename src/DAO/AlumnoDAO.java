package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import VO.PdfVO;
import alumno.alumno;
import sql.Conectar;

public class AlumnoDAO {

    public ArrayList<alumno> Listar_Alumnos(){

        ArrayList<alumno> list = new ArrayList<alumno>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM alumnos;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                alumno usuario = new alumno();
                usuario.setDi(rs.getBoolean(10));
                usuario.setSge(rs.getBoolean(11));
                usuario.setHlc(rs.getBoolean(12));
                usuario.setPmm(rs.getBoolean(13));
                usuario.setPsp(rs.getBoolean(14));
                usuario.setAd(rs.getBoolean(15));
                usuario.setEmp(rs.getBoolean(16));
                list.add(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                assert ps != null;
                ps.close();
                assert rs != null;
                rs.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
        return list;

    }

    public void Eliminar_Alumno(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "DELETE FROM alumnos WHERE idalumno = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getIdalumno());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                assert ps != null;
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
