package entities;

public class Struct {
	int indicePagina;
	String chave;

	public Struct(int indicePagina, String chave) {
		super();
		this.indicePagina = indicePagina;
		this.chave = chave;
		
	}

	public int getIndicePagina() {
		return indicePagina;
	}

	public void setIndicePagina(int indicePagina) {
		this.indicePagina = indicePagina;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	
}
