package modelo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openstreetmap.gui.jmapviewer.Coordinate;

import grafos.Grafo;
import instancias.LectorCoordenadas;

public class GrafoCoordenadasTest {
	Grafo g;
	List<Coordinate> coordenadas;
	
	@Before
	public void setUp() throws Exception {
		coordenadas = LectorCoordenadas.getCoordenadas("instancia1.txt");
		g = GrafoCoordenadas.getGrafoCoordenadas(coordenadas);
	}

	@Test
	public void grafoNoNuloTest() {
		assertTrue(g != null);
	}
	 
}
