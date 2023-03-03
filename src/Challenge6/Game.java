package Challenge6;

import java.util.Scanner;

/*
 * Reto #6: Piedra, Papel, Tijera, Lagarto, Spock
 * 
 * Crea un programa que calcule quien gana más partidas al piedra,
 * papel, tijera, lagarto, spock.
 * - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
 * - La función recibe un listado que contiene pares, representando cada jugada.
 * - El par puede contener combinaciones de "🗿" (piedra), "📄" (papel),
 *   "✂️" (tijera), "🦎" (lagarto) o "🖖" (spock).
 * - Ejemplo. Entrada: [("🗿","✂️"), ("✂️","🗿"), ("📄","✂️")]. Resultado: "Player 2".
 * - Debes buscar información sobre cómo se juega con estas 5 posibilidades.
 */

public class Game {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int option = 0;
		int rolls = 0;

		boolean isOptionSelected = false;
		do {
			System.out.println("======================");
			System.out.println("Select an option:");
			System.out.println("   1. Play the game.");
			System.out.println("   2. Exit");
			System.out.println("======================\n\n");

			System.out.print("Enter your choice: ");
			option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.println(">>>> You selected option 1\n");
				System.out.println("How many rolls will you play?");
				rolls = scanner.nextInt();
				setGame(rolls);
				isOptionSelected = true;
				break;
			case 2:
				System.out.println("Exiting the game...");
				break;
			default:
				System.out.println("Invalid option");
				isOptionSelected = true;
				break;
			}

		} while (!isOptionSelected);
		scanner.close();

	}

	public static void setGame(int rolls) {
		String[] options = { "rock", "paper", "scissors", "lizard", "spock" };
		String[][] saved = new String[rolls][2];
		int dice;

		for (int i = 0; i < rolls; i++) {
			System.out.println("Roll number: " + (i + 1));
			for (int j = 0; j <= 1; j++) {
				dice = (int) (Math.random() * 5);
				if (j == 0)
					System.out.print("[ " + options[dice] + " - ");
				if (j == 1)
					System.out.print(options[dice] + " ] \n");

				saved[i][j] = options[dice];
			}
		}

		playGame(saved);
	}

	private static void playGame(String[][] saved) {
		int player1 = 0;
		int player2 = 0;

		for (int i = 0; i < saved.length; i++) {
			switch (saved[i][0]) {
			case "scissors":
				if (saved[i][1] == "paper" || saved[i][1] == "lizard") {
					player1++;
				} else {
					player2++;
				}
				break;
			case "paper":
				if (saved[i][1] == "rock" || saved[i][1] == "spock") {
					player1++;
				} else {
					player2++;
				}
				break;
			case "rock":
				if (saved[i][1] == "lizard" || saved[i][1] == "scissors") {
					player1++;
				} else {
					player2++;
				}
				break;
			case "lizard":
				if (saved[i][1] == "spock" || saved[i][1] == "paper") {
					player1++;
				} else {
					player2++;
				}
				break;
			case "spock":
				if (saved[i][1] == "scissors" || saved[i][1] == "rock") {
					player1++;
				} else {
					player2++;
				}
				break;
			default:
				System.out.println("Invalid input: " + saved[i][0]);
				break;
			}
		}

		String winner = player1 > player2 ? "Player1 wins the game"
				: player1 < player2 ? "Player2 wins the game" : "Tie game!";
		System.out.println("\n" + winner);
	}

}
