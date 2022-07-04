import java.util.Arrays;

/**
 * 
 * @author ***** Indicar aqui el autor de la practica *******
 *
 */
public class MochilaFB extends Mochila {

	public SolucionMochila resolver(ProblemaMochila pm) {
		SolucionMochila sm = null;
		// Completar la implementacion
		int pesoMaximo = pm.getPesoMaximo();
		int tam = pm.size();
		int[] sol = new int[tam];
		Arrays.fill(sol, 0);
		int sumaPesos = 0;
		int sumaValores = 0;
		int[] solaux = new int[tam];
		Arrays.fill(solaux, 0);
		String binario;
		int i = 0;

		for (int j = 0; j < tam; j++) {
			for (int u = 0; u < tam; u++) {

				int sumaPesosAux = pm.sumaPesos(solaux);
				int sumaValoresAux = pm.sumaValores(solaux);

				if ((sumaPesosAux <= pesoMaximo) && (sumaValoresAux > sumaValores)) {
					sumaPesos = sumaPesosAux;
					sumaValores = sumaValoresAux;
					sol = solaux.clone();
				}
				i++;
			}
		}

		// ArrayList<Integer> valores = new ArrayList<>();
		// for (int a : sol) {
		// valores.add(a);
		// }

		// System.out.println(valores);
		sm = new SolucionMochila(sol, sumaPesos, sumaValores);
		return sm;
	}

}
