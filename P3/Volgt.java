package P3;

public class Volgt {
    private int student_id;
    private Student student;
    private Vak vak;
    private String vak_code;

    public Volgt(){

    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Vak getVak() {
        return vak;
    }

    public void setVak(Vak vak) {
        this.vak = vak;
    }

    public String getVak_code() {
        return vak_code;
    }

    public void setVak_code(String vak_code) {
        this.vak_code = vak_code;
    }
}
