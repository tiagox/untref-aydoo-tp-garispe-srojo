package untref.aydoo.tp;

public class Atraccion {

	private String nombre;

	public Atraccion(String nombre, Double longitud, Double latitud,
			Double costo, Double duracion, Integer cupoVisitantes,
			TipoAtraccion tipo) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}
}
