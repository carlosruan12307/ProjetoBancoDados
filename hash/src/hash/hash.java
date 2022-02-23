package hash;

public class hash {
int hashC = 0;

public int hashT(String texto,int tamanhoTabelaBucket) {
	for(int i = 0;i< texto.length();i++) {
		
		hashC = (int) texto.charAt(i) + hashC / (tamanhoTabelaBucket);
	}
	
	return hashC;
}
}
