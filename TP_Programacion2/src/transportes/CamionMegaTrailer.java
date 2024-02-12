package transportes;

public class CamionMegaTrailer extends CamionTrailer {
	private double costoFijo;
	private double costoComida;

	public CamionMegaTrailer(String matricula, double cargaMax, double capacidad, boolean tieneRefrigeracion,
			double costoKm, double segCarga, double costoFijo, double costoComida) {
		super(matricula, cargaMax, capacidad, tieneRefrigeracion, costoKm, segCarga);
		this.costoFijo = costoFijo;
		this.costoComida = costoComida;
	}

	@Override
	public double calcularCosto() {
		return super.calcularCosto() + costoFijo + costoComida;
	}

	@Override
	public String toString() {
		return new StringBuilder(" CamionMegaTrailer [costoFijo: ").append(costoFijo)
				.append(", costoComida: ").append(costoComida).append("]")
				.append(super.toString()).toString();
	}
	
}
