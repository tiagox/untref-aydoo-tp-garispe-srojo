package untref.aydoo.tp;

public class Atraccion {

	private String nombre;
	private Double longitud;

	public Atraccion(String nombre, Double longitud, Double latitud,
			Double costo, Double duracion, Integer cupoVisitantes,
			TipoAtraccion tipo) {
		this.nombre = nombre;
		this.longitud = longitud;
	}

	public String getNombre() {
		return this.nombre;
	}

	public double getLongitud() {
		return this.longitud;
	}
}
