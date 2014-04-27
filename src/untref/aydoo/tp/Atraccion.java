package untref.aydoo.tp;

public class Atraccion {

	private TipoAtraccion tipo;
	private Double costo;
	private Double duracion;
	private Double latitud;
	private Double longitud;

	public Atraccion(TipoAtraccion tipo, Double costo, Double duracion,
			Double latitud, Double longitud) {
		this.tipo = tipo;
		this.costo = costo;
		this.duracion = duracion;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public Double getCosto() {
		return this.costo;
	}

	public TipoAtraccion getTipo() {
		return this.tipo;
	}

	public Double getDuracion() {
		return this.duracion;
	}

	public Double calcularDistanciaA(Double latitud, Double longitud) {
		return Math.sqrt(Math.pow(Math.abs(this.latitud - latitud), 2)
				+ Math.pow(Math.abs(this.longitud - longitud), 2));
	}

}
