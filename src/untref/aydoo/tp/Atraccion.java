package untref.aydoo.tp;

public class Atraccion {

	private String nombre;
	private Double longitud;
	private Double latitud;
	private Double costo;
	private Double duracion;

	public Atraccion(String nombre, Double longitud, Double latitud,
			Double costo, Double duracion, Integer cupoVisitantes,
			TipoAtraccion tipo) {
		this.nombre = nombre;
		this.longitud = longitud;
		this.latitud = latitud;
		this.costo = costo;
		this.duracion = duracion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Double getLongitud() {
		return this.longitud;
	}

	public Double getLatitud() {
		return this.latitud;
	}

	public Double getCosto() {
		return this.costo;
	}

	public Double getDuracion() {
		return this.duracion;
	}

}
