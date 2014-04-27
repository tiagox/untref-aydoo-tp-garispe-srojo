package untref.aydoo.tp;

import java.util.Date;
import java.util.List;

public class PromocionAbsoluta extends Promocion {

	private Double precio;

	public PromocionAbsoluta(List<Atraccion> atracciones, Date vigenciaDesde,
			Date vigenciaHasta, Double precio) {
		this.atracciones = atracciones;
		this.desde = vigenciaDesde;
		this.hasta = vigenciaHasta;
		this.precio = precio;
	}

	public Double getPrecio() {
		return this.precio;
	}

}
