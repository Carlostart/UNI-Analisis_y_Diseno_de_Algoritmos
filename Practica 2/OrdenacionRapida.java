////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO:
// GRUPO:
////////////////////////////////////////////////////////////////////////////////////////////

public class OrdenacionRapida extends Ordenacion {

	public static <T extends Comparable<? super T>> void ordenar(T v[]) {
		ordRapidaRec(v, 0, v.length - 1);
	}

	// Debe ordenar ascendentemente los primeros @n elementos del vector @v con
	// una implementaci�n recursiva del m�todo de ordenaci�n r�pida.
	public static <T extends Comparable<? super T>> void ordRapidaRec(T v[], int izq, int der) {
		// A completar por el alumno
		if (izq < der) {
			int partitionIndex = partir(v, v[der], izq, der);

			ordRapidaRec(v, izq, partitionIndex - 1);
			ordRapidaRec(v, partitionIndex + 1, der);
		}
	}

	public static <T extends Comparable<? super T>> int partir(T v[], T pivote, int izq, int der) {
		// A completar por el alumno
		int i = (izq - 1);

		for (int j = izq; j < der; j++) {
			if (v[j].compareTo(pivote) <= 0) {
				i++;

				intercambiar(v, i, j);
			}
		}

		intercambiar(v, i + 1, der);

		return i + 1;
	}

	// Peque�os ejemplos para pruebas iniciales.
	public static void main(String args[]) {

		// Un vector de enteros
		Integer vEnt[] = { 3, 8, 6, 5, 2, 9, 1, 1, 4 };
		ordenar(vEnt);
		System.out.println(vectorAString(vEnt));

		// Un vector de caracteres
		Character vCar[] = { 'd', 'c', 'v', 'b' };
		ordenar(vCar);
		System.out.println(vectorAString(vCar));

	}

}
