package untref.aydoo.tp;

import java.util.Date;
import java.util.List;

public class PromocionPorcentual extends Promocion {

	private Double descuento;

	public PromocionPorcentual(List<Atraccion> atracciones, Date desde,
			Date hasta, Double descuento) {
		this.atracciones = atracciones;
		this.desde = desde;
		this.hasta = hasta;
		this.descuento = descuento;
	}

	public Double getPrecio() {
		return this.getCostoTotal() * (100.0 - this.descuento) / 100.0;
	}

}
