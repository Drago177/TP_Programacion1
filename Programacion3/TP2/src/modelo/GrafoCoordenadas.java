package modelo;

import java.util.List;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import grafos.Grafo;

public class GrafoCoordenadas {
	private static List<Coordinate> coordenadas;
	private static Grafo grafo;

	public static Grafo getGrafoCoordenadas(List<Coordinate> coorden) {
		coordenadas = coorden;
		crearGrafo();
		return grafo;
	}
	
	private static void crearGrafo() {
		grafo = new Grafo(coordenadas.size());
		agregarAristas(grafo);
	}

	private static void agregarAristas(Grafo grafo) {
		for(int i = 0; i < coordenadas.size(); i++) {
			for(int j = i+1; j < coordenadas.size(); j++) {
				double peso = calcularPeso(coordenadas.get(i), coordenadas.get(j));
				grafo.agregarArco(i, j, peso);
			}
		}
	}

	private static double calcularPeso(Coordinate coordenada, Coordinate coordenada2) {
		return DistanciaCoordenadasKm.calcular(coordenada, coordenada2);
	}

}
