package P1_2;

import java.sql.*;
import java.text.*;

public class Main {
	public static void main(String[] args) throws SQLException, ParseException {
		KlasOracleDaoImpl klasDao = new KlasOracleDaoImpl();
		StudentOracleDaoImpl studentDao = new StudentOracleDaoImpl();

		System.out.println("klassen:");
		for (Klas klas : klasDao.findAll()) {
			System.out.println("Klas: " + klas.getCode()+ "Mentor : " + klas.getMentor());
		}

				System.out.println("studenten:");
				for (Student student : studentDao.findAll()) {
					System.out.println("ID: " + student.getId() + "Naam : " + student.getNaam() + "Geboortedatum: " + student.getGbdatum() + "Klas: " + student.getKlas_code());
				} 

		for (Klas klas : klasDao.findByKlasCode("V1E")) {
			System.out.println("Klas: " + klas.getCode() + "Leerlingen: " + klas.getAlleStudenten());
		}

		Klas klas1 = new Klas();
		klas1.setCode("V1O");
		klas1.setMentor("Man");
		klas1.setStartjaar(2027);
		klasDao.opslaan(klas1);
		klas1.setMentor("Vrouw");
		klasDao.update(klas1);

		System.out.println("studenten:");
		for (Student student : studentDao.findAll()) {
			System.out.println("ID: " + student.getId() + "Naam : " + student.getNaam() + "Geboortedatum: " + student.getGbdatum());
		}

		klasDao.verw(klas1);

		System.out.println("Alle studenten:");
		for (Student student : studentDao.findAll()) {
			System.out.println("ID: " + student.getId() + "Naam : " + student.getNaam() + "Geboortedatum: " + student.getGbdatum());
		}

		System.out.println("Alle klassen:");
		for (Klas klas : klasDao.findAll()) {
			System.out.println("Klas: " + klas.getCode()+ "Mentor : " + klas.getMentor());
		}

	}
}
