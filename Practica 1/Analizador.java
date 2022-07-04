
public class Analizador {

	/*
	 * NOTA IMPORTANTE
	 * 
	 * Esta clase se proporciona solamente para ilustrar el formato de salida que
	 * deberia tener la solucion a este ejericio. Esta clase debe modificarse
	 * completamente para cumplir mínimamente los requisitos de esta practica.
	 * Notese que ni siquiera esta completa......
	 */

	public static String masCercano(double ratio, int mulcont) {
		double a, b, c, d, e, f, x, y;
		a = b = c = d = e = f = x = y = 0;

		switch (mulcont) {
			case 14:
				a = 0.7;
				x = 2;
				b = 600;
				y = 2000;
				break;
			case 12:
				c = 5;
				break;
			case 7:
				d = 10;
			case 1:
				e = 10;
			case 0:
				f = 1000;
			default:
				break;
		}

		if (ratio <= a) {
			return "1";
		} else if (a <= ratio && ratio < x) {
			return "LOGN";
		} else if (x <= ratio && ratio < b) {
			return "N";
		} else if (b <= ratio && ratio < y) {
			return "NLOGN";
		} else if (b <= ratio && ratio < c) {
			return "N2";
		} else if (c <= ratio && ratio < d) {
			return "N3";
		} else if (ratio > e && ratio < 1000) {
			return "2N";
		} else if (ratio > f) {
			if (mulcont == 14) {
				if (ratio < 5000)
					return "NLOGN";
				else
					return "N";
			} else
				return "NF";
		} else { // otras
			return "";
		}
	}

	public static String ordenesBajos() {
		// Para LOGN
		int n1 = 10;
		int n2 = 200000;
		Temporizador t = new Temporizador();
		long t1 = 0;
		long t2 = 0;
		long ratio = 0;
		t.iniciar();
		Algoritmo.f(n1);
		t.parar();
		t1 = t.tiempoPasado();
		t.reiniciar();
		t.iniciar();
		Algoritmo.f(n2);
		t.parar();
		t2 = t.tiempoPasado();
		double pendiente = (double) t2 / t1;
		t.reiniciar();
		// System.out.println(t1 + " " + t2 + " " + pendiente);

		return masCercano(pendiente, 14);
	}

	public static void main(String arg[]) {
		int n1 = 6;
		int n2 = 2 * n1;
		long t1 = 0;
		long t2 = 0;
		double ratio = 0;
		int multcont = 0;
		Temporizador t = new Temporizador();

		// Para NF¡
		t.iniciar();
		Algoritmo.f(n1);
		t.parar();
		t1 = t.tiempoPasado();
		t.reiniciar();
		t.iniciar();
		Algoritmo.f(n2);
		t.parar();
		t2 = t.tiempoPasado();
		ratio = (double) t2 / t1;
		t.reiniciar();

		// Para el resto
		n1 = 10;
		n2 = 2 * n1;
		while (t2 < Math.pow(10, 9) * .4 && n1 < 100000 && ratio < 10) {
			t.iniciar();
			Algoritmo.f(n1);
			t.parar();
			t1 = t.tiempoPasado();
			t.reiniciar();
			t.iniciar();
			Algoritmo.f(n2);
			t.parar();
			t2 = t.tiempoPasado();
			ratio = (double) t2 / t1;
			multcont++;
			n1 *= 2;
			n2 *= 2;
			t.reiniciar(); //
			// System.out.println(n1 + " " + t1 + " " + t2 + " " + ratio);
		}

		if (multcont == 14) {
			System.out.println(ordenesBajos());
		} else {
			// System.out.println(multcont);
			// System.out.println(masCercano(ratio, multcont) + "->" + ratio);
			System.out.println(masCercano(ratio, multcont));
		}

	}
}