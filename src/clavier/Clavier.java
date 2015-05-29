/*
 * Ici les individus sont les différentes configurations des claviers
 */

package clavier;

import java.util.Random;

public class Clavier {

	private int[] lettres = new int[26];

	public Clavier() {
		genererClavier();
	}

	public Clavier(String clavier) {
		switch (clavier) {
		case "azerty":
			int[] tmpazerty = { 10, 34, 32, 22, 12, 23, 24, 25, 17, 26, 27, 28,
					29, 35, 18, 19, 20, 13, 21, 14, 16, 33, 30, 31, 15, 11 };
			lettres = tmpazerty;
			break;
		case "bepo":
			int[] tmpbepo = { 20, 10, 24, 16, 23, 39, 37, 38, 22, 18, 35, 17,
					29, 28, 13, 12, 36, 27, 26, 25, 21, 15, 9, 33, 32, 19 };
			lettres = tmpbepo;
			break;
		case "qwerty":
			int[] tmpqwerty = { 20, 34, 32, 22, 12, 23, 24, 25, 17, 26, 27, 28,
					36, 35, 18, 19, 10, 13, 21, 14, 16, 33, 11, 31, 15, 30 };
			lettres = tmpqwerty;
			break;
		default:
			genererClavier();
		}
	}

	public void genererClavier() {
		int[] tmp = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		lettres = tmp;
		Random r = new Random();
		int touche;
		for (int i = 0; i < lettres.length; i++) {
			touche = r.nextInt(40);
			if (isToucheUtilisee(touche)) {
				i--;
			} else {
				lettres[i] = touche;
			}
		}
	}

	public int evaluation() {
		int eval = 0;
		int dist;
		for (int i = 0; i < lettres.length; i++) {
			for (int j = i + 1; j < lettres.length; j++) {
				dist = Math.abs((lettres[i] % 10) - (lettres[j] % 10))
						+ Math.abs((lettres[i] / 10) - (lettres[j] / 10));
				eval += (FreqBigrammes.getFrequence(i, j) * dist);
			}
		}
		return eval;
	}

	public int evaluation(int lettre) {
		int eval = 0;
		int dist;
		for (int i = 0; i < lettres.length; i++) {
			if (!(i == lettre)) {
				dist = Math.abs((lettres[i] % 10) - (lettres[lettre] % 10))
						+ Math.abs((lettres[i] / 10) - (lettres[lettre] / 10));
				eval += (FreqBigrammes.getFrequence(i, lettre) * dist);
			}
		}
		return eval;
	}

	public int evaluationTouche(int touche) {
		int eval = 0;
		for (int i = 0; i < 26; i++) {
			if (lettres[i] == touche) {
				eval = evaluation(i);
			}
		}
		return eval;
	}

	public int getTouche(int lettre) {
		return lettres[lettre];
	}

	public boolean isToucheUtilisee(int touche) {
		boolean utilisee = false;
		for (int i = 0; i < lettres.length && !utilisee; i++) {
			if (lettres[i] == touche) {
				utilisee = true;
			}
		}
		return utilisee;
	}

	public Clavier croisement(Clavier i) {
		return null;
	}

	public Clavier mutation() {
		return null;
	}

}
