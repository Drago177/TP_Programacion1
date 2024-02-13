package controlador;

import modelo.ClusteringCoordenadas;
import vista.Interfaz;


public class Principal {
	private Coordinador miCoordinador;
	private ClusteringCoordenadas clustering;
	private Interfaz interfaz;
	

	public static void main(String[] args)
	{
		new Principal().iniciar();
	}

	private void iniciar() {
		interfaz= new Interfaz();
		miCoordinador = new Coordinador();
		clustering = new ClusteringCoordenadas(miCoordinador.getCoordenadas());
		
		interfaz.setCoordinador(miCoordinador);
		clustering.setCoordinador(miCoordinador);
		

		miCoordinador.setInterfaz(interfaz);
		miCoordinador.setClustering(clustering);
		
		interfaz.setVisible(true);
		
	}
	
	public void setCoordinador(Coordinador miCoordinador2) {
		this.miCoordinador= miCoordinador2;
	}
}
