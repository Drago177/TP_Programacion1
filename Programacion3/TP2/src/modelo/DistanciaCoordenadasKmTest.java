package modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openstreetmap.gui.jmapviewer.Coordinate;

public class DistanciaCoordenadasKmTest {
	Coordinate c1;
	Coordinate c2;
	Double distancia;

	@Before
	public void setUp() throws Exception {
		c1 = new Coordinate(-34.52133782929332, -58.70068073272705);
		c2 = new Coordinate(-34.520772089706036, -58.702311515808105);
		distancia = getDistancia(c1, c2);
	}

	@Test
	public void calcularTest() {
		assertEquals((Double)0.1621, distancia);
	}
	
	@Test
	public void distanciaCeroTest() {
		distancia = getDistancia(new Coordinate(0,0), new Coordinate(0, 0));
		assertEquals((Double)0.0000, distancia);
	}

	private Double getDistancia(Coordinate c1, Coordinate c2) {
		distancia = DistanciaCoordenadasKm.calcular(c1, c2);
		distancia = (Double)(Math.round(distancia * 10000.0)/10000.0);
		return distancia;
	}
}
