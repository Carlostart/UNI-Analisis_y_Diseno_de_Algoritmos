import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO: Jose Carlos Jiménez
// GRUPO: A
////////////////////////////////////////////////////////////////////////////////////////////

public class OrdenacionRapidaBarajada extends OrdenacionRapida {

	// Implementaci�n de QuickSort con reordenaci�n aleatoria inicial (para comparar
	// tiempos experimentalmente)
	public static <T extends Comparable<? super T>> void ordenar(T v[]) {
		// A completar por el alumno
		barajar(v);
		ordRapidaRec(v, 0, v.length - 1);
	}

	// reordena aleatoriamente los datos de un vector
	private static <T> void barajar(T v[]) {
		// A completar or el alumno
		Random rnd = ThreadLocalRandom.current();
		for (int i = v.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			intercambiar(v, i, index);
		}
	}

}
