package juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComparadorPalabra {
	private List<Estado> result;
	
	public ComparadorPalabra() {
		inicializarResultado();
	}

	public List<Estado> comparar(String palabra, String palabraUsuario) {
		palabra =  palabra.toUpperCase();
		palabraUsuario = palabraUsuario.toUpperCase();
		if(palabra.equals(palabraUsuario))
			for(int i = 0; i < palabra.length(); i++)
				actualizarResultado(i, Estado.CORRECTA);
		
		else {
			StringBuilder palabraUsuarioAux = new StringBuilder(palabraUsuario);
			StringBuilder palabraAux = new StringBuilder(palabra);
			letrasCorrectas(palabraUsuarioAux, palabraAux);
			letrasExistentes(palabraUsuarioAux, palabraAux);
		}
		
		return result;
	}
	
	private void letrasCorrectas(StringBuilder palabraUsuario, StringBuilder palabraSecreta) {
		for(int i = 0; i < palabraSecreta.length(); i++)
			if(palabraUsuario.charAt(i) == palabraSecreta.charAt(i)) {
				descartarLetra(palabraSecreta, i);
				descartarLetra(palabraUsuario, i);
				actualizarResultado(i, Estado.CORRECTA);
			}
	}
	
	private void letrasExistentes(StringBuilder palabraUsuario, StringBuilder palabraSecreta) {
		for(int i = 0; i < palabraUsuario.length(); i++) {
			int indiceLetra = palabraSecreta.indexOf(""+palabraUsuario.charAt(i));
			if(palabraUsuario.charAt(i) != ' ') {
				if(indiceLetra >= 0) {
					actualizarResultado(i, Estado.EN_OTRA_POSICION);
					descartarLetra(palabraSecreta, indiceLetra);
				}else
					actualizarResultado(i, Estado.INCORRECTA);
			}
		}
	}
	
	private void inicializarResultado() {
		result = new ArrayList<>();
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
	}
	
	private void actualizarResultado(int i, Estado estado) {
		result.set(i, estado);
	}
	
	private void descartarLetra(StringBuilder palabra, int i) {
		palabra.setCharAt(i, ' ');
	}
	
}
