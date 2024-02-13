package grafos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArcoTest {
	Arco arco;
	Arco arco2;
	Arco arco3;
	
	@Before
	public void setUp() throws Exception {
		arco = new Arco(0, 1, 4);
		arco2 = new Arco(0, 7, 8);
		arco3 = new Arco(0, 1, 4);
	}

	@Test
	public void getPesotest() {
		assertTrue(4 == arco.getPeso());
	}
	
	@Test
	public void compareToMenorTest() {
		assertTrue(arco.compareTo(arco2) < 0);
	}
	
	@Test
	public void compareToMayorTest() {
		assertTrue(arco2.compareTo(arco) > 0);
	}

	@Test
	public void compareToIgualTest() {
		assertTrue(arco.compareTo(arco3) == 0);
	}
}
