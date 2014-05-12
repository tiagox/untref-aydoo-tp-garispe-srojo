package untref.aydoo.tp;

import java.util.List;

public class Usuario {

	private Double presupuesto;
	private Double tiempoDisponible;
	private Double tiempoMaximoDeViaje;
	private Double velocidadTraslado;
	private Coordenada ubicacion;
	private TipoAtraccion tipoPreferido;

	public Usuario(Double presupuesto, Double tiempoDisponible,
			Double velocidadTraslado, Double tiempoMaximoDeViaje,
			Coordenada ubicacion, TipoAtraccion tipoPreferido) {
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tiempoMaximoDeViaje = tiempoMaximoDeViaje;
		this.velocidadTraslado = velocidadTraslado;
		this.ubicacion = ubicacion;
		this.tipoPreferido = tipoPreferido;
	}

	public Boolean estaBienPrecio(Double precio) {
		return precio <= presupuesto;
	}

	public Boolean estaBienDuracion(Double duracion) {
		return duracion <= tiempoDisponible;
	}

	public Boolean estanBienTiposAtraccion(List<TipoAtraccion> tiposAtraccion) {
		return tiposAtraccion.contains(tipoPreferido);
	}

	public Boolean estanBienUbicaciones(List<Coordenada> ubicaciones) {
		for (Coordenada destino : ubicaciones) {
			if (ubicacion.calcularDistanciaA(destino) <= getDistanciaMaximaDeViaje()) {
				return true;
			}
		}
		return false;
	}

	private Double getDistanciaMaximaDeViaje() {
		return velocidadTraslado * tiempoMaximoDeViaje;
	}

}
