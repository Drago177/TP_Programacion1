package palabras;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PalabrasTest {
	ListaPalabras palabra;
	ListaPalabras palabraIng;
	
	@Before
	public void setUp() throws Exception {
		palabra = new ListaPalabrasEsp(0);
		palabraIng = new ListaPalabrasIng(0);
	}

	@Test
	public void obtenerPalabraTest() {
		assertEquals("LLAMO", palabra.getPalabra());
	}

	@Test
	public void obtenerPalabraIngTest() {
		assertEquals("DRINK", palabraIng.getPalabra());
	}
}
