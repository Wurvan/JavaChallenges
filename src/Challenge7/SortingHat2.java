package Challenge7;

import java.util.Scanner;

public class SortingHat2 {

	private static final String[] HOUSES = { "Gryffindor", "Slytherin", "Ravenclaw", "Hufflepuff" };
	private static final String[] QUESTIONS = { "¿Cuál de los siguientes te gustaría estudiar más?",
			"¿Cuál de las siguientes opciones le resulta más difícil de manejar?",
			"Si pudieras tener algún poder, ¿cuál elegirías?", "¿Qué tipo de instrumento agrada más a tu oído?",
			"¿Cómo le gustaría ser conocido en la historia?" };
	private static final String[][] ANSWERS = { { "Centauro", "Vampiro", "Duendes", "Sirenas" },
			{ "Ser ignorado", "Aburrimiento", "Soledad", "Hambre" },
			{ "El poder de la invisibilidad", "El poder de cambiar tu apariencia a voluntad",
					"El poder de leer la mente", "El poder de cambiar el pasado" },
			{ "Tambores", "Violín", "Trompeta", "Piano" }, { "El gran", "El bueno", "El sabio", "El audaz" } };
	private static final String[] HOUSE_CHOICES = { "acadb", "cbcaa", "dadbd", "bdbcc" };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("¡Bienvenido a la escuela de magia de Hogwarts! Para empezar, ¿podrías decirnos tu nombre?");
			String name = scanner.nextLine();
			System.out.printf(
					"\nAsí que nuestro nuevo mago se llama %s. Fascinante! Ahora vamos a proceder a escoger una casa para ti, pero para ello deberás responder las siguientes preguntas. ¿Estás preparado?\nEmpecemos!\n",
					name.toUpperCase());

			String[] answers = new String[QUESTIONS.length];
			for (int i = 0; i < QUESTIONS.length; i++) {
				System.out.println((i + 1) + ". " + QUESTIONS[i]);
				for (int j = 0; j < ANSWERS[i].length; j++) {
					System.out.printf("    %s. %s\n", (char) ('a' + j), ANSWERS[i][j]);
				}
				String input = scanner.nextLine();
				while (input.length() != 1 || input.charAt(0) < 'a' || input.charAt(0) >= 'a' + ANSWERS[i].length) {
					System.out.println("Respuesta no válida. Por favor, introduce una letra entre 'a' y '"
							+ (char) ('a' + ANSWERS[i].length - 1) + "'.");
					input = scanner.nextLine();
				}
				answers[i] = input;
			}

			String house = determineHouse(answers);
			if (house == null) {
				System.out.println("No puedo determinar tu casa con las respuestas dadas.");
			} else {
				System.out.println("\n\nTu casa es: " + house);
			}
		}
	}

	private static String determineHouse(String[] answers) {
		for (int i = 0; i < HOUSE_CHOICES.length; i++) {
			int matchCount = 0;
			for (int j = 0; j < HOUSE_CHOICES[i].length(); j++) {
				if (HOUSE_CHOICES[i].charAt(j) == answers[j].charAt(0)) {
					matchCount++;
				}
			}
			if (matchCount >= 3) {
				return HOUSES[i];
			}
		}
		return null;
	}

}
