//André Teixeira

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

public class Main {

	public static void main(String[] args) {
		String[] nome_parques = {"Parque A", "Parque B", "Parque C", "Parque D", "Parque E"};
		String[] nome_turmas = {"Turma 1", "Turma 2", "Turma 3"};
		int[] tempo_turma = {2000, 4000, 6000};
		
		CyclicBarrier barreira = new CyclicBarrier(nome_turmas.length);

		ArrayList<Parque> parques = new ArrayList<Parque>();
		for(int i=0; i<nome_parques.length;i++) {
			parques.add(new Parque(nome_parques[i]));			
		}
		
		for (int i = 0; i < nome_turmas.length; i++) {
			new Turma(nome_turmas[i], tempo_turma[i], parques, barreira).start();			
		}
	}
}
