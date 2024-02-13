package agm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import grafos.Grafo;

public class ArbolGeneradorMinimoTest {
	Grafo g;
	ArbolGeneradorMinimo agm;
	Grafo gAgm;
	Grafo agmEsperado;
	
	@Before
	public void setUp() throws Exception {
		g = new Grafo(9);
		agregarAristasG();
		agm = new ArbolGeneradorMinimo(g);
		gAgm = agm.construirAGM();
		agmEsperado = new Grafo(9);
		agregarAristasAgmEsp();
	}
	
	@Test
	public void agmNoNuloTest() {
		assertTrue(gAgm != null);
	}

	@Test
	public void construirAGMTest() {
		assertEquals(agmEsperado, gAgm);
	}
	
	private void agregarAristasAgmEsp() {
		agmEsperado.agregarArco(0, 1, 4);
		agmEsperado.agregarArco(0, 7, 8);
		agmEsperado.agregarArco(7, 6, 1);
		agmEsperado.agregarArco(6, 5, 3);
		agmEsperado.agregarArco(5, 2, 4);
		agmEsperado.agregarArco(2, 8, 3);
		agmEsperado.agregarArco(2, 3, 6);
		agmEsperado.agregarArco(3, 4, 9);
	}

	private void agregarAristasG() {
		g.agregarArco(0, 1, 4);
		g.agregarArco(0, 7, 8);
		g.agregarArco(1, 7, 12);
		g.agregarArco(1, 2, 8);
		g.agregarArco(2, 3, 6);
		g.agregarArco(2, 5, 4);
		g.agregarArco(2, 8, 3);
		g.agregarArco(3, 4, 9);
		g.agregarArco(3, 5, 13);
		g.agregarArco(4, 5, 10);
		g.agregarArco(5, 6, 3);
		g.agregarArco(6, 7, 1);
		g.agregarArco(6, 8, 5);
		g.agregarArco(7, 8, 6);
	}

}
