package controlador;

import java.util.ArrayList;
import java.util.List;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import grafos.Grafo;
import modelo.ClusteringCoordenadas;
import vista.Interfaz;

public class Coordinador {

	private Interfaz interfaz;
	private ClusteringCoordenadas clustering;
	private List<Coordinate> coordenadas;
	
	public Coordinador() {
		coordenadas = new ArrayList<>();
	}

	public void agregarCoordenadas(Coordinate c) {
		coordenadas.add(c);
	}
	
	public Grafo crearCluster(int cantClusters) {
		clustering = new ClusteringCoordenadas(coordenadas);
		return clustering.crearClusteringCoordenadas(cantClusters);
	}
	
	public void setInterfaz(Interfaz interfaz) {
		this.interfaz=interfaz;
	}
	
	public void setClustering(ClusteringCoordenadas clustering) {
		this.clustering = clustering;
	}

	
	public Grafo getAgm() {
		clustering = new ClusteringCoordenadas(coordenadas);
		return clustering.getAgm();
	}
	
	public int getTamanioCoordenadas() {
		return coordenadas.size();
	}
	
	public Coordinate getCoordenada(int i) {
		return coordenadas.get(i);
	}
	
	public List<Coordinate> getCoordenadas() {
		return coordenadas;
	}

}