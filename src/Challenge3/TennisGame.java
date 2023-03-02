package Challenge3;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Reto #2: EL PARTIDO DE TENIS
 * 
 * Escribe un programa que muestre cómo transcurre un juego de tenis y quién lo ha ganado.
 * El programa recibirá una secuencia formada por "P1" (Player 1) o "P2" (Player 2), según quien
 * gane cada punto del juego.
 * 
 * - Las puntuaciones de un juego son "Love" (cero), 15, 30, 40, "Deuce" (empate), ventaja.
 * - Ante la secuencia [P1, P1, P2, P2, P1, P2, P1, P1], el programa mostraría lo siguiente:
 *   15 - Love
 *   30 - Love
 *   30 - 15
 *   30 - 30
 *   40 - 30
 *   Deuce
 *   Ventaja P1
 *   Ha ganado el P1
 * - Si quieres, puedes controlar errores en la entrada de datos.   
 * - Consulta las reglas del juego si tienes dudas sobre el sistema de puntos.   
 */

public class TennisGame {

	private static Player P1 = new Player("P1");
	private static Player P2 = new Player("P2");
	private static Player[] players = { P1, P2 };
	private static boolean matchEnd = false;

	public static void main(String[] args) {
		System.out.println("================================");
		System.out.print(
				"Write the sequence of the match. \nUsing P1 as player1 and P2 as player2 \nAnd separate by comma\n-->");
		createSequence();

	}

	public static void createSequence() {
		try (Scanner scanner = new Scanner(System.in)) {
			String input;

			input = scanner.nextLine().toUpperCase();
			String[] sequence = input.split("[,\\s.;-]+");
			ArrayList<Player> finalSeq = new ArrayList<Player>();

			System.out.println("Let's the match starts!");
			System.out.println("================================");
			for (int i = 0; i < sequence.length; i++) {
				if (sequence[i].equals(P1.getName())) {
					finalSeq.add(P1);
				}
				if (sequence[i].equals(P2.getName())) {
					finalSeq.add(P2);
				}
			}
			setPoints(finalSeq);
		}

	}

	public static void setPoints(ArrayList<Player> sequence) {
		for (int i = 0; i < sequence.size(); i++) {
			if (sequence.get(i) == P1) {
				updatePoints(P1);
				getResult();
			} else {
				updatePoints(P2);
				getResult();
			}
		}
	}

	public static Player updatePoints(Player player) {
		if (player.getPoints() == 0) {
			player.setPoints(15);
		} else if (player.getPoints() == 15) {
			player.setPoints(30);
		} else if (player.getPoints() == 30) {
			player.setPoints(40);
		} else if (player.getPoints() == 40) {
			if (!player.isAdvantage()) {
				for (Player playerAdvantage : players) {
					if (!playerAdvantage.getName().equalsIgnoreCase(player.getName())) {
						if (playerAdvantage.isAdvantage()) {
							playerAdvantage.setAdvantage(false);
						} else {
							player.setAdvantage(true);
						}
					}
				}
			} else {
				player.setWinner(true);
				matchEnd = true;
			}
		}
		return player;
	}

	public static void getResult() {
		String message = "";

		if(!matchEnd) {
			if (P1.isAdvantage()) {
				message = "Ventaja";
			} else if (P2.isAdvantage()) {
				message = "Ventaja";
			} else if (P1.getPoints() == P2.getPoints() && P1.getPoints() == 40) {
				message = "Deuce";
			} else {
				// "?" if equals 0 return love, ":" otherwise return p1.getpoints -
				message += P1.getPoints() == 0 ? "love - " : P1.getPoints() + " - ";
				message += P2.getPoints() == 0 ? "love" : P2.getPoints();
			}
		} else {
			if(P1.isWinner()) {
				message = "the player " + P1.getName() + " win the game!!";
			}else {
				message = "the player " + P2.getName() + " win the game!!";
			}
		}
		System.out.print("\n" + message);
	}

}
