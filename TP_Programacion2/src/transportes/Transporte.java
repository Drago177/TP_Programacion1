package transportes;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import tp.Paquete;

public abstract class Transporte {
	private String matricula;
	private double cargaMax;
	private double pesoCargaAct; //Agregada en la implementacion
	private double capacidad;
	private double capacidadUsada; //Agregada en la implementacion
	private boolean tieneRefrigeracion;
	private double costoKm;
	private List<Paquete> carga;
	private String destino;
	private int km;
	private boolean enViaje;
	
	public Transporte(String matricula, double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKm) {
		this.matricula = matricula;
		this.cargaMax = cargaMax;
		this.capacidad = capacidad;
		this.tieneRefrigeracion = tieneRefrigeracion;
		this.costoKm = costoKm;
		carga = new LinkedList<>();
	}
	
	public void asignarDestino(String destino, int km) {
		if(this.destino != null)
			throw new RuntimeException("El transporte ya tiene un destino asignado");
		this.destino = destino;
		this.km = km;
	}

	public boolean agregarPaquete(Paquete paquete) {
		if(enViaje || paquete.getDestino() != destino)
			return false;
		if(sobreCargado(paquete) || enViaje)
			return false;
		capacidadUsada += paquete.getVolumen();
		pesoCargaAct += paquete.getPeso();
		return carga.add(paquete);
	}

	public double calcularCosto() {
		return km * costoKm;
	}
	
	public void iniciarViaje() {
		if(carga.isEmpty())
			throw new RuntimeException("El transporte no tiene carga");
		if(enViaje)
			throw new RuntimeException("El transporte ya se encuentra en viaje");
		enViaje = true;
	}
	
	public void terminarViaje() {
		if(!enViaje)
			throw new RuntimeException("El transporte no se encuentra en viaje");
		vaciarCarga();
		destino = null;
		enViaje = false;
	}
	
	public boolean transporteIgual(Transporte t) {
		return getClass().equals(t.getClass()) && carga.containsAll(carga);
	}

	private void vaciarCarga() {
		carga.removeAll(carga);
		capacidadUsada = capacidad;
		pesoCargaAct = cargaMax;
		destino = null;
		km = 0;
	}
	
	private boolean sobreCargado(Paquete paquete) {
		return pesoCargaAct + paquete.getPeso() > cargaMax || capacidadUsada + paquete.getVolumen() > capacidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transporte other = (Transporte) obj;
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() {
		return new StringBuilder("Transporte [matricula=").append(matricula).append(", cargaMax=")
				.append(cargaMax).append(", capacidad=").append(capacidad).append(", tieneRefrigeracion=")
				.append(tieneRefrigeracion).append(", costoKm=").append(costoKm).append(", carga=")
				.append(carga).append(", destino=").append(destino).append(", km=").append(km)
				.append(", enViaje=").append(enViaje).append("]\n").toString();
	}
	

	public String getMatricula() {
		return matricula;
	}
	
	public String getDestino() {
		return destino;
	}

	public boolean isTieneRefrigeracion() {
		return tieneRefrigeracion;
	}
	
}
