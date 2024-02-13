package simuladorAlbum;

import java.util.Random;
import modelo.Usuario;
import modelo.VendedorPaquetes;

public class SimuladorAlbumIndividual extends SimuladorAlbum {
	protected Usuario usuario;
	private VendedorPaquetes vendedorPaquetes;

	public SimuladorAlbumIndividual(int cantFiguritas, int tamanioPaquete) {
		VendedorPaquetes.setGenerador(rango -> {
			Random _random = new Random();
			return _random.nextInt(rango);
		});
		usuario = new Usuario(cantFiguritas);
		vendedorPaquetes = new VendedorPaquetes(tamanioPaquete, cantFiguritas);
	}
	
	public void simular() {	
		while(!usuario.albumCompletado())
			usuario.llenarAlbum(vendedorPaquetes.venderPaquete());
	}
	
	@Override
	public double getGastoTotal() {
		return usuario.getPaquetesComprados() * vendedorPaquetes.get_precio();
	}

	@Override
	public void run() {
		super.run();
	}

}
