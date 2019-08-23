package P3;

import java.text.ParseException;
import java.util.List;

public interface VakDao {

    public List<Vak> findByCode(String code) throws ParseException;
}
