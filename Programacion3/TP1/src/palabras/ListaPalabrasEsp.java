package palabras;

import java.util.ArrayList;
import java.util.List;

public class ListaPalabrasEsp extends ListaPalabras{

	public ListaPalabrasEsp() {
		super();
		super.setPalabras(agregarPalabras());
		super.inicializarPalabra();
	}
	
	public ListaPalabrasEsp(int semilla) {
		super();
		super.setPalabras(agregarPalabras());
		super.inicializarPalabra(semilla);
	}

	@Override
	public List<String> agregarPalabras() {
		List<String> palabras = new ArrayList<>();
		palabras.add("LLAMO");
		palabras.add("LLAMA");
		palabras.add("BARCO");
		palabras.add("BEBER");
		palabras.add("CAMPO");
		palabras.add("CEJAS");
		palabras.add("PERRO");
		palabras.add("ROMBO");
		palabras.add("CULTO");
		palabras.add("PERLA");
		palabras.add("DATOS");
		palabras.add("LETRA");
		return palabras;
	}
}
