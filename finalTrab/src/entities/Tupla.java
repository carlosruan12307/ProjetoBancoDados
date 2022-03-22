package entities;

public class Tupla {
	
	private String pk;

	public Tupla(String pk) {
		this.pk = pk;
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	@Override
	public String toString() {
		return "Tupla [pk=" + pk + "]";
	}
	
	
}
