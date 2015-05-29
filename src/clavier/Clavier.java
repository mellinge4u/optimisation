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

	public Clavier(int[] lettres) {
		this.lettres = lettres;
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

	public void setTouche(int lettre, int touche) {
		lettres[lettre] = touche;
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

	public int getLettre(int touche) {
		boolean utilisee = false;
		int lettre = -1;
		for (int i = 0; i < lettres.length && !utilisee; i++) {
			if (lettres[i] == touche) {
				lettre = i;
				utilisee = true;
			}
		}
		return lettre;
	}
	
	public int[] getTab() {
		return lettres;
	}
	
	public Clavier croisement(Clavier i) {
		return null;
	}

	public Clavier mutation() {
		Clavier newClavier = new Clavier(lettres.clone());
		Random r = new Random();
		int lettre = r.nextInt(26);
		int touche2 = r.nextInt(40);
		int lettre2 = getLettre(touche2);
		if (lettre2 == -1) {	// la touche prise al�atoirement n'a pas de lettre assign�e
			setTouche(lettre, touche2);
		} else {
			int touche = getTouche(lettre);
			setTouche(lettre, touche2);
			setTouche(lettre2, touche);
		}
		return newClavier;
	}

	@Override
	public boolean equals(Object obj) {
		Clavier clavier = (Clavier) obj;
		boolean equals = true;
		for (int i = 0; i < lettres.length && equals; i++) {
			if (clavier.getTouche(i) != this.getTouche(i)) {
				equals = false;
			}
		}
		return equals;
	}


}
