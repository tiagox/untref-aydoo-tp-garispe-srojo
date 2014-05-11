package untref.aydoo.tp;

public class Coordenada {

	private Double latitud;
	private Double longitud;

	public Coordenada(Double latitud, Double longitud) {

		this.latitud = latitud;
		this.longitud = longitud;
	}

	public Double getLatitud() {
		return latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public Double calcularDistanciaA(Double latitud, Double longitud) {
		return Math.sqrt(Math.pow(Math.abs(this.latitud - latitud), 2)
				+ Math.pow(Math.abs(this.longitud - longitud), 2));
	}
}
