import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Turma extends Thread{
	private String nome;
	private int tempo_de_visita;
	private ArrayList<Parque> parques;
	CyclicBarrier b;

	public Turma(String nome, int tempo_de_visita, ArrayList<Parque> parques, CyclicBarrier b) {
		this.nome = nome;
		this.tempo_de_visita = tempo_de_visita;
		this.parques = parques;
		this.b = b;
	}

	public void run() {
		int i = 0;
		while(i<5) {
			this.visitar(this.parques.get(i));
			i++;
		}
	}

	void visitar(Parque parque) {
		try {
			System.out.println(this.nome + " chegando no " + parque.nome);
			sleep(this.tempo_de_visita);
			System.out.println(this.nome + " Terminou a visita");
			b.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
