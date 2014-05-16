package untref.aydoo.tp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Promocion implements Sugerible {

	protected List<Atraccion> atracciones;
	protected Date desde;
	protected Date hasta;

	@Override
	public Boolean isVigente(Date referencia) {
		return this.desde.compareTo(referencia) <= 0
				&& this.hasta.compareTo(referencia) >= 0;
	}

<<<<<<< HEAD
	public Double getPrecio() {
		Double costoTotal = 0.0;
		for (Atraccion atraccion : atracciones) {
			costoTotal += atraccion.getCosto();
		}
		return costoTotal;
	}

=======
	@Override
	public Double getPrecio() {
		Double costoTotal = 0.0;
		for (Atraccion atraccion : atracciones) {
			costoTotal += atraccion.getPrecio();
		}		
		return costoTotal;
	}

	@Override
>>>>>>> 51f3c3f6399134257b2e877fdc4aa68ef1467206
	public Double getDuracion() {
		Double duracionTotal = 0.0;
		for (Atraccion atraccion : this.atracciones) {
			duracionTotal += atraccion.getDuracion();
		}
		return duracionTotal;
	}

<<<<<<< HEAD
=======
	@Override
>>>>>>> 51f3c3f6399134257b2e877fdc4aa68ef1467206
	public List<TipoAtraccion> getListaTiposAtraccion() {
		List<TipoAtraccion> tiposAtracciones = new ArrayList<TipoAtraccion>();
		for (Atraccion atraccion : atracciones) {
			tiposAtracciones.add(atraccion.getTipo());
		}
		return tiposAtracciones;
	}

	@Override
	public List<Coordenada> getListaUbicaciones() {
		List<Coordenada> ubicaciones = new ArrayList<Coordenada>();
		for (Atraccion atraccion : atracciones) {
			ubicaciones.add(atraccion.getUbicacion());
		}
		return ubicaciones;
	}

}
