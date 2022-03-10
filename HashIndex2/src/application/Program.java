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
import entities.Fullbucket;
import entities.Hash;
import entities.Pagina;
import entities.Struct;
import entities.Tabela;
import entities.Tupla;

public class Program {

	public static void main(String[] args) throws IOException {
		String diretorio = System.getProperty("user.dir") + "\\teste.txt";
		Pagina pagina = new Pagina();
		lerArquivo(diretorio);


	}
	private static Tabela lerArquivo(String diretorio) throws IOException {
		Scanner in = new Scanner(new FileReader(diretorio));
		ArrayList<String> string = null;
		int FR = 2;
		int quantidadeL = contaLinhas(diretorio);
		Pagina pagina = new Pagina();
		int indiceBucket = 0; // mudar para ser o valor do hash
		Tabela tabela = new Tabela();
		
		Fullbucket fullbucket = new Fullbucket(quantidadeL,FR);
		int i = 0;
		int indiceIndicadorPagina = 0;
		int contador = 1;
		int divisor = 3; // tamanho pagina que eu quero mudar para entrada main // quant elementos por pagina
		while (in.hasNextLine()) {

			String line = in.nextLine();
Hash hash = new Hash();
indiceBucket = hash.hashT(line, divisor,quantidadeL, FR);

			Tupla tupla = new Tupla(line);
			Struct struc = new Struct(indiceIndicadorPagina,line);
			
			fullbucket.addB(indiceBucket,struc);
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
	System.out.println("quantidade de overflow : " + fullbucket.getOfg());
	//	System.out.println("quantidade de colisoes : " + ((bucket.getQuantidadeOF() * FR) + (FR - 1)));
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
	
		return lineCounter.getLineNumber();
	}
}
