package P1_2;

import java.sql.SQLException;
import java.text.ParseException;

public class MainStudent {
	public static void main(String[] args) throws SQLException, ParseException {
		StudentOracleDaoImpl studentDao = new StudentOracleDaoImpl();

		System.out.println("studenten:");
		for (Student student : studentDao.findAll()) {
			System.out.println("Naam : " + student.getNaam() + " | Geboortedatum: " + student.getGbdatum() + " | Klas: " + student.getKlas_code());
		}


		System.out.println("Alle sttudenten van V1A:");
		for (Student st1 : studentDao.findByCode("V1A")){
			System.out.println("Naam: " + st1.getNaam());
		}
		
		
	}
}
