package untref.aydoo.tp;

public class Atraccion {

	private TipoAtraccion tipo;
	private Double costo;
	private Double duracion;

	public Atraccion(TipoAtraccion tipo, Double costo, Double duracion) {
		this.tipo = tipo;
		this.costo = costo;
		this.duracion = duracion;
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

}
