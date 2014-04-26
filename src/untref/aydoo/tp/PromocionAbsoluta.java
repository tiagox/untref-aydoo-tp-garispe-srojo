package untref.aydoo.tp;

import java.util.Iterator;
import java.util.List;

public class PromocionAbsoluta {

	private String nombre;
	private List<Atraccion> atracciones;
	private Integer periodoVigencia;

	public PromocionAbsoluta(String nombre, Integer periodoVigencia,
			List<Atraccion> atracciones) {

		this.nombre = nombre;
		this.atracciones = atracciones;
		this.periodoVigencia = periodoVigencia;
	}

	public Double descuento(Double descuentoTotal) {

		Double costoTotal = 0.0;

		Iterator<Atraccion> iterator = this.atracciones.iterator();

		while (iterator.hasNext()) {

			Atraccion atraccion = iterator.next();

			costoTotal = atraccion.getCosto() - descuentoTotal;
		}

		return costoTotal;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getPeriodoVigencia() {
		return periodoVigencia;
	}

	public List<Atraccion> getAtracciones() {
		return this.atracciones;
	}
}
