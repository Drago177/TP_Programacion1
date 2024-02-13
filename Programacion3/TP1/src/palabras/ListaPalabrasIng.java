package palabras;

import java.util.ArrayList;
import java.util.List;

public class ListaPalabrasIng extends ListaPalabras{
	
	public ListaPalabrasIng() {
		super();
		super.setPalabras(agregarPalabras());
		super.inicializarPalabra();
	}
	
	public ListaPalabrasIng(int semilla) {
		super();
		super.setPalabras(agregarPalabras());
		super.inicializarPalabra(semilla);
	}
	
	@Override
	public List<String> agregarPalabras() {
		List<String> words = new ArrayList<>();
		words.add("DRINK");
		words.add("GREEN");
		words.add("TEETH");
		words.add("SMALL");
		words.add("COACH");
		words.add("ARROW");
		words.add("BEACH");
		words.add("BEGIN");
		words.add("CLOUD");
		words.add("HORSE");
		words.add("KNEES");
		words.add("KNIFE");
		return words;
	}
	
}
