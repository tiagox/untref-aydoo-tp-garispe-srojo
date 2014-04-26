package untref.aydoo.tp;

import java.util.Iterator;
import java.util.List;

public class PromocionPorcentual {

	private String nombre;
	private List<Atraccion> atracciones;
	private Integer periodoVigencia;

	public PromocionPorcentual(String nombre, Integer periodoVigencia, List<Atraccion> atracciones) {

		this.nombre = nombre;
		this.atracciones = atracciones;
		this.periodoVigencia = periodoVigencia;
	}

	public Double descuento(Double porcentajeDescuento) {

		Double costoTotal = 0.0;

		Iterator<Atraccion> iterator = this.atracciones.iterator();

		while (iterator.hasNext()) {

			Atraccion atraccion = iterator.next();

			costoTotal = atraccion.getCosto()
					- (atraccion.getCosto() * (porcentajeDescuento / 100));
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
