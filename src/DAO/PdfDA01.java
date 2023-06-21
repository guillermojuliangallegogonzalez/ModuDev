package DAO;

import VO.PdfVO;
import alumno.alumno;
import metodos.AlumnoHolder;
import sql.Conectar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PdfDA01 {

    public alumno usuarioCargado = AlumnoHolder.getAlumno();

    public ArrayList<PdfVO> Listar_PdfV1() {
        StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM alumnos WHERE 1 = 1");

        if (usuarioCargado.getDi() && usuarioCargado.getValorasignatura().equals("DI")) {
            sqlBuilder.append(" AND di = 1");
        }
        if (usuarioCargado.getSge() && usuarioCargado.getValorasignatura().equals("SGE")) {
            sqlBuilder.append(" AND sge = 1");
        }
        if (usuarioCargado.getHlc() && usuarioCargado.getValorasignatura().equals("HLC")) {
            sqlBuilder.append(" AND hlc = 1");
        }
        if (usuarioCargado.getPmm() && usuarioCargado.getValorasignatura().equals("PMM")) {
            sqlBuilder.append(" AND pmm = 1");
        }
        if (usuarioCargado.getPsp() && usuarioCargado.getValorasignatura().equals("PSP")) {
            sqlBuilder.append(" AND psp = 1");
        }
        if (usuarioCargado.getAd() && usuarioCargado.getValorasignatura().equals("AD")) {
            sqlBuilder.append(" AND ad = 1");
        }
        if (usuarioCargado.getEmp() && usuarioCargado.getValorasignatura().equals("EMP")) {
            sqlBuilder.append(" AND emp = 1");
        }

        ArrayList<PdfVO> list = new ArrayList<>();
        Conectar conec = new Conectar();
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = conec.getConnection().prepareStatement(sqlBuilder.toString());
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


}
