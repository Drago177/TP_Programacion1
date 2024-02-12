package transportes;

public class CamionTrailer extends Transporte {
	private double segCarga;
	
	public CamionTrailer(String matricula, double cargaMax, double capacidad, boolean tieneRefrigeracion,
			double costoKm, double segCarga) {
		super(matricula, cargaMax, capacidad, tieneRefrigeracion, costoKm);
		this.segCarga = segCarga;
	}

	@Override
	public double calcularCosto() {
		return super.calcularCosto() + segCarga;
	}

	@Override
	public String toString() {
		return new StringBuilder(" CamionTrailer [segCarga: ").append(segCarga)
				.append("]").append(super.toString()).toString();
	}
}
