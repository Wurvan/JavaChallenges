package Challenge2;

import java.util.HashMap;
import java.util.Scanner;

/* Reto #1: EL "LENGUAJE HACKER"
 * 
 * Escribe un programa que reciba un texto y transforme lenguaje natural a
 * "lenguaje hacker" (conocido realmente como "leet" o "1337"). Este lenguaje
 *  se caracteriza por sustituir caracteres alfanuméricos.
 * - Utiliza esta tabla (https://www.gamehouse.com/blog/leet-speak-cheat-sheet/) 
 *   con el alfabeto y los números en "leet".
 *   (Usa la primera opción de cada transformación. Por ejemplo "4" para la "a")
 */
public class HackerLanguage {

	public static HashMap<Character, String> setConvertor() {

		HashMap<Character, String> convertor = new HashMap<Character, String>();
		convertor.put('a', "4");
		convertor.put('b', "|3");
		convertor.put('c', "{");
		convertor.put('d', "|)");
		convertor.put('e', "3");
		convertor.put('f', "|=");
		convertor.put('g', "6");
		convertor.put('h', "(-)");
		convertor.put('i', "1");
		convertor.put('j', ";");
		convertor.put('k', "|<");
		convertor.put('l', "|_");
		convertor.put('m', "[V]");
		convertor.put('n', "/V");
		convertor.put('o', "0");
		convertor.put('p', "|º");
		convertor.put('q', "0_");
		convertor.put('r', "12");
		convertor.put('s', "5");
		convertor.put('t', "+");
		convertor.put('u', "(_)");
		convertor.put('v', "|/");
		convertor.put('w', "\\/");
		convertor.put('x', "}{");
		convertor.put('y', "j");
		convertor.put('z', "2");

		return convertor;

	}

	public static void main(String[] args) {
		String converted;
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.print("Enter a sentence to convert: ");

				String sentence = "";
				sentence = scanner.nextLine().toLowerCase();
				converted = "";
				for (int i = 0; i < sentence.length(); i++) {
					for (Character clave : setConvertor().keySet()) {
						if (clave == sentence.charAt(i)) {
							converted += setConvertor().get(clave);
						}
					}
					if (!setConvertor().containsKey(sentence.charAt(i))) {
						converted += sentence.charAt(i);
					}
				}
				System.out.println(converted);
				if (sentence.equals("")) {
					break;
				}
			} while (true);
		}
	}
}
