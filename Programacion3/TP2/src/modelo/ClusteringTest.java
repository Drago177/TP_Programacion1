package modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import agm.ArbolGeneradorMinimo;
import grafos.Grafo;

public class ClusteringTest {
	private Grafo g;
	private Grafo clustEsp;
	private Grafo clustEsp4;
	private Clustering clust;

	@Before
	public void setUp() throws Exception {
		g = new Grafo(9);
		agregarAristasG();
		clustEsp = new Grafo(9);
		agregarAristasClustEsp();
		clustEsp4 = new Grafo(9);
		agregarAristasClustEsp4();
		clust = new Clustering(new ArbolGeneradorMinimo(g));
	}

	@Test
	public void tresClustersTest() {
 		assertEquals(clustEsp, clust.getClusters(3));
	}
	
//	@Test
	public void cuatroClustersTest() {
		assertEquals(clustEsp4, clust.getClusters(4));
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
	
	private void agregarAristasClustEsp() {
		clustEsp.agregarArco(0, 1, 4);
		clustEsp.agregarArco(7, 6, 1);
		clustEsp.agregarArco(6, 5, 3);
		clustEsp.agregarArco(5, 2, 4);
		clustEsp.agregarArco(2, 8, 3);
		clustEsp.agregarArco(2, 3, 6);
	}
	
	private void agregarAristasClustEsp4() {
		clustEsp4.agregarArco(0, 1, 4);
		clustEsp4.agregarArco(7, 6, 1);
		clustEsp4.agregarArco(6, 5, 3);
		clustEsp4.agregarArco(5, 2, 4);
		clustEsp4.agregarArco(2, 8, 3);
	}
}
