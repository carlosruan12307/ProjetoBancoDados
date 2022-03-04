package entities;

public class IndicePaginaC {
int indicePagina;
String chave;
IndicePaginaC proximo;

public IndicePaginaC(int indicePagina, String chave, IndicePaginaC proximo) {
	super();
	this.indicePagina = indicePagina;
	this.chave = chave;
	this.proximo = proximo;
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
