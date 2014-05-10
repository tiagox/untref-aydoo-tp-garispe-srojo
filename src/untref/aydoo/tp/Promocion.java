package untref.aydoo.tp;

import java.util.Date;
import java.util.List;

public abstract class Promocion implements Sugerible {

	protected List<Atraccion> atracciones;
	protected Date desde;
	protected Date hasta;

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

	public abstract Double getPrecio();

	public Boolean hasTipoAtraccion(TipoAtraccion tipo) {
		for (Atraccion atraccion : this.atracciones) {
			if (atraccion.getTipo() == tipo) {
				return true;
			}
		}
		return false;
	}

	public Double getDuracion() {
		Double duracionTotal = 0.0;
		for (Atraccion atraccion : this.atracciones) {
			duracionTotal += atraccion.getDuracion();
		}
		return duracionTotal;
	}

	public Double getDistanciaAtraccionMasCercana(Double latitud,
			Double longitud) {
		Double distanciaMasCercana;
		if (this.atracciones.size() > 0) {
			distanciaMasCercana = this.atracciones.get(0).calcularDistanciaA(
					latitud, longitud);
			for (Atraccion atraccion : this.atracciones) {
				if (distanciaMasCercana > atraccion.calcularDistanciaA(latitud,
						longitud)) {
					distanciaMasCercana = atraccion.calcularDistanciaA(latitud,
							longitud);
				}
			}
		} else {
			distanciaMasCercana = -1.0;
		}
		return distanciaMasCercana;
	}

}
