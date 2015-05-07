/*
 * Ici les individus sont les différentes configurations des claviers
 */

package genetique;

import java.util.Random;

public class Individu {

	private static int[] touches = new int[26];

	public Individu() {
		Random r = new Random();
		for (int i = 0; i < touches.length; i++) {
			touches[i] = r.nextInt(40);
		}
	}

	public Individu(int i) {
		switch (i) {
		case 1:
			int[] tmpazerty = { 10, 34, 32, 22, 12, 23, 24, 25, 17, 26, 27, 28,
					29, 35, 18, 19, 20, 13, 21, 14, 16, 33, 30, 31, 15, 11 };
			touches = tmpazerty;
			break;
		case 2:
			int[] tmpbepo = { 20, 10, 24, 16, 23, 39, 37, 38, 22, 18, 35, 17,
					29, 28, 13, 12, 36, 27, 26, 25, 21, 15, 9, 33, 32, 19 };
			touches = tmpbepo;
			break;
		case 3:
			int[] tmpqwerty = { 20, 34, 32, 22, 12, 23, 24, 25, 17, 26, 27, 28,
					36, 35, 18, 19, 10, 13, 21, 14, 16, 33, 11, 31, 15, 30 };
			touches = tmpqwerty;
			break;
		}

	}

	public int fitness() {
		return 0;
	}

	public void crossOver(Individu i) {

	}

	public void mutation() {

	}

}
