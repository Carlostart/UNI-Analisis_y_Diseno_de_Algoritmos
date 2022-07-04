import java.util.ArrayList;

/**
 * 
 * @author ***** Indicar aqui el autor de la practica *******
 *
 */
public class MochilaPD extends Mochila {

	private SolucionMochila[][] matriz;

	private SolucionMochila siguiente(ProblemaMochila pm, int it, int pe) {
		if (matriz[it][pe] != null) {
			return matriz[it][pe];
		} else
			return F(pm, it, pe);
	}

	public SolucionMochila F(ProblemaMochila pm, int it, int pe) {
		SolucionMochila aux1 = siguiente(pm, it - 1, pe);
		if (pe >= pm.getPeso(it - 1)) {
			SolucionMochila aux2 = siguiente(pm, it - 1, pe - pm.getPeso(it - 1));
			if (aux1.getSumaValores() < pm.getValor(it - 1) + aux2.getSumaValores()) {
				ArrayList<Integer> aux = (ArrayList<Integer>) aux2.getSolucion().clone();
				aux.set(it - 1, 1);
				matriz[it][pe] = new SolucionMochila(aux, pm.getPeso(it - 1) + aux2.getSumaPesos(),
						pm.getValor(it - 1) + aux2.getSumaValores());
				return matriz[it][pe];
			} else {
				matriz[it][pe] = aux1;
				return aux1;
			}
		} else {
			matriz[it][pe] = aux1;
			return aux1;
		}
	}

	public SolucionMochila resolver(ProblemaMochila pm) {
		SolucionMochila sm = null;
		// Completar la implementacion
		matriz = new SolucionMochila[pm.getItems().size() + 1][pm.getPesoMaximo() + 1];

		for (int it = 1; it <= pm.getItems().size(); it++) {
			matriz[it][0] = new SolucionMochila(new int[pm.getItems().size()], 0, 0);
		}
		for (int pe = 0; pe <= pm.getPesoMaximo(); pe++) {
			matriz[0][pe] = new SolucionMochila(new int[pm.getItems().size()], 0, 0);
		}

		F(pm, pm.getItems().size(), pm.getPesoMaximo());

		sm = matriz[pm.getItems().size()][pm.getPesoMaximo()];
		return sm;
	}

}
