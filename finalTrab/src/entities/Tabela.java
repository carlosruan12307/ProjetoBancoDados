package entities;

import java.util.ArrayList;
import java.util.List;

public class Tabela {
	 List<Pagina> Tabela;

	public Tabela() {
		super();
		this.Tabela =  new ArrayList<Pagina>();
	}

	public List<Pagina> getTabela() {
		return Tabela;
	}

	public void setTabela(List<Pagina> tabela) {
		Tabela = tabela;
	}
public void add(Pagina pagina) {
	this.Tabela.add(pagina);
}
public void imprimirTabela() {
	 for(int i = 0;i < Tabela.size();i++) {
		 System.out.println("[");
		 for(var j = 0;j<  Tabela.get(i).Pagina.size();j++) {
			 System.out.println(Tabela.get(i).Pagina.get(j).getPk());
		 }
		 System.out.println("]");
	 }
}
	
}
