package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Coche {
	//Variables de Instancia
	private double x;
	private double y;
	private double ancho;
	private double alto;
	private double velocidad;
	private char direccion;
	
	private Image coche;
	private Image taxi;

	//Constructor
	Coche(double x, double y, double velocidad, char direccion) {
		this.x = x;
		this.y = y;
		ancho = 80;
		alto = 30;
		this.velocidad = 1;
		this.direccion = direccion;
		coche = Herramientas.cargarImagen("Coche.png");
		taxi = Herramientas.cargarImagen("Taxi.png");
	}

	void mover() {
		setX(x + velocidad);
	}
	
	void dibujarse(Entorno entorno) {
		if (direccion == 'd') {
			entorno.dibujarImagen(coche, this.x, this.y, Math.PI, 0.39);
		}
		if (direccion == 'i') {
			entorno.dibujarImagen(taxi, this.x, this.y, 0, 0.37);
			if(velocidad > 0) {
				velocidad *= -1;
			}
		}
		mover();
	}

	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		if(x < -50 && direccion == 'i') {
			this.x = 850;
		}
		else if(x >850 && direccion == 'd') {
			this.x = -50;
		}else {
			this.x = x;
		}
	}

	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	public double getAncho() {
		return ancho;
	}

	public double getAlto() {
		return alto;
	}
}