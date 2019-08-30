package hu.nl.hibernate;

import java.util.Date;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "STUDENT")
public class Student {
		@Id @GeneratedValue
		@Column(name = "id")
		private int id;
		
		@Column(name = "naam")
		private String naam;
		
		@Column(name = "gbdaum")
		private Date gbdatum;
		
		@Column(name = "klas_code")
		private String klascode;
		private Set classes;
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

		public String getKlascode() {
			return klascode;
		}

		public void setKlascode(String klascode) {
			this.klascode = klascode;
		}

		public Klas getKlas() {
			return klas;
		}

		public void setKlas(Klas klas) {
			this.klas = klas;
		}

		public Set getClasses() {
			return classes;
		}

		public void setClasses(Set classes) {
			this.classes = classes;
		}
		
		

}
