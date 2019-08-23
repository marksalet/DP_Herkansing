package P1_2;

import java.sql.*;

public class Student {
	private int id;
	private String naam;
	private Date gbdatum;
	private String klas_code;
	
	private Klas klas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Date getGbdatum() {
		return gbdatum;
	}

	public void setGbdatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}

	public String getKlas_code() {
		return klas_code;
	}

	public void setKlas_code(String klas_code) {
		this.klas_code = klas_code;
	}

	public Klas getKlas() {
		return klas;
	}

	public void setKlas(Klas klas) {
		this.klas = klas;
	}
	
	
}
