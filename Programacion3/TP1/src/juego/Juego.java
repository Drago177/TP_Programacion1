package juego;

import java.util.ArrayList;
import java.util.List;
import palabras.ListaPalabrasEsp;
import palabras.ListaPalabrasIng;
import palabras.ListaPalabras;

public class Juego {
	
	private ListaPalabras listPalabras;
	private String palabraSecreta;
	private ComparadorPalabra comp;
	private List<String> idiomas;
	private String idiomaActual;
	
	public Juego() {
		cargarIdiomas();
		idiomaActual = idiomas.get(0);
		listPalabras = new ListaPalabrasEsp();
		palabraSecreta = listPalabras.getPalabra();
		comp = new ComparadorPalabra();
	}

	public Juego(int semilla) {
		cargarIdiomas();
		idiomaActual = idiomas.get(0);
		listPalabras = new ListaPalabrasEsp(0);
		palabraSecreta = listPalabras.getPalabra();
		comp = new ComparadorPalabra();
	}
	
	public List<Estado> compararPalabra(String palabraUsuario) throws IllegalArgumentException{
		if(palabraUsuario.length() != palabraSecreta.length())
			throw new IllegalArgumentException("La palabra no tiene la cantidad de letras correcta");
		if(!listPalabras.pertenece(palabraUsuario))
			palabraInvalida();
		return comp.comparar(palabraSecreta, palabraUsuario);
	}
	
	public void cambiarIdioma(String idioma) {
		if(!idiomas.contains(idioma))
			throw new IllegalArgumentException("El idioma no está disponible");
		if(idioma.equals(idiomas.get(1))) {
			this.idiomaActual = idioma;
			listPalabras = new ListaPalabrasIng();
			palabraSecreta = listPalabras.getPalabra();
		}

		else if(idioma.equals(idiomas.get(0))) {
			this.idiomaActual = idioma;
			listPalabras = new ListaPalabrasEsp();
			palabraSecreta = listPalabras.getPalabra();
		}
		
	}
	
	
	private void cargarIdiomas() {
		idiomas = new ArrayList<>();
		idiomas.add("Español");
		idiomas.add("Inglés");
	}

	private void palabraInvalida() {
		throw new IllegalArgumentException("La palabra no está en la lista");
	}

	public String getPalabraSecreta() {
		return palabraSecreta;
	}

	
}
