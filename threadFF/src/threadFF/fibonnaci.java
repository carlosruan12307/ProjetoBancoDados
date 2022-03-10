package threadFF;

public class fibonnaci extends Thread {
	String nomeThread;
	int quantidadedetermos;
	int sleep;
	public fibonnaci(String nomeThread,int quantidadedetermos,  int sleep) {
		super();
		this.quantidadedetermos = quantidadedetermos;
		this.nomeThread = nomeThread;
		this.sleep = sleep;
		start();
	}

	public int calcularFibo(int a) {
		if (a < 2) {
			return a;
		} else {
			return calcularFibo(a - 1) + calcularFibo(a - 2);
		}


	}



	public void run() {
		for (int i = 0; i < quantidadedetermos; i++) {
			System.out.print(nomeThread + "(" + i + "):" + calcularFibo(i) + "\t");
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(nomeThread + "terminou");
	}

}
