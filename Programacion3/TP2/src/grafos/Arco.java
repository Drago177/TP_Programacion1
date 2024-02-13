package grafos;

import java.util.Objects;

public class Arco implements Comparable<Arco>{
	private int i;
	private int j;
	private double peso;
	
	public Arco(int i, int j, double peso) {
		this.i = i;
		this.j = j;
		this.peso = peso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(i, j);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arco other = (Arco) obj;
		return Objects.equals(i, other.i) && Objects.equals(j, other.j)
				|| Objects.equals(i, other.j) && Objects.equals(j, other.i);
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	public double getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		return "Arco [i=" + i + ", j=" + j + ", peso=" + peso + "]\n";
	}
	
	@Override
	public Arco clone() {
		return new Arco(i, j, peso);
	}

	@Override
	public int compareTo(Arco a) {
		if(peso > a.getPeso())
			return 1;
		if(peso < a.getPeso())
			return -1;
		return 0;
	}
	
}
