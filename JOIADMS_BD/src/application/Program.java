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
import entities.DadosF;
import entities.Fullbucket;
import entities.Hash;
import entities.Pagina;
import entities.Struct;
import entities.Tabela;
import entities.Tupla;

public class Program {

	public static void main(String[] args) throws IOException {
		int FR = 2;
		String diretorio = System.getProperty("user.dir") + "\\teste.txt";
		int quantidadeL = contaLinhas(diretorio);
		Hash hash = new Hash();
		Fullbucket fullbucket = new Fullbucket(quantidadeL,FR);
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Digite quantidade de tuplas por paginas que voce deseja");

		String divisor = myObj.nextLine();  // Read user input
		DadosF dadosf =  lerArquivo(diretorio,Integer.parseInt(divisor),fullbucket,FR);
		Fullbucket r = dadosf.getFullbucket();
		Tabela r1 = dadosf.getTabela();
		Scanner myObj1 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Digite a palavra a ser pesquisada");

		String palavra = myObj1.nextLine();
	//	System.out.println(retornarP(palavra,hash.hashT(palavra),r));
		System.out.println(	buscarTabela(palavra,retornarP(palavra,hash.hashT(palavra),r,FR),r1));

	}
	private static DadosF lerArquivo(String diretorio,int divisor, Fullbucket fullbucket, int FR) throws IOException {
		Scanner in = new Scanner(new FileReader(diretorio));
		ArrayList<String> string = null;


		Pagina pagina = new Pagina();
		int indiceBucket; // mudar para ser o valor do hash
		Tabela tabela = new Tabela();
		int indiceIndicadorPagina = 0;
		int contador = 1;
		// tamanho pagina que eu quero mudar para entrada main // quant elementos por pagina
		while (in.hasNextLine()) {

			String line = in.nextLine();
			Hash hash = new Hash();
			indiceBucket = hash.hashT(line);

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
			contador++;




		}
		 contaOFC(fullbucket,FR);


		DadosF dadosf = new DadosF(fullbucket,tabela);
		return dadosf;

	}
	private static Tupla buscarTabela(String palavra,int indicePagina, Tabela tabela) {

		for(int i = 0 ; i< tabela.getTabela().get(indicePagina).getPagina().size();i++) {
			
			if(tabela.getTabela().get(indicePagina).getPagina().get(i).getPk().equals(palavra)) {
				System.out.println("Numero da Tupla que a palavra esta na pagina :  " + i);
				return tabela.getTabela().get(indicePagina).getPagina().get(i);

			}

		}
		return null;
	}
	private static void contaOFC(Fullbucket fullbucket, int FR) {
		double of = 0;
		double c = 0;
		for(int i = 0;i< fullbucket.getB().length;i++) {
			if(fullbucket.getB()[i] != null) {
				of = of + fullbucket.getB()[i].getQuantidadeOF();
				c = c + fullbucket.getB()[i].getQuantidadeC();
				if(fullbucket.getB()[i].getQuantidadeOF() > 0) {
					//System.out.println("bucket " + i + " tem " + fullbucket.getB()[i].getQuantidadeOF() + " overflows " + " e " + fullbucket.getB()[i].getQuantidadeC() + " colisoes ");
				}
			}

		}
		System.out.println("quantidade de overflow : " + of);
		System.out.println("quantidade de colisoes : " + c);
		
	}

	private static int retornarP(String palavra,int valorH, Fullbucket fullbucket, int FR) {
		for(int j = 0;j<FR;j++ ) {
			if(	fullbucket.getB()[valorH].getBucket().get(j).getChave().equals(palavra)) {
				System.out.println("pagina que a palavra esta : " + fullbucket.getB()[valorH].getBucket().get(j).getIndicePagina());

				return fullbucket.getB()[valorH].getBucket().get(j).getIndicePagina();
			}
		}
	
				for(int i = 0 ;i< fullbucket.getB()[valorH].getOfbuckets().size();i++) {
					for(int j = 0;j < fullbucket.getB()[valorH].getOfbuckets().get(i).getBucket().size();j++) {
						if(fullbucket.getB()[valorH].getOfbuckets().get(i).getBucket().get(j).getChave().equals(palavra) ) {
							System.out.println("pagina que a palavra esta : " + fullbucket.getB()[valorH].getOfbuckets().get(i).getBucket().get(j).getIndicePagina());
							return fullbucket.getB()[valorH].getOfbuckets().get(i).getBucket().get(j).getIndicePagina();
						
						}
					}
				}
			
		return 1;
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
