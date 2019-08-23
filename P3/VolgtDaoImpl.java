package P3;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class VolgtDaoImpl extends OracleBaseDao implements VolgtDao {

    public List<Volgt> findByCode(String code) throws ParseException {

        List<Volgt> volgtinfo = new ArrayList<Volgt>();
        Statement st;
        ResultSet rs;
        try (Connection conn = super.getConnection()){
            String codeinf = "SELECT * form volgt where vak_code = '" + code +"' ";
            st = conn.createStatement();
            rs = st.executeQuery(codeinf);
            while (rs.next()) {
                Volgt volgt = new Volgt();
                volgt.setStudent_id(rs.getInt("STUDENT_ID"));
                volgt.setVak_code(rs.getString("VAK_CODE"));
                volgtinfo.add(volgt);
            }
            conn.close();
        }	catch (SQLException e) {
            e.printStackTrace();
        }
        return volgtinfo;
    }

}
