package modelo;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class VendedorPaquetesTest {
	VendedorPaquetes vendedor;
	List<Integer> paqueteEsperado;
	int indice;
	@Before
	public void setUp() throws Exception {
		paqueteEsperado = new ArrayList<>();
		vendedor = new VendedorPaquetes(5, 638);
		indice = 0;
	}

	private void inicializar() {
		paqueteEsperado.add(1);
		paqueteEsperado.add(2);
		paqueteEsperado.add(4);
		paqueteEsperado.add(638);
		paqueteEsperado.add(1);
		
		VendedorPaquetes.setGenerador(rango -> paqueteEsperado.get(indice++));
	}

	@Test
	public void venderPaqueteTest() {
		inicializar();
		assertEquals(paqueteEsperado, vendedor.venderPaquete());
	}

}
