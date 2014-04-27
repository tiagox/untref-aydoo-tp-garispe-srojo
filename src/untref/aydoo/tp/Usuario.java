package untref.aydoo.tp;

public class Usuario {

	private Double presupuesto;
	private Double tiempoDisponible;
	private Double velocidadTraslado;
	private TipoAtraccion tipoPreferido;

	public Usuario(Double presupuesto, Double tiempoDisponible,
			Double velocidadTraslado, TipoAtraccion tipoPreferido) {
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.velocidadTraslado = velocidadTraslado;
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
}
