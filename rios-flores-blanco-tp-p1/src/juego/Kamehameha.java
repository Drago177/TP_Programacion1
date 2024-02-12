package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Kamehameha {
	private double x;
	private double y;
	private double alto;
	private double ancho;
	private Image kamehameha;
	
	Kamehameha(double x, double y) {
		this.x = x;
		this.y = y;
		alto = 55;
		ancho = 20;
		kamehameha = Herramientas.cargarImagen("kamehameha.png");
	}
	
	void dibujar(Entorno entorno) {
		entorno.dibujarImagen(kamehameha, x, y, 0, 0.05);
		desplazar();
	}
	
	void desplazar() {
		setY(y - 2);
	}
	
    boolean colisiona(Coche coche) {
        double ancho = this.ancho;
        double alto = this.alto;
        double ancho2 = coche.getAncho();
        double alto2 = coche.getAlto();
        double x = this.x-(this.ancho/2);
        double y = this.y-(this.alto/2);
        double x2 = coche.getX()-(coche.getAncho()/2);
        double y2 = coche.getY()-(coche.getAlto()/2);
        ancho2 += x2;
        alto2 += y2;
        ancho += x;
        alto += y;
        return ((ancho2 < x2 || ancho2 > x) &&
                (alto2 < y2 || alto2 > y) &&
                (ancho < x || ancho > x2) &&
                (alto < y || alto > y2));
    }
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		if(y >= this.y-alto/2) {
			this.y = y;
		}
	}
	
	public double getAlto() {
		return alto;
	}
	
	public double getAncho() {
		return ancho;
	}
}