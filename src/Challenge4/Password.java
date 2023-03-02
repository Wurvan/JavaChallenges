package Challenge4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * Escribe un programa que sea capaz de generar contraseñas de forma aleatoria.
 * Podrás configurar generar contraseñas con los siguientes parámetros:
 * - Longitud: Entre 8 y 16.
 * - Con o sin letras mayúsculas.
 * - Con o sin números.
 * - Con o sin símbolos.
 * (Pudiendo combinar todos estos parámetros entre ellos)
 */

public class Password {

	private static final List<String> upperCaseList = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
			"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
	private static final List<String> numberList = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
	private static final List<String> symbolList = Arrays.asList("!", "@", "?", "(", ")", ";", ".", "$", "/", "%", "=");

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			List<String> chars = new ArrayList<String>();
			int input;
			String upperCase, number, symbol;

			System.out.print("Enter the length of the password (between 8 and 16 characters): ");
			input = scanner.nextInt();

			while (input < 8 || input > 16) {
				System.out.print("Enter the length of the password (between 8 and 16 characters): ");
				input = scanner.nextInt();
			}

			System.out.print("\nInclude Uppercase: (Y/N): ");
			upperCase = scanner.next();
			System.out.print("\nInclude Numbers: (Y/N): ");
			number = scanner.next();
			System.out.print("\nInclude Symbols: (Y/N): ");
			symbol = scanner.next();

			upperCaseList.forEach(x -> chars.add(x));
			if (upperCase.toLowerCase().equals("y"))
				upperCaseList.forEach(x -> chars.add(x.toUpperCase()));
			if (number.toLowerCase().equals("y"))
				numberList.forEach(x -> chars.add(x));
			if (symbol.toLowerCase().equals("y"))
				symbolList.forEach(x -> chars.add(x));

			generatePassword(input, chars);
		}
	}

	public static void generatePassword(int longitud, List<String> characters) {
		String password = "";
		int randomNum;
		for (int i = 0; i < longitud; i++) {
			randomNum = (int) (Math.random() * (characters.size() - 1) + 1);
			password += characters.get(randomNum);
		}

		System.out.println(password);
	}

}
