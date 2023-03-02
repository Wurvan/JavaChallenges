package Challenge5;

import java.util.Scanner;

/*
 * Reto #4: PRIMO, FIBONACCI Y PAR
 * 
 * Escribe un programa que, dado un número, compruebe y muestre si es primo, fibonacci y par.
 * Ejemplos:
 * - Con el número 2, nos dirá: "2 es primo, fibonacci y es par"
 * - Con el número 7, nos dirá: "7 es primo, no es fibonacci y es impar"
 */

public class Main {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String sentence = "";
			int input;

			System.out.print("Enter a Number: ");
			input = scanner.nextInt();
			sentence += input;

			sentence += isPrime(input) ? " es primo," : " no es primo,";
			sentence += isFibonacci(input) ? " fibonacci" : " no es fibonacci";
			sentence += isEven(input) ? " y es par" : " y es impar";
			System.out.println(sentence);
		}

	}

	public static boolean isPrime(int number) {
		boolean prime = true;
		if (number == 0 || number == 1 || number == 4) {
			prime = false;
		}
		for (int x = 2; x < number / 2; x++) {
			if (number % x == 0) {
				prime = false;
			}
		}
		return prime;
	}

	public static boolean isFibonacci(int n) {
		return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
	}

	public static boolean isPerfectSquare(int number) {
		int s = (int) Math.sqrt(number);
		return (s * s == number);
	}

	public static boolean isEven(int number) {
		boolean even;
		if (number % 2 == 0)
			even = true;
		else
			even = false;
		return even;
	}

}
