package vista;

import modelo.SimuladorAlbumMundial;

public class DatosDeEntrada {
	private int _cantFiguritas;
	private int _tamanioPaquete;
	private int _cantSimulaciones;
	private int _cantidadUsuarios;
	private boolean _intercambio;
	private SimuladorAlbumMundial simulador;
	
	public DatosDeEntrada(int cantFiguritas, int tamanioPaquete, int cantSimulaciones,
			int cantidadUsuarios, boolean intercambio) {
		_cantFiguritas = cantFiguritas;
		_tamanioPaquete = tamanioPaquete;
		_cantSimulaciones = cantSimulaciones;
		_cantidadUsuarios = cantidadUsuarios;
		_intercambio = intercambio;
	}

	public double simular() throws InterruptedException {
		simulador = new SimuladorAlbumMundial(_cantFiguritas, _tamanioPaquete);
		return simulador.simular(_cantSimulaciones, _cantidadUsuarios, _intercambio);
	}
	
}
