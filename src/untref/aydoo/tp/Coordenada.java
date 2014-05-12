package untref.aydoo.tp;

public class Coordenada {

	private Double latitud;
	private Double longitud;

	public Coordenada(Double latitud, Double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public Double calcularDistanciaA(Coordenada destino) {
		return Math.sqrt(Math.pow(Math.abs(latitud - destino.latitud), 2)
				+ Math.pow(Math.abs(longitud - destino.longitud), 2));
	}
	
	public Boolean esIgualA(Coordenada otro) {
		return (this.latitud.equals(otro.latitud) && this.longitud.equals(otro.longitud));
	}

}
