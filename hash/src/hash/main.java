package hash;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {
		String x = "Carlos Oliveira";
		hash teste = new hash();
		Struc teste1 = new Struc();
		System.out.println(teste.hashT(x,100));
		
		String diretorio = System.getProperty("user.dir") + "\\ProjetoUm.txt";
		System.out.println(diretorio);
		
		ArrayList<String> dados = new ArrayList();
		
		lerArquivo(diretorio, dados);	
		//ImprimirDados(dados);
		//teste1.inject(dados,2);
		//teste1.Tables();
		
	}
	private static void ImprimirDados(ArrayList<String> dados) {
		for (String i : dados) {
			System.out.println(i.toString());
		
		}

	}
	
	
	private static void lerArquivo(String diretorio, ArrayList<String> dados) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(diretorio));
		ArrayList<String> string = null;
		ArrayList<String> paginas = (ArrayList<String>) dados.clone();
		List<List<String>> tables = new ArrayList<List<String>>();
		int i = 0;
		int contador = 0;
		int divisor = 2; // tamanho pagina que eu quero mudar para entrada main
		while (in.hasNextLine()) {
			
			String line = in.nextLine();
			dados.add(line);
		paginas.add(line);
			i++;
			contador++;
			if(contador == divisor || in.hasNextLine() == false) {
				tables.add((List<String>) paginas.clone());
				paginas.clear();
				
				contador = 0;
			}
			
		}

		System.out.println("tables : " + tables);
		System.out.println("dados : " + dados);

	}
	
	
	private static int converteInt(String string) {
		return Integer.parseInt(string);
	}
	
	private static double converteDouble(String string) {
		return Double.parseDouble(string);
	}
	@SuppressWarnings("unused")
	private static int contaLinhas(String diretorio) throws IOException {
		@SuppressWarnings("resource")
		LineNumberReader lineCounter = new LineNumberReader(new InputStreamReader(new FileInputStream(diretorio)));
		String nextLine = null;
		while ((nextLine = lineCounter.readLine()) != null) {
			if (nextLine == null)
				break;
		}
		System.out.println("Total number of line in this file " + lineCounter.getLineNumber());
		return lineCounter.getLineNumber();
	}
}
