package entities;

public class Hash {
	int hashC = 0;
	String aux = "";
	String k = "79108105.0";
	   StringBuilder retorno = new StringBuilder();
	public int hashT(String texto) {

		for(int i = 0;i< texto.length();i++) {
			
			aux = aux + "" + (int) texto.charAt(i);
		}
	if(aux.length() >= 5) {
//	System.out.println( Integer.parseInt(aux.substring(0,5)));
		return Integer.parseInt(aux.substring(0,5));
	}else {
	//	System.out.println(aux);
		return Integer.parseInt(aux);
	}
	}

}
