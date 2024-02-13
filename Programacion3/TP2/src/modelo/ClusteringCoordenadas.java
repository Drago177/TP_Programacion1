package modelo;

import java.util.List;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import agm.ArbolGeneradorMinimo;
import controlador.Coordinador;
import grafos.Grafo;


public class ClusteringCoordenadas {
	private List<Coordinate> coordenadas;
	private Clustering clust;
	private ArbolGeneradorMinimo agm;
	private Coordinador miCoordinador;
	
	public ClusteringCoordenadas(List<Coordinate> coordenadas) {
		this.coordenadas = coordenadas;
		agm = new ArbolGeneradorMinimo(crearGrafoCoordenadas());
	}
	
	public Grafo crearClusteringCoordenadas(int cantClusters) {
		clust = new Clustering(agm);
		return clust.getClusters(cantClusters);
	}

	private Grafo crearGrafoCoordenadas() {
		return GrafoCoordenadas.getGrafoCoordenadas(coordenadas);
	}
	
	public Grafo getAgm() {
		return agm.construirAGM();
	}
	
	public void setCoordinador(Coordinador miCoordinador2) {
		this.miCoordinador= miCoordinador2;
	}

}
