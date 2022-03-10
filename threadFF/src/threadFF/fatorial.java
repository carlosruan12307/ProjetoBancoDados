package threadFF;

public class fatorial extends Thread {
	String nomeThread;
	int fatorialx;
	int sleep;
	public fatorial(String nomeThread, int fatorialx, int sleep) {
		super();
		this.nomeThread = nomeThread;
		this.fatorialx = fatorialx;
		this.sleep = sleep;
		start();
	}
	
	public int calcularfatorial() {
		int fatorial = 1;
		for(int i = 1;i<= fatorialx;i++) {
			fatorial *= i; 
		}
		return fatorial;
	}
	
	public void run() {
	
		
		System.out.println(nomeThread + "terminou" + " fatorialResultado : " + calcularfatorial());
	}
}
