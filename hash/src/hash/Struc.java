package hash;

import java.util.ArrayList;

public class Struc {
	
	ArrayList<String> bucket = new ArrayList();
	ArrayList<ArrayList<String>> tables = new ArrayList();
	
	public void inject(ArrayList<String> dados, int quantidadeTabelas) {
		ArrayList<String> dadosDivididos = new ArrayList(dados.subList(0, dados.size()/2));
		System.out.println(dadosDivididos + "bra");
		//for(int b = 0;b< quantidadeTabelas;b++) {
		//tables.add(dados);
		//	
		//}
	}
	
	
	void Tables() {
		for (ArrayList<String> i : tables) {
			System.out.println(i.toString());
		
		}

	}
}
