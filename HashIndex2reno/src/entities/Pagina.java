package entities;

import java.util.ArrayList;
import java.util.List;

public class Pagina {

	int id;
	ArrayList<Tupla> Pagina;

	public Pagina() {
		super();
		this.Pagina = new ArrayList<Tupla>();
	}

	public List<Tupla> getPagina() {
		return Pagina;
	}

	public void setPagina(ArrayList<Tupla> pagina) {
		Pagina = pagina;
	}

	public void add(Tupla tupla) {
		this.Pagina.add(tupla);
	}
	
	

}
