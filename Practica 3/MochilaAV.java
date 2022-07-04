import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author ***** Indicar aqui el autor de la practica *******
 *
 */
public class MochilaAV extends Mochila {

	static class Ordenador implements Comparable<Ordenador> {
		int peso, valor, indice;
		double densidad;

		public Ordenador(int peso, int valor, int ind) {
			this.peso = peso;
			this.valor = valor;
			this.indice = ind;
			densidad = (double) this.valor / (double) this.peso;
		}

		public int compareTo(Ordenador ord) {
			if (indice == ord.indice) {
				return 0;
			} else if (densidad < ord.densidad) {
				return 1;
			} else if (densidad == ord.densidad) {
				if (valor < ord.valor)
					return 1;
				else
					return -1;
			} else {
				return -1;
			}
		}

	}

	public SolucionMochila resolver(ProblemaMochila pm) {
		SolucionMochila sm = null;
		// Completar la implementacion
		int[] pesos = pm.getPesos();
		int[] valores = pm.getValores();
		int W = pm.getPesoMaximo();
		int n = pesos.length;
		Ordenador[] ord = new Ordenador[n];
		int[] sol = new int[n];
		for (int i = 0; i < n; i++) {
			sol[i] = 0;
		}
		for (int i = 0; i < n; i++) {
			ord[i] = new Ordenador(pesos[i], valores[i], i);
		}

		Arrays.sort(ord);

		int peso = 0;
		int valor = 0;
		int i = 0;
		while (i < n && peso < W) {
			if (ord[i].peso <= W - peso) {
				sol[ord[i].indice] = 1;
				peso += ord[i].peso;
				valor += ord[i].valor;
			}
			i++;
		}
		ArrayList<Integer> aux = new ArrayList<Integer>();
		aux = ArrayUtils.toArray(sol);
		sm = new SolucionMochila(aux, peso, valor);
		return sm;
	}

}
