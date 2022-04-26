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
				if(feld[j] > feld[j+1]) {
					v++;
					int help = feld[j];
					feld[j] = feld[j+1];
					feld[j+1] = help;
					t++;
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
				if (feld[stelle] < feld[lauf]) {
					v++;
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
		if(rechts > links) {
			int p = feld[(rechts + links) / 2];
			int l = links;
			int r = rechts;
			do {
				while (feld[l] < p) {
					l++;
				}
				while (feld[r] > p) {
					r--;
				}
				if(l <= r) {
					int help = feld[l];
					feld[l] = feld[r];
					feld[r] = help;
					l++;
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
		boolean aenderung = true;
		boolean hin = true;
		while (aenderung) {
			aenderung = false;
			if(hin) {
				hin = false;
				for (int i = 1; i < feld.length-1; i++) {
					if(feld[i + 1] < feld[i]) {
						int hilf = feld[i];
						feld[i] = feld[i+1];
						feld[i+1] = hilf;
						aenderung = true;
					}
				}
			} else {
				hin = true;
				for (int i = feld.length-1; i >= 2; i--) {
					if(feld[i] < feld[i-1]) {
						int hilf = feld[i];
						feld[i] = feld[i-1];
						feld[i-1] = hilf;
						aenderung = true;
					}
				}
			}
		}
	}

}