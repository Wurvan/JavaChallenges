package Challenge7;

import java.util.Scanner;

/*
 * Reto #7: El sombrero seleccionador
 * 
 * Crea un programa que simule el comportamiento del sombrero seleccionador del
 * universo mágico de Harry Potter.
 * - De ser posible realizará 5 preguntas (como mínimo) a través de la terminal.
 * - Cada pregunta tendrá 4 respuestas posibles (también a selecciona una a través de terminal).
 * - En función de las respuestas a las 5 preguntas deberás diseñar un algoritmo que
 *   coloque al alumno en una de las 4 casas de Hogwarts (Gryffindor, Slytherin , Hufflepuff y Ravenclaw)
 * - Ten en cuenta los rasgos de cada casa para hacer las preguntas y crear el algoritmo seleccionador.
 *   Por ejemplo, en Slytherin se premia la ambición y la astucia.
 */

public class SortingHat {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			String name = "";
			String[] answers = new String[5];
			System.out.println(
					"Bienvenido a la escuela de magia de Hogwarts alumno,\npara empezar podrias decirnos vuestro nombre?: ");
			name = scanner.nextLine();
			System.out.println("\n\nAsí que nuestro nuevo mago se llama " + name.toUpperCase()
					+ ".\nFascinante! Ahora vamos a proceder a escoger una casa para ti,"
					+ " pero para ello deberas de responder las 5 siguientes preguntas." + "\nEstas preparado?"
					+ "\nEmpecemos!");

			// "acad", "cbca", "dadb", "bdbc"

			System.out.println("1. ¿Cúal de los siguientes te gustaría estudiar mas?");
			System.out.println("    a. Centauro");
			System.out.println("    b. Vampiro");
			System.out.println("    c. Duendes");
			System.out.println("    d. Sirenas");
			answers[0] = scanner.nextLine();

			System.out.println("2. ¿Cuál de las siguientes opciones le resulta más difícil de manejar?");
			System.out.println("    a. Ser ignorado");
			System.out.println("    b. Aburrimiento");
			System.out.println("    c. Soledad");
			System.out.println("    d. Hambre");
			answers[1] = scanner.nextLine();

			System.out.println("3. Si pudieras tener algún poder, ¿cuál elegirías?");
			System.out.println("    a. El poder de la invisibilidad");
			System.out.println("    b. El poder de cambiar tu apariencia a voluntad");
			System.out.println("    c. El poder de leer la mente");
			System.out.println("    d. El poder de cambiar el pasado");
			answers[2] = scanner.nextLine();

			System.out.println("4. ¿Qué tipo de instrumento agrada mas a tu oído?");
			System.out.println("    a. Tambores");
			System.out.println("    b. Violin");
			System.out.println("    c. Trompeta");
			System.out.println("    d. Piano");
			answers[3] = scanner.nextLine();

			System.out.println("5. ¿Cómo le gustaría ser conocido en la historia?");
			System.out.println("    a. El gran");
			System.out.println("    b. El bueno");
			System.out.println("    c. El sabio");
			System.out.println("    d. El audaz");
			answers[4] = scanner.nextLine();

			determineHouse(answers);
		}
	}

	public static void determineHouse(String[] answers) {
		String[] houseChoice = { "acadb", "cbcaa", "dadbd", "bdbcc" };
		String[] houses = { "Griffindor", "Slytherin", "Ravenclow", "Hufflepuff" };

		for (int i = 0; i < houseChoice.length; i++) {
			int matchCount = 0;
			char[] houseChars = houseChoice[i].toCharArray();

			for (int j = 0; j < houseChars.length; j++) {
				if (houseChars[j] == answers[j].charAt(0)) {
					matchCount++;
				}
			}
			if (matchCount >= 3) {
				System.out.println("\n\nTu casa es: " + houses[i]);
				return;
			}
		}
		System.out.println("No puedo determinar tu casa con las respuestas dadas.");
	}

}
