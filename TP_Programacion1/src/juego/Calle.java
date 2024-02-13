package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Calle {
	private double x;
	private double y;
	private int ancho;
	private double alto;
	private double velocidad;
	private double angulo;
	private Carril[] carriles;
	private double[][] matXCoches;
	private Image calleImg;
	
	Calle(double y, int numCarriles){
		x = 400;
		this.y = y;
		ancho = 800;
		alto = 40*numCarriles;
		velocidad = 0.5;
		calleImg = Herramientas.cargarImagen("calle"+numCarriles+"carriles.png");
		carriles = new Carril[numCarriles];
		crearCarriles();
	}
	
	void dibujar(Entorno entorno) {
		entorno.dibujarImagen(calleImg, x, y, angulo);
		for(Carril carril : carriles) {
			carril.dibujarCoches(entorno);
		}
		caer();
	}
	
	void caer(){
		setY(y + velocidad);
	}
	
	void crearCarriles() {
		int cont;
		if(carriles.length == 4) {
			matXCoches = new double[][] {{ 175, 600, 750}
										,{125, 325, 455}
										,{150, 375, 500}
										,{ 25, 175, 550}};
			cont = -60;
		}else {
			matXCoches = new double[][] {{ 50, 300, 450} 
										,{50, 550, 675}
										,{100, 350, 600}
							            ,{ 50, 200, 500}
							            ,{150, 600, 725}
							            ,{ 75, 490, 610}};
			cont = -100;
		}
		for(int i = 0; i < carriles.length; i++) {
			char direccion = (i%2 == 0) ? 'i' : 'd';
			carriles[i] = new Carril(y+cont, direccion, matXCoches[i]);
			cont += 40;
		}
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
		//ACTUALIZAR Y DE CARRILES
		int cont;
		if(carriles.length == 4) {
			cont = -60;
		}else {
			cont = -100;
		}
		for(Carril carril : carriles) {
			carril.setY(y+cont);
			cont += 40;
		}
	}

	public double getAlto() {
		return alto;
	}

	public Carril[] getCarriles() {
		return carriles;
	}

	public void setCarriles(Carril[] carriles) {
		this.carriles = carriles;
	}
}