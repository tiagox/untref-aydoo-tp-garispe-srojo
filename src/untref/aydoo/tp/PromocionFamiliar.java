package untref.aydoo.tp;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class PromocionFamiliar extends Promocion {

	private Double descuento = 0.0;

	public PromocionFamiliar(List<Atraccion> atracciones, Date desde,
			Date hasta, Map<Atraccion, Integer> entradasPorAtraccion) {
		this.atracciones = atracciones;
		this.desde = desde;
		this.hasta = hasta;
		this.descuento = calcularDescuento(entradasPorAtraccion);

	}

	@Override
	public Double getPrecio() {
		return super.getPrecio() - this.descuento;
	}

	private Double calcularDescuento(
			Map<Atraccion, Integer> entradasPorAtraccion) {
		Double descuentoTotal = 0.0;
		if (this.atracciones.size() > 0) {
			for (Atraccion atraccion : this.atracciones) {
				Double precioEntrada = atraccion.getCosto()
						/ entradasPorAtraccion.get(atraccion);
				if (entradasPorAtraccion.containsKey(atraccion)) {
					if (entradasPorAtraccion.get(atraccion) >= 4) {
						if (entradasPorAtraccion.get(atraccion) > 4) {
							descuentoTotal += (0.1 * atraccion.getCosto() + (entradasPorAtraccion
									.get(atraccion) - 4) * precioEntrada * 0.3);
						} else {
							descuentoTotal += 0.1 * atraccion.getCosto();
						}
					}
				}
			}
		}
		return descuentoTotal;
	}
}
