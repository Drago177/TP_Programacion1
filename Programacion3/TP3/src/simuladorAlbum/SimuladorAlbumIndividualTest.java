package simuladorAlbum;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import modelo.Observador;
import modelo.VendedorPaquetes;

public class SimuladorAlbumIndividualTest {
	
	private SimuladorAlbum simulador;
	private List<Integer> paquete;
	private int indice;
	private Double gastoEsperado;
	private Observador o;

	@Before
	public void setUp() throws Exception {
		simulador = new SimuladorAlbumIndividual(10, 5);
		gastoEsperado = 600.0;
		paquete = new ArrayList<>();
		inicializarPaquete();
		o = new Observador() {
			double _gasto;
			@Override
			public void upddate(double gasto) {
				_gasto += gasto;
			}
			
			@Override
			public double getGasto() {
				return _gasto;
			}
		};
		SimuladorAlbum.agregarObservador(o);
	}
	

	@Test
	public void simularTest() {
		setGenerador(paquete);
		simulador.run();
		assertEquals(gastoEsperado, (Double)o.getGasto());
	}
	
	private void inicializarPaquete() {
		paquete.add(1);
		paquete.add(2);
		paquete.add(3);
		paquete.add(4);
		paquete.add(5);
		paquete.add(6);
		paquete.add(7);
		paquete.add(8);
		paquete.add(9);
		paquete.add(10);
	}


	private void setGenerador(List<Integer> paquete) {
		VendedorPaquetes.setGenerador(rango -> paquete.get(indice++));
	}

}
