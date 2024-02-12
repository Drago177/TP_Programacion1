package deposito;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import tp.Paquete;

public class Deposito {
	private double capacidad;
	private double capacidadOcupada; //agregada en la implementación
	
	Map<String, LinkedList<Paquete>> paquetes;
	
	public Deposito(double capacidad) {
		this.capacidad = capacidad;
		this.capacidadOcupada = 0;
		paquetes = new HashMap<>();
	}
	
	public boolean depositarPaquete(Paquete paquete){
		if(paquete == null)
			return false;
		if (capacidadOcupada == this.capacidad)
			return false;
		
		if(capacidadOcupada + paquete.getVolumen() > capacidad)
			return false;
		
		if(paquetes.containsKey(paquete.getDestino()))
			paquetes.get(paquete.getDestino()).add(paquete);
		else {
			LinkedList<Paquete> paquetesAux = new LinkedList<>();
			paquetesAux.add(paquete);
			paquetes.put(paquete.getDestino(), paquetesAux);
		}
		capacidadOcupada = paquete.getVolumen() + capacidadOcupada;
		return true;
	}
	
	public Paquete darPaquete(String destino) {
		Paquete paqueteEliminado = null;
		if(paquetes.containsKey(destino) && !paquetes.get(destino).isEmpty()) {
			paqueteEliminado = paquetes.get(destino).remove();
			capacidadOcupada = capacidadOcupada - paqueteEliminado.getVolumen();
		}
		return paqueteEliminado;
	}

	@Override
	public String toString() {
		return new StringBuilder("Deposito [capacidad: ").append(capacidad)
				.append(", capacidadOcupada: ").append(capacidadOcupada)
				.append(", paquetes: ").append(paquetes).append("]\n").toString();
	}
	
	
	
}
