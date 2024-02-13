package modelo;

import java.util.ArrayList;
import java.util.List;
import simuladorAlbum.SimuladorAlbum;
import simuladorAlbum.SimuladorAlbumIndividual;
import simuladorAlbum.SimuladorAlbumNUsuariosDonacion;
import simuladorAlbum.SimuladorAlbumNUsuariosIntercambio;

public class SimuladorAlbumMundial {
	private Observador _observador;
	
	private int _cantFiguritas;
	private int _tamanioPaquete;
	private List<Thread> _threads;
	private int _cantSimulaciones;
	private int _cantidadUsuarios;
	private boolean _intercambio;
	
	public SimuladorAlbumMundial(int cantFiguritas, int tamanioPaquete) {
		_cantFiguritas = cantFiguritas;
		_tamanioPaquete = tamanioPaquete;
		
		_observador = new Observador() {
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
		
		SimuladorAlbum.agregarObservador(_observador);
	}
	
	public double simular(int cantSimulaciones, int cantidadUsuarios, boolean intercambio) throws InterruptedException {
		_threads = new ArrayList<>(cantSimulaciones);
		_cantSimulaciones = cantSimulaciones;
		_cantidadUsuarios = cantidadUsuarios;
		_intercambio = intercambio;
		inicializarThreads();
		correrThreads();
		return _observador.getGasto()/cantSimulaciones;
	}

	private void inicializarThreads() {
		for(int i = 0; i < _cantSimulaciones; i++) {
			if(_cantidadUsuarios == 1)
				_threads.add(new Thread(new SimuladorAlbumIndividual(_cantFiguritas, _tamanioPaquete)));
			else 
				if(_intercambio)
				_threads.add(new Thread(new SimuladorAlbumNUsuariosIntercambio(_cantFiguritas,
						_tamanioPaquete, _cantidadUsuarios)));
				else
					_threads.add(new Thread(new SimuladorAlbumNUsuariosDonacion(_cantFiguritas,
							_tamanioPaquete, _cantidadUsuarios)));
		}
	}

	private void correrThreads() throws InterruptedException {
		for(Thread t : _threads) {
			t.start();
			t.join();
		}
	}
}
