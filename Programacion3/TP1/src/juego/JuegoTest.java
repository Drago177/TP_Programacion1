package juego;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class JuegoTest {
	String palabraUser;
	List<Estado> result;
	Juego juego;

	@Before
	public void setUp() throws Exception {
		result = new ArrayList<>();
		juego = new Juego(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void noSeEncuentraPalabraTest() {
		palabraUser = "asdfg";
		juego.compararPalabra(palabraUser);
	}

	@Test
	public void palabraCorrectaTest() {
		palabraUser = "LLAMO";
		result.add(Estado.CORRECTA);
		result.add(Estado.CORRECTA);
		result.add(Estado.CORRECTA);
		result.add(Estado.CORRECTA);
		result.add(Estado.CORRECTA);
		assertEquals(result, juego.compararPalabra(palabraUser));
	}
	
	@Test
	public void resultadoParcialTest() {
		palabraUser = "LLAMA";
		result.add(Estado.CORRECTA);
		result.add(Estado.CORRECTA);
		result.add(Estado.CORRECTA);
		result.add(Estado.CORRECTA);
		result.add(Estado.INCORRECTA);
		assertEquals(result, juego.compararPalabra(palabraUser));
	}
	
	@Test
	public void resultadoErroneoTest() {
		palabraUser = "BEBER";
		result.add(Estado.INCORRECTA);
		result.add(Estado.INCORRECTA);
		result.add(Estado.INCORRECTA);
		result.add(Estado.INCORRECTA);
		result.add(Estado.INCORRECTA);
		assertEquals(result, juego.compararPalabra(palabraUser));
	}
	
	@Test
	public void resultadoPosicionIncorrectaTest() {
		palabraUser = "BARCO";
		result.add(Estado.INCORRECTA);
		result.add(Estado.EN_OTRA_POSICION);
		result.add(Estado.INCORRECTA);
		result.add(Estado.INCORRECTA);
		result.add(Estado.CORRECTA);
		assertEquals(result, juego.compararPalabra(palabraUser));
	}
	
}
