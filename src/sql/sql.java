package sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sql {

    public int auto_increment(String sql) {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conectar db = new Conectar();
        try {
            ps = db.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            System.out.println("idmaximo" + ex.getMessage());
            id = 1;
        } finally {
            try {
                ps.close();
                rs.close();
                db.desconectar();
            } catch (SQLException ex) {
            }
        }
        return id;
    }

    public static void main(String[] args) {
    }

}