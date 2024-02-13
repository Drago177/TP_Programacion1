package grafos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ConsultaDeArcosTest {
	Grafo g;
	List<Arco> arcosI;
	
	@Before
	public void setUp() throws Exception {
		g = new Grafo(9);
		agregarArcosG();
		arcosI = new ArrayList<>();
	}

	@Test
	public void getPesoPrimerArcotest() {
		assertTrue(g.getPesoArco(0, 1) == 4);
	}

	@Test
	public void getPesoUltimoArcoTest() {
		assertTrue(g.getPesoArco(7, 8) == 6);
	}
	
	@Test
	public void getArcosPrimerV() {
		arcosI.add(new Arco(0,1,4));
		arcosI.add(new Arco(0, 7, 8));
		assertTrue(g.getArcosI(0).containsAll(arcosI));
	}
	
	@Test
	public void getArcosUltimoV() {
		arcosI.add(new Arco(2, 8, 3));
		arcosI.add(new Arco(6, 8, 5));
		arcosI.add(new Arco(7, 8, 6));
		assertTrue(g.getArcosI(g.tamano()-1).containsAll(arcosI));
	}
	
	private void agregarArcosG() {
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
