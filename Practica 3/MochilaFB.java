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
		while (i < Math.pow(2, tam)) {
			binario = Integer.toBinaryString(i);
			while (binario.length() < tam)
				binario = "0" + binario;
			// System.out.println(binario);
			for (int y = 0; y < binario.length(); y++) {
				solaux[y] = Character.getNumericValue(binario.charAt(y));
			}

			int sumaPesosAux = pm.sumaPesos(solaux);
			int sumaValoresAux = pm.sumaValores(solaux);
			// for (int a : solaux)
			// System.out.print(a + ",");
			// System.out.print(" -> ");
			// System.out
			// .println(sumaPesos + " " + sumaPesosAux + " " + sumaValores + " " +
			// sumaValoresAux + " " + binario);
			if ((sumaPesosAux <= pesoMaximo) && (sumaValoresAux > sumaValores)) {
				// System.out.println(pesoMaximo);
				sumaPesos = sumaPesosAux;
				sumaValores = sumaValoresAux;
				sol = solaux.clone();
			}
			i++;
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
