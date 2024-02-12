package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;

	// Variables y métodos propios de cada grupo
	private Conejo conejo;
	private Medidor medidor;
	private Calle[] calles;

	private Image fondo;
	private Image inicioImg;
	private Image win;
	private Image gameOverImg;
	private Image pausaImg;
	private Image menuImg;

	private int puntos;
	private int saltos;
	private int tiempo;
	private boolean pausado;
	private boolean inicio;

	Juego()
	{
		// Inicializa el objeto entorno

		entorno = new Entorno(this, "Boss Rabbit Rabber - Grupo 2 rios-flores-blanco", 800, 600);

		// Inicializar lo que haga falta para el juego

		crearObjetos();

		// Inicia el juego!
		entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 * @param  
	 */
	
	public void tick()
	{
		if(gano() != true && perdio() != true && pausado != true && inicio) {  // 
			// Procesamiento de un instante de tiempo

			// Interacciones del conejo
			if (entorno.sePresiono(entorno.TECLA_DERECHA)) {
				conejo.desplazarDerecha();
			}
			else if (entorno.sePresiono(entorno.TECLA_IZQUIERDA)) {
				conejo.desplazarIzquierda();
			}
			else if (entorno.sePresiono(entorno.TECLA_ARRIBA)) {
				Sonido.saltar();
				conejo.saltar();
				saltos+=1;
			}
			
			nuevosCoches();

			//Dibujamos las calles
			for(Calle calle : calles) {
				calle.dibujar(entorno);
				entorno.dibujarImagen(fondo, 400, calle.getY()-calle.getAlto()/2-60, 0);
				entorno.dibujarImagen(fondo, 400, calle.getY()+calle.getAlto()/2+60, 0);
			}
			
			//Dibujamos el fondo del inicio
			if(inicioImg != null) {
				entorno.dibujarImagen(inicioImg, 400, calles[calles.length-1].getY()+calles[2].getAlto()/2+90, 0);
			}

			reaparecerCalles();

			// Poderes
			if(entorno.sePresiono(entorno.TECLA_ARRIBA)) {
				this.medidor.llenar(20);
			}

			
			if(entorno.sePresiono(entorno.TECLA_ESPACIO)) {
				if(medidor.cargado()) {
					Sonido.kamehameha();
					medidor.setEnergia(0);
					medidor.setEConsumida(true);
					conejo.setKamehameha(new Kamehameha(conejo.getX(), conejo.getY()-5));
				}
			}
			
			conejo.dibujar(entorno);
			conejo.disparar(entorno, medidor);
			medidor.dibujar(entorno);
			conejo.cae();
			

			kamehamehaColisionaConCoche();
			dibujarMarcadores();
			pausar();
		}
		
		else if(inicio != true) {
			dibujarMenu();
			if(entorno.sePresiono(entorno.TECLA_ENTER)) {
				iniciar();
			}
		}
		else if(gano()) {
			dibujarWin();
		}
		else if(pausado == true) {
			dibujarPausa();
		}else{
			dibujarGameOver();
		}
	}

	// METODOS PARA EL JUEGO

	void reaparecerCalles() {
		if(calles[calles.length-1].getY()-calles[calles.length-1].getAlto()/2 > 620 ) {	// Si bordeSuperiorUltimacalle > 620
			
			inicioImg = null; //Eliminamos la imagen de inicio
			
			// yUltimaCalle = bordeSuperiorPrimerCalle - altoUltimaCalle/2 - 40*3
			calles[calles.length-1].setY(calles[0].getY()-calles[0].getAlto()/2-calles[calles.length-1].getAlto()/2-40*3);
		}
		for(int i = 0; i < calles.length-1; i++) {
			if(calles[i].getY() - calles[i].getAlto()/2 > 620) {	// Si bordeSuperiorCalles[i] > 620
				
				// yCalle[i] = bordeSuperiorSiguienteCalle - altoCalle[i]/2 - 40*3
				calles[i].setY(calles[i+1].getY()-calles[i+1].getAlto()/2-calles[i].getAlto()/2-40*3);
			}
		}
	}
	
	//METODOS DE COLISIONES
	void kamehamehaColisionaConCoche() {
		//Recorro el arreglo de calles
		for(Calle calle : calles) {
			//Recorro el arreglo de carriles de cada calle
			for(Carril carril : calle.getCarriles()) {
				//Recorro el arreglo de coches de cada carril
				for(int i = 0; i < carril.getCoches().length; i++) {
					if(conejo.getKamehameha() != null && carril.getCoches()[i] != null) {
						Kamehameha kamehameha = conejo.getKamehameha();
						if(kamehameha.colisiona(carril.getCoches()[i])) {
							conejo.setKamehameha(null);
							medidor.setEConsumida(false);
							carril.getCoches()[i] = null;
							puntos += 5;
						}
					}
				}
			}
		}
	}

	boolean conejoColisionaConCoche() {
		for(Calle calle : calles) {
			for(Carril carril : calle.getCarriles()) {
				for(Coche coche : carril.getCoches()) {
					if (coche != null) {
						if(conejo.colisiona(coche)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	//Interacciones de los coches
	
	//Creamos los coches que se volvieron null por el kamehameha
	void nuevosCoches() {
		tiempo++;
		for(Calle calle : calles) {
			for(Carril carril : calle.getCarriles()) {
				for(int i = 0; i < carril.getCoches().length; i++) {
					if(tiempo > 1000 && carril.getCoches()[i] == null) {
						if (carril.getDireccion() == 'd') { 
							carril.getCoches()[i] = new Coche(-140, carril.getY(), carril.getVelocidad(), carril.getDireccion());
						}
						if (carril.getDireccion() == 'i') {
							carril.getCoches()[i] = new Coche(940, carril.getY(), carril.getVelocidad(), carril.getDireccion());
						}
					}
				}
			}
		}
	}
	
	// METODO DE PUNTUACIONES
	void dibujarMarcadores() {
		entorno.cambiarFont(Font.DIALOG, 15, Color.WHITE);
		entorno.escribirTexto("PUNTOS: "+ puntos , 700, 30);
		entorno.escribirTexto("SALTOS: "+ saltos , 700, 50);
	}

	
	//Método para pausar el juego
	void pausar() {
		if(entorno.sePresiono('p')) {
			pausado = !pausado;
			if(pausado != true) {
				pausaImg = null;
			}
		}
	}
	
	
	void dibujarPausa() {
		pausaImg = Herramientas.cargarImagen("pausa.png");
		entorno.dibujarImagen(pausaImg, 400, 300, 0);
		entorno.cambiarFont(Font.DIALOG, 15, Color.YELLOW);
		
		// Despausar el juego
		pausar();
		
		// Volver al menú
		if(entorno.sePresiono('m')) {
			iniciar();	
		}
	}
	

	// METODO GANAR
	boolean gano() {
		if(puntos >= 25 || saltos >= 50 || conejo.getLlego()) {
			return true;
		}
		return false;
	}
	

	void dibujarWin() {
		entorno.dibujarImagen(win, 400, 300, 0, 1.5);
		conejo.dibujar(entorno);
		conejo.setY(200);
		conejo.setX(400);
		entorno.cambiarFont("Times New Roman", 30, Color.WHITE);
		entorno.escribirTexto("Lograste obtener: " + puntos + " puntos.", 150, 500);
		entorno.escribirTexto("O lograste no chocar con ningun auto por: " + saltos + " saltos.", 150, 530);
		entorno.escribirTexto("Presioná ENTER para volver a comenzar.", 150, 560);
		entorno.escribirTexto("Presioná M para volver al Menú.", 150, 590);
		if(entorno.sePresiono('m')) {
			crearObjetos();
			iniciar();
		}else {
			reiniciar();			
		}
	}

	
//	 METODO PERDER
	boolean perdio() {
		if(conejoColisionaConCoche() || conejo.getY() > 600) {
			return true;
		}
		return false;
	}
	
	
	void dibujarGameOver() {
		entorno.dibujarImagen(gameOverImg, 400, 275, 0, 1);
		entorno.cambiarFont("Times New Roman", 30, Color.WHITE);
		entorno.escribirTexto("Tu puntuación fue de " + puntos + " puntos.", 150, 500);
		entorno.escribirTexto("Tu cantidad de saltos fue de " + saltos + " saltos.", 150, 530);
		entorno.escribirTexto("Presioná ENTER para volver a comenzar.", 150, 560);
		entorno.escribirTexto("Presioná M para volver al Menú.", 150, 590);
		if(entorno.sePresiono('m')) {
			crearObjetos();
			iniciar();
		}else {
			reiniciar();
		}
	}
	
	// Método para iniciar el juego
	void iniciar() {
		inicio = !inicio;
		if(pausado) {
			pausado = false;
		}
	}

	// Método para reiniciar el juego desde la pantalla de victoria o game over
	void reiniciar() {
		if(entorno.sePresiono(entorno.TECLA_ENTER)) {
			crearObjetos();
		}
	}

	void dibujarMenu() {
		entorno.dibujarImagen(menuImg, 400, 300, 0);
	}

	void crearObjetos() {
		conejo = new Conejo();
		medidor = new Medidor();
		puntos = 0;
		saltos = 0;
		tiempo = 0;
		
		fondo = Herramientas.cargarImagen("fondo.png");
		inicioImg = Herramientas.cargarImagen("inicio.png");
		win = Herramientas.cargarImagen("win.jpg");
		gameOverImg = Herramientas.cargarImagen("gameOver.png");
		pausaImg = Herramientas.cargarImagen("pausa.png");
		menuImg = Herramientas.cargarImagen("menuImg.png");
		
		calles = new Calle[3];
		calles[0] = new Calle(-260, 4);
		calles[1] = new Calle(60, 6);
		calles[2] = new Calle(380, 4);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
		if (juego != null) {
			Sonido.musicaFondo();
		}
	}
}
