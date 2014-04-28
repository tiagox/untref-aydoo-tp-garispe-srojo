package untref.aydoo.tp;

import java.util.Date;
import java.util.List;

public class PromocionAxB extends Promocion {

	private Atraccion atraccionGratis;

	public PromocionAxB(List<Atraccion> atracciones, Date desde, Date hasta,
			Atraccion atraccionGratis) {
		this.atracciones = atracciones;
		this.desde = desde;
		this.hasta = hasta;
		this.atraccionGratis = atraccionGratis;
	}

	public Double getPrecio() {
		return this.getCostoTotal();
	}

	public Boolean hasTipoAtraccion(TipoAtraccion tipo) {
		return super.hasTipoAtraccion(tipo)
				|| (this.atraccionGratis.getTipo() == tipo);
	}

	public Double getDuracion() {
		return super.getDuracion() + this.atraccionGratis.getDuracion();
	}

	public Double getDistanciaAtraccionMasCercana(Double latitud,
			Double longitud) {
		if (super.getDistanciaAtraccionMasCercana(latitud, longitud) != -1) {
			return Math.min(
					super.getDistanciaAtraccionMasCercana(latitud, longitud),
					this.atraccionGratis.calcularDistanciaA(latitud, longitud));
		} else {
			return this.atraccionGratis.calcularDistanciaA(latitud, longitud);
		}
	}
}
