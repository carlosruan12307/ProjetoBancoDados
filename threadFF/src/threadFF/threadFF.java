package threadFF;

import java.util.Scanner;

public class threadFF {

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in); 
		System.out.println("quantidade de termos: ");

		String qtermos = obj.nextLine(); 
		
		fibonnaci fibonnaci = new fibonnaci("Thread1",Integer.parseInt(qtermos),600); // fibo
//fibonnaci fibonnaci2 = new fibonnaci(31,"Thread2",900); //fibo 2 teste
		fatorial fatorial = new fatorial("Thread2",6,900);

	}

}
