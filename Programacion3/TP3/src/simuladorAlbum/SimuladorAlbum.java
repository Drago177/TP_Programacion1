package simuladorAlbum;

import java.util.ArrayList;
import java.util.List;
import modelo.Observador;

public abstract class SimuladorAlbum implements Runnable {
	private static List<Observador> _observadores;
	
	public abstract void simular();
	public abstract double getGastoTotal();
	
	public static void agregarObservador(Observador o) {
		_observadores = new ArrayList<>();
		_observadores.add(o);
	}
	
	public void notificar() {
		for(Observador o : _observadores)
			o.upddate(getGastoTotal());
	}
	
	@Override
	public void run() {
		simular();
		notificar();
	}
	
	
}
