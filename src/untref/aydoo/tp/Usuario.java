package untref.aydoo.tp;

public class Usuario {

	private String nombre;
	private String apellido;
	private Double presupuesto;
	private Double tiempoDisponible;
	private Double velocidadTraslado;
	private TipoAtraccion tipoPreferido;

	public Usuario(String nombre, String apellido, Double presupuesto,
			Double tiempoDisponible, Double velocidadTraslado,
			TipoAtraccion tipoPreferido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.velocidadTraslado = velocidadTraslado;
		this.tipoPreferido = tipoPreferido;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public Double getPresupuesto() {
		return this.presupuesto;
	}

	public Double getTiempoDisponible() {
		return this.tiempoDisponible;
	}

	public Double getVelocidadTraslado() {
		return this.velocidadTraslado;
	}

	public TipoAtraccion getTipoPreferido() {
		return this.tipoPreferido;
	}
}
