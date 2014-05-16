package untref.aydoo.tp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

public class PromocionFamiliarTest {

	@Test
	public void elPrecioTotalDeberiaSer26con80DeAcuerdoALasAtraccionesDelPaquete() {

		Atraccion atraccionAventura = new Atraccion(TipoAtraccion.AVENTURA,
				10.0, 4.0, 100, new Coordenada(100.0, 100.0));
		Atraccion atraccionDegustacion = new Atraccion(
				TipoAtraccion.DEGUSTACION, 20.0, 2.0, 50, new Coordenada(200.0,
						200.0));
		
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(atraccionAventura);
		atracciones.add(atraccionDegustacion);

		Date desde = new Date();
		Date hasta = new Date();

		Map<Atraccion, Integer> entradasPorAtraccion = new HashMap<Atraccion, Integer>();
		entradasPorAtraccion.put(atraccionAventura, 2);
		entradasPorAtraccion.put(atraccionDegustacion, 5);

		Promocion promocion = new PromocionFamiliar(atracciones, desde, hasta,
				entradasPorAtraccion);

		Double precioEsperado = 26.8;

		Assert.assertEquals(precioEsperado, promocion.getPrecio());
	}

	@Test
	public void elPrecioDeberiaSerElTotalDeTodasLasAtraccionesPorEntradasMenorA4() {

		Atraccion atraccionAventura = new Atraccion(TipoAtraccion.AVENTURA,
				10.0, 4.0, 100, new Coordenada(100.0, 100.0));
		Atraccion atraccionDegustacion = new Atraccion(
				TipoAtraccion.DEGUSTACION, 20.0, 2.0, 50, new Coordenada(200.0,
						200.0));
		Atraccion atraccionPaisaje = new Atraccion(TipoAtraccion.PAISAJE, 30.0,
				2.0, 50, new Coordenada(200.0, 200.0));

		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(atraccionAventura);
		atracciones.add(atraccionDegustacion);
		atracciones.add(atraccionPaisaje);

		Date desde = new Date();
		Date hasta = new Date();

		Map<Atraccion, Integer> entradasPorAtraccion = new HashMap<Atraccion, Integer>();
		entradasPorAtraccion.put(atraccionAventura, 2);
		entradasPorAtraccion.put(atraccionDegustacion, 2);
		entradasPorAtraccion.put(atraccionPaisaje, 3);

		Promocion promocion = new PromocionFamiliar(atracciones, desde, hasta,
				entradasPorAtraccion);

		Double precioEsperado = 60.0;

		Assert.assertEquals(precioEsperado, promocion.getPrecio());
	}

	@Test
	public void elPrecioTotalDeberiaSer61con60DeAcuerdoALasAtraccionesDelPaquete() {

		Atraccion atraccionAventura = new Atraccion(TipoAtraccion.AVENTURA,
				10.0, 4.0, 100, new Coordenada(100.0, 100.0));
		Atraccion atraccionDegustacion = new Atraccion(
				TipoAtraccion.DEGUSTACION, 20.0, 2.0, 50, new Coordenada(200.0,
						200.0));
		Atraccion atraccionPaisaje = new Atraccion(TipoAtraccion.PAISAJE, 42.0,
				2.0, 50, new Coordenada(200.0, 200.0));

		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(atraccionAventura);
		atracciones.add(atraccionDegustacion);
		atracciones.add(atraccionPaisaje);

		Date desde = new Date();
		Date hasta = new Date();

		Map<Atraccion, Integer> entradasPorAtraccion = new HashMap<Atraccion, Integer>();
		entradasPorAtraccion.put(atraccionAventura, 2);
		entradasPorAtraccion.put(atraccionDegustacion, 4);
		entradasPorAtraccion.put(atraccionPaisaje, 6);

		Promocion promocion = new PromocionFamiliar(atracciones, desde, hasta,
				entradasPorAtraccion);

		Double precioEsperado = 61.6;

		Assert.assertEquals(precioEsperado, promocion.getPrecio());
	}

	
	@Test(expected=Error.class)
	public void deberiaDevolverErrorSiLaListaEstaVaciaSeaCualSeaElPrecioTotal() {

		Atraccion atraccionAventura = new Atraccion(TipoAtraccion.AVENTURA,
				10.0, 4.0, 100, new Coordenada(100.0, 100.0));
		Atraccion atraccionDegustacion = new Atraccion(
				TipoAtraccion.DEGUSTACION, 20.0, 2.0, 50, new Coordenada(200.0,
						200.0));
		Atraccion atraccionPaisaje = new Atraccion(TipoAtraccion.PAISAJE, 42.0,
				2.0, 50, new Coordenada(200.0, 200.0));

		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		
		Date desde = new Date();
		Date hasta = new Date();

		Map<Atraccion, Integer> entradasPorAtraccion = new HashMap<Atraccion, Integer>();
		entradasPorAtraccion.put(atraccionAventura, 2);
		entradasPorAtraccion.put(atraccionDegustacion, 4);
		entradasPorAtraccion.put(atraccionPaisaje, 6);

		Promocion promocion = new PromocionFamiliar(atracciones, desde, hasta,
				entradasPorAtraccion);

		Double precioEsperado = 61.6;

		Assert.assertEquals(precioEsperado, promocion.getPrecio());
	}
}
