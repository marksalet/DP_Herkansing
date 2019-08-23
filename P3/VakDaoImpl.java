package P3;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class VakDaoImpl extends OracleBaseDao implements VakDao {

    public List<Vak> findByCode(String code) throws ParseException {

        List<Vak> vakinfo = new ArrayList<Vak>();
        Statement st;
        ResultSet rs;
        try (Connection conn = super.getConnection()){
            String codeinf = "SELECT * from vak where code = '" + code +"' ";
            st = conn.createStatement();
            rs = st.executeQuery(codeinf);
            while (rs.next()) {
                Vak vak = new Vak();
                vak.setCode(rs.getString("CODE"));
                vak.setNaam(rs.getString("NAAM"));
                vak.setEcts(rs.getInt("ECTS"));
                vakinfo.add(vak);
            }
            conn.close();
        }	catch (SQLException e) {
            e.printStackTrace();
        }
        return vakinfo;
    }


}
