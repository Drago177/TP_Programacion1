package modelo;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	
	Usuario usuario;
	Usuario otroUsuario;
	List<Integer> figuritas;
	List<Integer> figuritasOtro;

	@Before
	public void setUp() throws Exception {
		usuario = new Usuario(5);
		otroUsuario = new Usuario(5);
		figuritas = new ArrayList<>();
		figuritasOtro = new ArrayList<>();
	}
	
	@Test
	public void intercambioExitosoTest() {
		inicializarExitoso();
		assertTrue(usuario.intercambiar(otroUsuario));
	}
	
	@Test
	public void intercambioFallidoTest() {
		inicializarFallido();
		assertFalse(usuario.intercambiar(otroUsuario));
	}

	private void inicializarExitoso() {
		figuritas.add(1);
		figuritas.add(2);
		figuritas.add(3);
		figuritas.add(5);
		figuritas.add(2);
		usuario.llenarAlbum(figuritas);
		
		figuritasOtro.add(1);
		figuritasOtro.add(3);
		figuritasOtro.add(4);
		figuritasOtro.add(5);
		figuritasOtro.add(4);
		otroUsuario.llenarAlbum(figuritasOtro);
	}
	
	private void inicializarFallido() {
	
		
		figuritas.add(1);
		figuritas.add(2);
		figuritas.add(3);
		figuritas.add(5);
		figuritas.add(2);
		usuario.llenarAlbum(figuritas);
		
		figuritasOtro.add(1);
		figuritasOtro.add(3);
		figuritasOtro.add(4);
		figuritasOtro.add(5);
		figuritasOtro.add(2);
		otroUsuario.llenarAlbum(figuritasOtro);
	}

}
