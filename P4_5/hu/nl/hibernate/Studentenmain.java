package hu.nl.hibernate;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Studentenmain {
	private static SessionFactory factory;

	public static void main(String[] args) throws ParseException {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Studentenmain SE = new Studentenmain();

	  SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
      Integer st11 = SE.addStudent(485, "Ja", format.parse("23-12-2019"), "V1E");

      SE.updateStudent(st11, "jan");
      SE.listStudenten();
      SE.deleteStudent(485);
      SE.listStudenten();
	}

	public void updateStudent(Integer StudentID, String naam) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Student student = (Student)session.get(Student.class, StudentID);
			student.setNaam(naam);
			session.update(student);
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}	
		
	public void listStudenten() {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List studenten = session.createQuery("FROM Student").list();
	         for (Iterator iterator = studenten.iterator(); iterator.hasNext();){
				Student student = (Student) iterator.next();
				System.out.println("Naam: " + student.getNaam() + "Klas: " + student.getKlascode() + "Geboortedatum: " + student.getGbdatum());
				;
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	public void deleteStudent(Integer StudentID) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Student student = (Student)session.get(Student.class, StudentID);
			session.delete(student);
			tx.commit();
		} catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}
	
	public Integer addStudent(int id, String naam, Date gbdatum, String klascode) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer nm = null;

		try {
			tx = session.beginTransaction();
			Student student = new Student();
			student.setId(id);
			student.setNaam(naam);
			student.setGbdatum(gbdatum);
			student.setKlascode(klascode);
			nm = (Integer) session.save(student);
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return nm;
	}
}
