package P1_2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class StudentOracleDaoImpl extends OracleBaseDao implements StudentDao{

	public List<Student> findAll(){
		List<Student> studentinfo = new ArrayList<Student>();
		
		Statement st = null;
		ResultSet rs = null;
		
		try (Connection conn = super.getConnection()){
			String selectStudent = "SELECT * FROM STUDENT";
			st = conn.createStatement();
			rs = st.executeQuery(selectStudent);
			
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("ID"));
				student.setNaam(rs.getString("NAAM"));
				student.setGbdatum(rs.getDate("GBDATUM"));
				student.setKlas_code(rs.getString("KLAS_CODE"));
				studentinfo.add(student);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentinfo;
	}
	
	public ArrayList<Student> findByCode(String code) throws ParseException {
		ArrayList<Student> studentInfo = new ArrayList<Student>();
		
		String selectStudentInfo = "SELECT * FROM STUDENT WHERE KLAS_CODE = '" + code +"' ";
		Statement st;
		ResultSet rs;
			
			try(Connection conn = super.getConnection()){
				st = conn.createStatement();
				rs = st.executeQuery(selectStudentInfo);
				
				while (rs.next()) {
					Student student = new Student();
					student.setNaam(rs.getString("NAAM"));
					student.setGbdatum(rs.getDate("GBDATUM"));
					studentInfo.add(student);
				}
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
	}
			return studentInfo;
	
	}
}
