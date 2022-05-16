package me.timo;

public class Sortieren {

	private int[] feld;
	private int z, v, t;

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}

	public int[] getFeld() {
		return feld;
	}

	public void setFeld(int[] feld) {
		this.feld = feld;
	}

	public Sortieren(int[] feld) {
		this.feld = feld;
	}

	public void bubbleSort() {
		for (int i = 1; i < feld.length-1; i++) {
			z++;
			for (int j = 1; j < feld.length-i; j++) {
				z++;
				v++;
				if(feld[j] > feld[j+1]) {
					t++;
					int help = feld[j];
					feld[j] = feld[j+1];
					feld[j+1] = help;
				}
			}
		}
	}

	public void straightSelection() {
		for (int kopf = 1; kopf < feld.length-1; kopf++) {
			z++;
			int min = kopf;
			z++;
			int minwert = feld[min];
			z++;
			for (int i = kopf+1; i < feld.length; i++) {
				z++;
				v++;
				if(minwert > feld[i]) {
					min = i;
					z++;
					minwert = feld[min];
					z++;
				}
			}
			int help = feld[kopf];
			feld[kopf] = feld[min];
			feld[min] = help;
			t++;
		}
	}

	public void straightInsertion() {
		for (int kopf = 2; kopf < feld.length; kopf++) {
			z++;
			int stelle = kopf;
			z++;
			int lauf = stelle;
			z++;
			do {
				v++;
				lauf = lauf - 1;
				z++;
				v++;
				if (feld[stelle] < feld[lauf]) {
					int help = feld[stelle];
					feld[stelle] = feld[lauf];
					feld[lauf] = help;
					t++;
					stelle = stelle - 1;
					z++;
				}
			} while (!(stelle - lauf == 1 || lauf == 1));
		}
	}

	public void quickSort(int links, int rechts) {
		v++;
		if(rechts > links) {
			z++;
			int p = feld[(rechts + links) / 2];
			z++;
			int l = links;
			z++;
			int r = rechts;
			do {
				v++;

				v++;
				while (feld[l] < p) {
					v++;

					z++;
					l++;
				}
				v++;
				while (feld[r] > p) {
					v++;

					z++;
					r--;
				}
				v++;
				if(l <= r) {

					t++;
					int help = feld[l];
					feld[l] = feld[r];
					feld[r] = help;
					z++;
					l++;
					z++;
					r--;
				}
			} while (!(l > r));
			quickSort(links, r);
			quickSort(l, rechts);
		}
	}

	public void gnomSort() {
		int i = 1;
		z++;
		v++;
		while (i < feld.length-1) {
			v++;
			v++;
			if(feld[i] > feld[i + 1]) {
				t++;
				int hilfe = feld[i];
				feld[i] = feld[i+1];
				feld[i+1] = hilfe;
				z++;
				i--;
				v++;
				if(i == 0) {
					i = 1;
					z++;
				}
			} else {
				i++;
				z++;
			}
		}
	}

	public void shakerSort() {
		z++;
		boolean aenderung = true;
		z++;
		boolean hin = true;

		v++;
		while (aenderung) {
			v++;

			z++;
			aenderung = false;

			v++;
			if(hin) {
				z++;
				hin = false;
				for (int i = 1; i < feld.length-1; i++) {
					z++;

					v++;
					if(feld[i + 1] < feld[i]) {
						t++;
						int hilf = feld[i];
						feld[i] = feld[i+1];
						feld[i+1] = hilf;
						z++;
						aenderung = true;
					}
				}
			} else {
				z++;
				hin = true;
				for (int i = feld.length-1; i >= 2; i--) {
					z++;
					v++;
					if(feld[i] < feld[i-1]) {
						t++;
						int hilf = feld[i];
						feld[i] = feld[i-1];
						feld[i-1] = hilf;
						z++;
						aenderung = true;
					}
				}
			}
		}
	}

}