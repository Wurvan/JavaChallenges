package Challenge1;

/*
 * Reto #0: EL FAMOSO "FIZZ BUZZ"
 * 
 *
 * Escribe un programa que muestre por consola (con un print) los
 * números de 1 a 100 (ambos incluidos y con un salto de línea entre
 * cada impresión), sustituyendo los siguientes:
 * - Múltiplos de 3 por la palabra "fizz".
 * - Múltiplos de 5 por la palabra "buzz".
 * - Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".
 */

public class FizzFuzz {

	public static void main(String[] args) {
		int multiply3 = 3;
		int multiply5 = 5;
		for (int i = 1; i <= 100; i++) {
			if (i % multiply3 == 0 && i % multiply5 == 0) {
				System.out.println("fizzbuzz");
			} else if (i % multiply3 == 0) {
				System.out.println("fizz");
			} else if (i % multiply5 == 0) {
				System.out.println("buzz");
			} else {
				System.out.println(i);

			}
		}
	}
}
