package P1_2;

import java.text.ParseException;
import java.util.List;

public interface KlasDao {

	public List<Klas> findAll();
	
	public List<Klas> findByKlasCode(String code) throws ParseException;

	public Klas opslaan(Klas klas);

	public Klas update(Klas klas);

	public boolean verw(Klas klas);
}
