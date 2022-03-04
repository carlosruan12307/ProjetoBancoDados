package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Bucket;
import entities.IndicePaginaC;
import entities.Pagina;
import entities.Tabela;
import entities.Tupla;

public class Program {

	public static void main(String[] args) throws FileNotFoundException {
		String diretorio = System.getProperty("user.dir") + "\\ProjetoUm.txt";
		Pagina pagina = new Pagina();
lerArquivo(diretorio).imprimirTabela();
		
		
	}
	private static Tabela lerArquivo(String diretorio) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(diretorio));
		ArrayList<String> string = null;
		Pagina pagina = new Pagina();
		int indiceBucket = 1; // mudar para ser o valor do hash
		Tabela tabela = new Tabela();
		Bucket bucket = new Bucket();
		int i = 0;
		int indiceIndicadorPagina = 0;
		int contador = 1;
		int divisor = 3; // tamanho pagina que eu quero mudar para entrada main // quant elementos por pagina
		while (in.hasNextLine()) {
	;
			String line = in.nextLine();
			IndicePaginaC ind = new IndicePaginaC(indiceBucket,line,null);
			Tupla tupla = new Tupla(line);
			bucket.addB(indiceBucket, ind);
			pagina.add(tupla);
		if(contador == divisor) {
			tabela.add(pagina);
			contador = 0;
			indiceIndicadorPagina++;
			pagina = new Pagina();
		}
			i++;
		contador++;
			
		}

		return tabela;

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
