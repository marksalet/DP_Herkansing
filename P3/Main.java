package P3;

        import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        VakDao vDAO = new VakDaoImpl();
        VolgtDao volgDao = new VolgtDaoImpl();

        for (Vak vak : vDAO.findByCode("WAC")){
            System.out.println("Vakc " + vak.getCode() + " | Naam: " + vak.getNaam() + " | ECTS: " + vak.getEcts());
        }


        System.out.println("Vak wac:");
        for (Vak vak : vDAO.findByCode("WAC")){
            System.out.println("Vak " + vak.getCode() + " | Naam: " + vak.getNaam() + " | ECTS: " + vak.getEcts());
        }


        for(Volgt volgt : volgDao.findByCode("PTW")){
            System.out.println("LeerlingenID: " + volgt.getStudent_id() + " volgen ptw");
        }




    }
}
