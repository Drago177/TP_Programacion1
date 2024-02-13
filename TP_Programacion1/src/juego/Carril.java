package juego;

import entorno.Entorno;

public class Carril {
	//Variables de Instancia
	private double x;
	private double y;
	private char direccion;
	private double velocidad;
	private Coche[] coches;
	
	//Constructor
	Carril(double y, char direccion, double[] xCoches) {
		x = 400;
		this.y = y;
		this.direccion = direccion;
		setVelocidad();
		crearCoches(xCoches); 
	}
	
	void dibujarCoches(Entorno entorno) {
		for(Coche coche : coches) {
			if(coche != null) {
				coche.dibujarse(entorno);
			}
		}
	}
	
	void crearCoches(double[] xCoches) {
		coches = new Coche[xCoches.length];
		for(int i = 0; i < coches.length; i++) {
			coches[i] = new Coche(xCoches[i], y, velocidad, direccion);
		}
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
		for(Coche coche: coches) {
			if(coche != null) {
				coche.setY(y);
			}
		}
	}
	
	public char getDireccion() {
		return direccion;
	}
	
	public void setDireccion(char direccion) {
		this.direccion = direccion;
	}
	
	public double getVelocidad() {
		return velocidad;
	}
	
	public void setVelocidad() {
		velocidad = (direccion == 'i') ?  2 : 1;
	}

	public Coche[] getCoches() {
		return coches;
	}
	public void setCoches(Coche[] coches) {
		this.coches = coches;
	}
}
