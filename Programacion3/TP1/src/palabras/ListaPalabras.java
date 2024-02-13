package palabras;

import java.util.List;
import java.util.Random;

public abstract class ListaPalabras {
	private String palabra;
	private List<String> palabras;

	protected void inicializarPalabra() {
		int indicePalabra = new Random().nextInt(0, palabras.size());
		palabra = palabras.get(indicePalabra);
	}
	
	protected void inicializarPalabra(int semilla) {
		int indicePalabra = new Random(semilla).nextInt(0, palabras.size());
		palabra = palabras.get(indicePalabra);
	}
	
	protected abstract List<String> agregarPalabras();

	public String getPalabra() {
		return palabra;
	}

	protected void setPalabras(List<String> palabras) {
		this.palabras = palabras;
	}
	
	public boolean pertenece(String palabra) {
		return palabras.contains(palabra);
	}
	
}
