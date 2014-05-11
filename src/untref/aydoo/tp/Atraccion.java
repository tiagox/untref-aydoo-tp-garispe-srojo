package untref.aydoo.tp;

public class Atraccion {

	private TipoAtraccion tipo;
	private Double costo;
	private Double duracion;
	private Integer cupoVisitantes;
	private Coordenada ubicacion;

	public Atraccion(TipoAtraccion tipo, Double costo, Double duracion,
			Integer cupoVisitantes, Coordenada ubicacion) {
		this.tipo = tipo;
		this.costo = costo;
		this.duracion = duracion;
		this.cupoVisitantes = cupoVisitantes;
		this.ubicacion = ubicacion;
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

	public Integer getCupoVisitantes() {
		return this.cupoVisitantes;
	}

	public Coordenada getUbicacion() {
		return this.ubicacion;
	}

}
