package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Conejo {
	// VARIABLES DE INSTANCIA 
	private double x;
	private double y;
	private double alto;
	private double ancho;
	private boolean llego;
	private Kamehameha kamehameha;
	private Image conejo;

	//CONTRUCTOR 	
	public Conejo () {
		this.x= 400;
		this.y= 520;
		this.ancho=25;
		this.alto=40;
		this.conejo = Herramientas.cargarImagen("conejo.gif");
	}

	void dibujar(Entorno entorno) {
		entorno.dibujarImagen(conejo, this.x, this.y, 0, 0.25);
	}

	void saltar() {
		this.y -= 40;
		if (this.y <= 10) {
			llego = true;
		}
	}

	void desplazarIzquierda() {
		this.x -=30;
		if (this.x <= 30) {
			this.x = 30;
		}
	}

	void desplazarDerecha() {
		this.x +=30;
		if (this.x >= 770) {
			this.x = 770;
		}
	}

	void cae() {
		this.y = this.y + 0.5; 
	}
	
	void disparar(Entorno entorno, Medidor medidor){
		if(this.kamehameha != null) {
			if(kamehameha.getY() <= -150) {
				kamehameha = null;
				medidor.setEConsumida(false);
			}
			else if(medidor.isEConsumida()){
				kamehameha.dibujar(entorno);
			}
		}
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

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getAlto() {
		return alto;
	}
	
	public double getAncho() {
		return ancho;
	}
	
	public boolean getLlego() {
		return llego;
	}
	
	public Kamehameha getKamehameha() {
		return kamehameha;
	}
	
	
	public void setKamehameha(Kamehameha kamehameha) {
		this.kamehameha = kamehameha;
	}
	
}
