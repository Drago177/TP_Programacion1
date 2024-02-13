package modelo;

import java.util.HashSet;
import java.util.Set;

public class Album {
	private int _cantFiguritas;
	private Set<Integer> figuritasPegadas;
	
	public Album(int cantFiguritas) {
		_cantFiguritas = cantFiguritas;
		figuritasPegadas = new HashSet<>();
	}
	
	public boolean agregarFigurita(Integer figurita) {
		return figuritasPegadas.add(figurita);
	}

	public boolean completado() {
		return figuritasPegadas.size() == _cantFiguritas;
	}
	
	public boolean figuritaPegada(Integer figurita) {
		return figuritasPegadas.contains(figurita);
	}

	@Override
	public String toString() {
		return "Album [figuritasPegadas=" + figuritasPegadas + "]";
	}
	
}
