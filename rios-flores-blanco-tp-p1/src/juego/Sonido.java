package juego;

import javax.sound.sampled.Clip;
import entorno.Herramientas;

public class Sonido {
	private static Clip kamehameha,salto,musica;
	
	public static void musicaFondo() {
		musica = Herramientas.cargarSonido("musica-fondo.wav");
		musica.start();
		}
	
	public static void saltar() {
		salto= Herramientas.cargarSonido("salto.wav");
		salto.start();
	}
	
	public static void kamehameha () {
		kamehameha = Herramientas.cargarSonido("kamehameha.wav");
		kamehameha.start();
	}
}
