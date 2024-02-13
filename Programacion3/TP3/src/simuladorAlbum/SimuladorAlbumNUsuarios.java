package simuladorAlbum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import modelo.Usuario;
import modelo.VendedorPaquetes;

public abstract class SimuladorAlbumNUsuarios extends SimuladorAlbum {
	private List<Usuario> usuarios;
	private VendedorPaquetes vendedor;
	private int _cantFiguritas;
	
	public SimuladorAlbumNUsuarios(int cantFiguritas, int tamanioPaquete, int cantidadUsuarios) {
		VendedorPaquetes.setGenerador(rango -> {
			Random _random = new Random();
			return _random.nextInt(rango);
		});
		vendedor = new VendedorPaquetes(tamanioPaquete, cantFiguritas);
		_cantFiguritas = cantFiguritas;
		inicializarUsuarios(cantidadUsuarios);
	}
	
	@Override
	public double getGastoTotal() {
		double ret = 0.0;
		for(Usuario u : usuarios)
			ret += u.getPaquetesComprados() * vendedor.get_precio();
		return ret;
	}

	protected int getCantUsuarios() {
		return usuarios.size();
	}
	
	protected Usuario getUsuario(int i) {
		return usuarios.get(i);
	}
	
	protected List<Integer> vender(){
		return vendedor.venderPaquete();
	}
	
	private void inicializarUsuarios(int cantidadUsuarios) {
		usuarios = new ArrayList<>();
		for(int i = 0; i < cantidadUsuarios; i++) {
			usuarios.add(new Usuario(_cantFiguritas));
		}
	}
	
}
