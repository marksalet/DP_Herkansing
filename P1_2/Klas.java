package P1_2;

import java.util.ArrayList;

public class Klas {
	private String code;
	private String Mentor;
	private int startjaar;
	
	private ArrayList<Student> student = new ArrayList<Student>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMentor() {
		return Mentor;
	}

	public void setMentor(String mentor) {
		Mentor = mentor;
	}

	public int getStartjaar() {
		return startjaar;
	}

	public void setStartjaar(int startjaar) {
		this.startjaar = startjaar;
	}

	public ArrayList<Student> getStudent() {
		return student;
	}

	public void setStudent(ArrayList<Student> student) {
		this.student = student;
	}
	
	public String getAlleStudenten()
	{
		String result = "";
		for (Student st : this.student) {
			result = result + st.getNaam() + " en ";
		}
		return result;
	}
}
