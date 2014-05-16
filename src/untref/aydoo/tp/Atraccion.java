package untref.aydoo.tp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Atraccion implements Sugerible {

	private TipoAtraccion tipo;
	private Double precio;
	private Double duracion;
	private Integer cupoVisitantes;
	private Coordenada ubicacion;

	public Atraccion(TipoAtraccion tipo, Double precio, Double duracion,
			Integer cupoVisitantes, Coordenada ubicacion) {
		this.tipo = tipo;
		this.precio = precio;
		this.duracion = duracion;
		this.cupoVisitantes = cupoVisitantes;
		this.ubicacion = ubicacion;
	}

	public TipoAtraccion getTipo() {
		return this.tipo;
	}

	@Override
	public Double getPrecio() {
		return this.precio;
	}

	@Override
	public Double getDuracion() {
		return this.duracion;
	}

	public Integer getCupoVisitantes() {
		return this.cupoVisitantes;
	}

	public Coordenada getUbicacion() {
		return this.ubicacion;
	}

	@Override
	public Boolean isVigente(Date dia) {
		return true;
	}

	@Override
	public List<TipoAtraccion> getListaTiposAtraccion() {
		List<TipoAtraccion> listaTipoAtraccion = new ArrayList<TipoAtraccion>();
		listaTipoAtraccion.add(tipo);
		return listaTipoAtraccion;
	}

	@Override
	public List<Coordenada> getListaUbicaciones() {
		List<Coordenada> listaUbicaciones = new ArrayList<Coordenada>();
		listaUbicaciones.add(ubicacion);
		return listaUbicaciones;
	}

}
