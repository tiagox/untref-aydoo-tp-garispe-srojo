package untref.aydoo.tp;

public class Atraccion {

	Double costo;
	private TipoAtraccion tipo;

	public Atraccion(TipoAtraccion tipo, Double costo) {
		this.tipo = tipo;
		this.costo = costo;
	}

	public Double getCosto() {
		return this.costo;
	}

	public TipoAtraccion getTipo() {
		return this.tipo;
	}

}
