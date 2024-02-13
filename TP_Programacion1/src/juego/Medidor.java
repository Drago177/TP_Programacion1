package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Medidor {
	private int energia;
	private boolean eConsumida;
	private Image medidor;
	
	void dibujar(Entorno entorno){
		if(energia == 0) {
			medidor = Herramientas.cargarImagen("medidor0.png");
		}
		else if(energia == 20) {
			medidor = Herramientas.cargarImagen("medidor1.png");			
		}
		else if(energia == 40) {
			medidor = Herramientas.cargarImagen("medidor2.png");
		}
		else {
			medidor = Herramientas.cargarImagen("medidor3.png");
		}
		entorno.dibujarImagen(medidor, 25, 40, 0, 0.5);
	}
	
	void llenar(int energia) {
		setEnergia(this.energia + energia);
	}
	
	boolean cargado() {
		if(energia == 60) {
			return true;
		}
		return false;
	}
	
	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		if(energia >= 0 && energia <= 60) {
			this.energia = energia;
		}
	}
	public boolean isEConsumida() {
		return eConsumida;
	}
	public void setEConsumida(boolean eConsumida) {
		this.eConsumida = eConsumida;
	}

}
