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
	
	@Override
	public Double getDuracion() {
		return super.getDuracion() + this.atraccionGratis.getDuracion();
	}

	@Override
	public List<TipoAtraccion> getListaTiposAtraccion() {
		List<TipoAtraccion> tiposAtracciones = super.getListaTiposAtraccion();
		tiposAtracciones.add(atraccionGratis.getTipo());
		return tiposAtracciones;
	}

	@Override
	public List<Coordenada> getListaUbicaciones() {
		List<Coordenada> ubicaciones = super.getListaUbicaciones();
		ubicaciones.add(atraccionGratis.getUbicacion());
		return ubicaciones;
	}

}
