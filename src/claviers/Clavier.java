/*
 * Ici les individus sont les différentes configurations des claviers
 */

package claviers;

import java.util.Random;

public class Clavier {

	private static int[] touches = new int[26];

	public Clavier() {
		Random r = new Random();
		for (int i = 0; i < touches.length; i++) {
			touches[i] = r.nextInt(40);
		}
	}

	public Clavier(String clavier) {
		switch (clavier) {
		case "azerty":
			int[] tmpazerty = { 10, 34, 32, 22, 12, 23, 24, 25, 17, 26, 27, 28,
					29, 35, 18, 19, 20, 13, 21, 14, 16, 33, 30, 31, 15, 11 };
			touches = tmpazerty;
			break;
		case "bepo":
			int[] tmpbepo = { 20, 10, 24, 16, 23, 39, 37, 38, 22, 18, 35, 17,
					29, 28, 13, 12, 36, 27, 26, 25, 21, 15, 9, 33, 32, 19 };
			touches = tmpbepo;
			break;
		case "qwerty":
			int[] tmpqwerty = { 20, 34, 32, 22, 12, 23, 24, 25, 17, 26, 27, 28,
					36, 35, 18, 19, 10, 13, 21, 14, 16, 33, 11, 31, 15, 30 };
			touches = tmpqwerty;
			break;
		default:
			Random r = new Random();
			for (int i = 0; i < touches.length; i++) {
				touches[i] = r.nextInt(40);
			}
		}

	}

	public int evaluation() {
		int eval = 0;
		int dist;
		for (int i = 0; i < 26; i++) {
			for (int j = i + 1; j < 26; j++) {
				dist = Math.abs((i%10)-(j%10)) + Math.abs((i/10)-(j/10));
				eval += (FreqBigrammes.getFrequence(i, j) * dist);
			}
		}
		return eval;
	}

	public Clavier croisement(Clavier i) {
		return null;
	}

	public Clavier mutation() {
		return null;
	}

}
