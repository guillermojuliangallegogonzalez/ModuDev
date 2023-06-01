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
                usuario.setDni(rs.getString(2));
                usuario.setNombre(rs.getString(3));
                usuario.setApellido(rs.getString(4));
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

    public ArrayList<alumno> Listar_Usuarios(){

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
                usuario.setDni(rs.getString(2));
                usuario.setNombre(rs.getString(3));
                usuario.setApellido(rs.getString(4));
                usuario.setEsalumno(rs.getBoolean(7));
                usuario.setEsprofesor(rs.getBoolean(8));
                usuario.setEsadmin(rs.getBoolean(9));
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

    public void Alta_ALUMNO(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET esalumno = 1 WHERE idalumno = ?;";
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

    public void Baja_ALUMNO(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET esalumno = 0 WHERE idalumno = ?;";
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

    public void Alta_PROFESOR(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET esprofesor = 1 WHERE idalumno = ?;";
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

    public void Baja_PROFESOR(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET esprofesor = 0 WHERE idalumno = ?;";
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

    public void Alta_ADMIN(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET esadmin = 1 WHERE idalumno = ?;";
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

    public void Baja_ADMIN(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET esadmin = 0 WHERE idalumno = ?;";
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

    public void Alta_DI(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET di = 1 WHERE idalumno = ?;";
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

    public void Alta_SGE(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET sge = 1 WHERE idalumno = ?;";
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

    public void Alta_HLC(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET hlc = 1 WHERE idalumno = ?;";
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

    public void Alta_PMM(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET pmm = 1 WHERE idalumno = ?;";
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

    public void Alta_PSP(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET psp = 1 WHERE idalumno = ?;";
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

    public void Alta_AD(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET ad = 1 WHERE idalumno = ?;";
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

    public void Alta_EMP(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET emp = 1 WHERE idalumno = ?;";
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

    public void Baja_DI(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET di = 0 WHERE idalumno = ?;";
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

    public void Baja_SGE(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET sge = 0 WHERE idalumno = ?;";
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

    public void Baja_HLC(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET hlc = 0 WHERE idalumno = ?;";
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

    public void Baja_PMM(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET pmm = 0 WHERE idalumno = ?;";
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

    public void Baja_PSP(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET psp = 0 WHERE idalumno = ?;";
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

    public void Baja_AD(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET ad = 0 WHERE idalumno = ?;";
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

    public void Baja_EMP(alumno vo) throws RuntimeException {
        Conectar conec = new Conectar();
        String sql = "UPDATE alumnos SET emp = 0 WHERE idalumno = ?;";
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
