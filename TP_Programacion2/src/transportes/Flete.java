package transportes;

public class Flete extends Transporte {
	private int cantAcompaniantes;
	private double costoPorAcompaniante;
	
	public Flete(String matricula, double cargaMax, double capacidad, double costoKm, int cantAcompaniantes, double costoPorAcompaniante) {
		super(matricula, cargaMax, capacidad, false, costoKm);
		this.cantAcompaniantes = cantAcompaniantes;
		this.costoPorAcompaniante = costoPorAcompaniante;
	}

	@Override
	public double calcularCosto() {
		return super.calcularCosto() + cantAcompaniantes * costoPorAcompaniante;
	}

	@Override
	public String toString() {
		return new StringBuilder("Flete [cantAcompaniantes: ").append(cantAcompaniantes).
				append(", costoPorAcompaniante: ").append(costoPorAcompaniante)
				.append("]").append(super.toString()).toString();
	}

}
