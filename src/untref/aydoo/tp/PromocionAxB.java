package untref.aydoo.tp;

import java.util.Date;
import java.util.List;

public class PromocionAxB extends Promocion {

	public PromocionAxB(List<Atraccion> atracciones, Date desde, Date hasta,
			Atraccion atraccionGratis) {
		this.atracciones = atracciones;
		this.desde = desde;
		this.hasta = hasta;
	}

	public double getPrecio() {
		return this.getCostoTotal();
	}

}
