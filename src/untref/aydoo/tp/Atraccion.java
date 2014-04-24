package untref.aydoo.tp;

public class Atraccion {

	private String nombre;
	private Double longitud;
	private double latitud;
	private double costo;

	public Atraccion(String nombre, Double longitud, Double latitud,
			Double costo, Double duracion, Integer cupoVisitantes,
			TipoAtraccion tipo) {
		this.nombre = nombre;
		this.longitud = longitud;
		this.latitud = latitud;
		this.costo = costo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public double getLongitud() {
		return this.longitud;
	}

	public double getLatitud() {
		return this.latitud;
	}

	public double getCosto() {
		return this.costo;
	}

}
