package P1_2;

import java.sql.*;
import java.text.*;
import java.util.*;

public class KlasOracleDaoImpl extends OracleBaseDao implements KlasDao {

	public List<Klas> findbyklascode(String code) throws ParseException {
		StudentOracleDaoImpl stImpl = new StudentOracleDaoImpl();
		
		List<Klas> klasinfo = new ArrayList<Klas>();
		Statement st;
		ResultSet rs;
		try (Connection conn = super.getConnection()){
			String codeinf = "SELECT * from klas where code = '" + code +"' ";
			st = conn.createStatement();
			rs = st.executeQuery(codeinf);
			while (rs.next()) {
				Klas klas = new Klas();
				klas.setCode(rs.getString("CODE"));
				klas.setMentor(rs.getString("MENTOR"));
				klas.setStartjaar(rs.getInt("STARTJAAR"));
				klas.setStudent(stImpl.findByCode(rs.getString("CODE")));
				klasinfo.add(klas);
			}
			conn.close();
		}	catch (SQLException e) {
			e.printStackTrace();
		}
		return klasinfo;
	}

	public List<Klas> findAll(){
		List<Klas> klasinfo = new ArrayList<Klas>();
		Statement st = null;
		ResultSet rs = null;
		try (Connection conn = super.getConnection()){
			String selectKlas = "SELECT * from klas";
			st = conn.createStatement();
			rs = st.executeQuery(selectKlas);
			while (rs.next()) {
				Klas klas = new Klas();
				klas.setCode(rs.getString("CODE"));
				klas.setMentor(rs.getString("MENTOR"));
				klas.setStartjaar(rs.getInt("STARTJAAR"));
				klasinfo.add(klas);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return klasinfo;
	}

	public Klas opslaan(Klas klas) {
		Statement st;
		String insertKlas = "INSERT INTO KLAS (CODE, MENTOR, STARTJAAR)VALUES (" + "'" + klas.getCode() + "'" + "," + "'" + klas.getMentor() + "'" + "," + klas.getStartjaar() + ")";
		try (Connection conn = super.getConnection()){
			st = conn.prepareStatement(insertKlas);
			st.executeUpdate(insertKlas);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return klas;
	}

	public Klas update(Klas klas){
		Statement st;
		String updateKlas = "UPDATE klas set mentor = " + "'" + klas.getMentor() + "'" + "," + "startjaar = " + klas.getStartjaar() + "where code = " + "'" + klas.getCode() + "'";
		try (Connection conn = super.getConnection()){
			st = conn.prepareStatement(updateKlas);
			st.executeUpdate(updateKlas);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return klas;
	}

	public boolean verw(Klas klas){
		Statement st;
		boolean result = false;
		try (Connection conn = super.getConnection()){
			String deleteKlas = "DELETE from klas where code = " + "'" + klas.getCode() + "'";
			st = conn.createStatement();
			st.executeUpdate(deleteKlas);
			result = true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Klas> findByKlasCode(String code) throws ParseException {
		List<Klas> klasinfo = new ArrayList<Klas>();
		Statement st = null;
		ResultSet rs = null;
		try (Connection conn = super.getConnection()){
			String selectKlas = "SELECT * from klas WHERE code ='" + code + "'";
			st = conn.createStatement();
			rs = st.executeQuery(selectKlas);
			while (rs.next()) {
				Klas klas = new Klas();
				klas.setCode(rs.getString("CODE"));
				klas.setMentor(rs.getString("MENTOR"));
				klas.setStartjaar(rs.getInt("STARTJAAR"));
				klasinfo.add(klas);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return klasinfo;
	}

	
	

}
