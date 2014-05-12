package untref.aydoo.tp;

import java.util.Date;
import java.util.List;

public class PromocionAbsoluta extends Promocion {

	private Double precio;

	public PromocionAbsoluta(List<Atraccion> atracciones, Date desde,
			Date hasta, Double precio) {
		this.atracciones = atracciones;
		this.desde = desde;
		this.hasta = hasta;
		this.precio = precio;
	}
	
	@Override
	public Double getPrecio() {
		return this.precio;
	}

}
