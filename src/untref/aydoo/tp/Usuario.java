package untref.aydoo.tp;

public class Usuario {

	private Double presupuesto;
	private Double tiempoDisponible;
	private Double velocidadTraslado;
	private Double latitud;
	private Double longitud;
	private TipoAtraccion tipoPreferido;

	public Usuario(Double presupuesto, Double tiempoDisponible,
			Double velocidadTraslado, Double latitud, Double longitud,
			TipoAtraccion tipoPreferido) {
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.velocidadTraslado = velocidadTraslado;
		this.latitud = latitud;
		this.longitud = longitud;
		this.tipoPreferido = tipoPreferido;
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

	public Double getLatitud() {
		return this.latitud;
	}

	public Double getLongitud() {
		return this.longitud;
	}

}
