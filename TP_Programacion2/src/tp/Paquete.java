package tp;

public class Paquete {
	private double peso;
	private double volumen;
	private String destino;
	private boolean necesitaRefrigeracion;
	
	public Paquete(double peso, double volumen, String destino, boolean necesitaRefrigeracion) {
		this.peso = peso;
		this.volumen = volumen;
		this.destino = destino;
		this.necesitaRefrigeracion = necesitaRefrigeracion;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getVolumen() {
		return volumen;
	}

	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public boolean isNecesitaRefrigeracion() {
		return necesitaRefrigeracion;
	}

	public void setNecesitaRefrigeracion(boolean necesitaRefrigeracion) {
		this.necesitaRefrigeracion = necesitaRefrigeracion;
	}

	@Override
	public String toString() {
		return new StringBuilder("Paquete [peso: ").append(peso).append(", volumen: ")
				.append(volumen).append(", destino: ").append(destino)
				.append(", necesitaRefrigeracion: ").append(necesitaRefrigeracion)
				.append("]\n").toString();
	}

}
