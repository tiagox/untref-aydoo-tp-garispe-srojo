package untref.aydoo.tp;

import java.util.Date;
import java.util.List;

public class PromocionExtranjero extends Promocion {

	private final Double distanciaMinima = 200.0;
	private final Double descuento = 0.5;

	public PromocionExtranjero(List<Atraccion> atracciones, Date desde,
			Date hasta, Coordenada domicilio) {
		this.atracciones = atracciones;
		this.desde = desde;
		this.hasta = hasta;

		if (!aplicaPromocion(domicilio)) {
			throw new Error(
					"La promocion solo es aplicable a los usuarios con domicilio a mas de "
							+ distanciaMinima + " km de las atracciones.");
		}
	}

	private Boolean aplicaPromocion(Coordenada domicilio) {
		return getDistanciaAtraccionMasCercanaA(domicilio) > this.distanciaMinima;
	}

	private Double getDistanciaAtraccionMasCercanaA(Coordenada domicilio) {
		Double distanciaMinima = domicilio.calcularDistanciaA(this.atracciones
				.get(0).getUbicacion());
		Double distanciaActual = distanciaMinima;
		for (Atraccion atraccion : this.atracciones) {
			distanciaActual = domicilio.calcularDistanciaA(atraccion
					.getUbicacion());
			if (distanciaActual < distanciaMinima) {
				distanciaMinima = distanciaActual;
			}
		}
		return distanciaMinima;
	}

	@Override
	public Double getPrecio() {
		return super.getPrecio() * this.descuento;
	}
}
