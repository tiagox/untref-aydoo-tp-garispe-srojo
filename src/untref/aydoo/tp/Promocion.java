package untref.aydoo.tp;

import java.util.Date;
import java.util.List;

public class Promocion {

	protected Date desde;
	protected Date hasta;
	protected List<Atraccion> atracciones;

	public Boolean isVigente(Date referencia) {
		return this.desde.compareTo(referencia) <= 0
				&& this.hasta.compareTo(referencia) >= 0;
	}

	protected Double getCostoTotal() {
		Double costoTotal = 0.0;
		for (Atraccion atraccion : this.atracciones) {
			costoTotal += atraccion.getCosto();
		}
		return costoTotal;
	}

}
