package modelo;

import java.util.ArrayList;
import java.util.List;

public class VendedorPaquetes {
	private double _precio;
	private int _tamanioPaquete;
	private int _figuritasPosibles;
	private static Generador _random;
	
	public VendedorPaquetes(int tamanioPaquete, int figuritasPosibles) {
		_precio = 300;
		_tamanioPaquete = tamanioPaquete;
		_figuritasPosibles = figuritasPosibles;
	}

	public List<Integer> venderPaquete() {
		return generarPaquete();
	}

	private List<Integer> generarPaquete() {
		List<Integer> ret = new ArrayList<>();
		for(int i = 0; i < _tamanioPaquete; i++) {
			ret.add(_random.nextInt(_figuritasPosibles));
		}
		return ret;
	}

	public double get_precio() {
		return _precio;
	}
	
	public static void setGenerador(Generador generador) {
		_random = generador;
	}

}
