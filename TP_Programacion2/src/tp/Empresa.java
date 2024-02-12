package tp;

import java.util.HashMap;
import java.util.Map;

import deposito.Deposito;
import transportes.*;

public class Empresa {
	private String cuit;
	private String nombre;
	private Map<String, Transporte> transportes;
	private Deposito deposito;
	private Deposito depositoRefrigerado;
	private Map<String, Integer> destinos;
	
	public Empresa(String cuit, String nombre, int capacidadDeCadaDeposito) {
		this.cuit = cuit;
		this.nombre = nombre;
		transportes = new HashMap<>();
		deposito = new Deposito(capacidadDeCadaDeposito);
		depositoRefrigerado = new Deposito(capacidadDeCadaDeposito);
		destinos = new HashMap<>();
	}
	
	public void agregarDestino(String destino, int km) {
		if(destino.length() == 0 || destinos.containsKey(destino)) {
			throw new RuntimeException("Destino no válido");
		}
		
		if(km <= 0) {
			throw new RuntimeException("Distancia no válida");
		}
		destinos.put(destino,km);
	}
	
	public void agregarTrailer(String matricula, double cargaMax,double capacidad, boolean tieneRefrigeracion,
			double costoKm, double segCarga) {
		transporteYaregistrado(matricula);
		Transporte t = new CamionTrailer(matricula, cargaMax, capacidad, tieneRefrigeracion, costoKm, segCarga);
		transportes.put(matricula, t);
	}
	
	public void agregarMegaTrailer(String matricula, double cargaMax, double capacidad, boolean tieneRefrigeracion,
			double costoKm, double segCarga, double costoFijo, double costoComida) {
		transporteYaregistrado(matricula);
		Transporte t = new CamionMegaTrailer(matricula, cargaMax, capacidad, tieneRefrigeracion, costoKm, segCarga, costoFijo, costoComida);
		transportes.put(matricula, t);
		
	}
	
	public void agregarFlete(String matricula, double cargaMax, double capacidad, double costoKm,
			int cantAcompaniantes, double costoPorAcompaniante) {
		transporteYaregistrado(matricula);
		Transporte t = new Flete(matricula, cargaMax, capacidad, costoKm, cantAcompaniantes, costoPorAcompaniante);
		transportes.put(matricula, t);
	}
	
	public void asignarDestino(String matricula, String destino) {
		transporteNoRegistrado(matricula);
		if(!destinos.containsKey(destino))
			throw new RuntimeException("Destino no registrado");
		transportes.get(matricula).asignarDestino(destino, destinos.get(destino));
	}
	
	public boolean incorporarPaquete(String destino, double peso, double volumen, boolean necesitaRefrigeracion) {
		Paquete paquete = new Paquete(peso, volumen, destino, necesitaRefrigeracion);
		if(destinos.containsKey(destino)) {
			if(paquete.isNecesitaRefrigeracion() == false)
				return deposito.depositarPaquete(paquete);
			return depositoRefrigerado.depositarPaquete(paquete);
		}
		return false;
	}
	
	public double cargarTransporte(String matricula) {
		transporteNoRegistrado(matricula);
		Transporte t = transportes.get(matricula);
		boolean transporteLleno = false;
		double contVol = 0;
		Deposito d;
		
		if(t.isTieneRefrigeracion())
			d = depositoRefrigerado;
		else
			d = deposito;
		
		while(!transporteLleno) {
			Paquete paqueteCargado = d.darPaquete(t.getDestino());
			if(paqueteCargado != null && t.agregarPaquete(paqueteCargado))
				contVol += paqueteCargado.getVolumen();
			else {
				transporteLleno = true;
				d.depositarPaquete(paqueteCargado);
			}
		}
		
		return contVol;
	}
	
	public void iniciarViaje(String matricula) {
		transporteNoRegistrado(matricula);
		transportes.get(matricula).iniciarViaje();
	}
	
	public void finalizarViaje(String matricula) {
		transporteNoRegistrado(matricula);
		transportes.get(matricula).terminarViaje();
	}
	
	public double obtenerCostoViaje(String matricula) {
		transporteNoRegistrado(matricula);
		return transportes.get(matricula).calcularCosto();
	}
	
	public String obtenerTransporteIgual(String matricula) {
		transporteNoRegistrado(matricula);
		Transporte transporte = transportes.get(matricula);
		for(Transporte t : transportes.values()) {
			if(!t.equals(transporte) && t.transporteIgual(transporte))
				return t.getMatricula();
		}
		return null;
	}
	
	
	private void transporteYaregistrado(String matricula) {
		if(transportes.containsKey(matricula))
			throw new RuntimeException("Transporte ya registrado");
	}
	
	private void transporteNoRegistrado(String matricula) {
		if(!transportes.containsKey(matricula))
			throw new RuntimeException("Transporte no registrado");
	}

	@Override
	public String toString() {
		return new StringBuilder("Empresa [CUIT: ").append(cuit).append(", Nombre: ")
				.append(nombre).append("]").append("{\nTransportes: ").append(transportes)
				.append("\n\nDeposito: ").append(deposito).append("\nDeposito Refrigerado: ")
				.append(depositoRefrigerado).append("\nDestinos: ").append(destinos)
				.append("\n}").toString();
	}
	
	
	
}
