package P3;

import java.text.ParseException;
import java.util.List;

public interface VolgtDao {
    public List<Volgt> findByCode(String code) throws ParseException;




}
