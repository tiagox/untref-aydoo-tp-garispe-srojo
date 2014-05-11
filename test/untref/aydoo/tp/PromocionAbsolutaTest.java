package untref.aydoo.tp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PromocionAbsolutaTest {

	@Test
	public void consultarLaVigenciaDeberiaDevolverFalseSiLaFechaEsMayorQueLaFechaHasta() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Calendar calendario = new GregorianCalendar();
		calendario.set(2014, 2, 1); // "2014-03-01"
		Date desde = calendario.getTime();
		calendario.set(2014, 3, 30); // "2014-04-30"
		Date hasta = calendario.getTime();
		Double costo = 100.0;

		calendario.set(2014, 4, 15); // "2014-05-15"
		Date hoy = calendario.getTime();

		Promocion promocion = new PromocionAbsoluta(atracciones, desde, hasta,
				costo);

		Assert.assertFalse(promocion.isVigente(hoy));
	}

	@Test
	public void consultarLaVigenciaDeberiaDevolverFalseSiLaFechaEsMenosQueLaFechaDesde() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Calendar calendario = new GregorianCalendar();
		calendario.set(2013, 2, 1); // "2014-03-01"
		Date desde = calendario.getTime();
		calendario.set(2013, 3, 30); // "2014-04-30"
		Date hasta = calendario.getTime();
		Double costo = 100.0;

		calendario.set(2013, 1, 15); // "2014-02-15"
		Date hoy = calendario.getTime();

		Promocion promocion = new PromocionAbsoluta(atracciones, desde, hasta,
				costo);

		Assert.assertFalse(promocion.isVigente(hoy));
	}

	@Test
	public void consultarLaVigenciaDeberiaDevolverTrueSiLaFechaEstaEntreLasFechasDesdeYHasta() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Calendar calendario = new GregorianCalendar();
		calendario.set(2015, 2, 1); // "2014-03-01"
		Date desde = calendario.getTime();
		calendario.set(2015, 3, 30); // "2014-04-30"
		Date hasta = calendario.getTime();
		Double costo = 100.0;

		calendario.set(2015, 2, 15); // "2014-03-15"
		Date hoy = calendario.getTime();

		Promocion promocion = new PromocionAbsoluta(atracciones, desde, hasta,
				costo);

		Assert.assertTrue(promocion.isVigente(hoy));
	}

	@Test
	public void consultarElPrecioDeLaPromocionDeberiaDevolver100SiElPrecioAsignadoEs100() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Date desde = new Date();
		Date hasta = new Date();
		Double costo = 100.0;

		Promocion promocion = new PromocionAbsoluta(atracciones, desde, hasta,
				costo);

		Assert.assertEquals(costo, promocion.getPrecio(), 0.000001);
	}

	@Test
	public void consultarElPrecioDeLaPromocionDeberiaDevolver200SiElPrecioAsignadoEs200() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Date desde = new Date();
		Date hasta = new Date();
		Double costo = 200.0;

		Promocion promocion = new PromocionAbsoluta(atracciones, desde, hasta,
				costo);

		Assert.assertEquals(costo, promocion.getPrecio(), 0.000001);
	}

	@Test
	public void consultarSiTieneUnTipoDeAtraccionDebeDevolverTrueSiHayAlMenosUnaAtraccionDeEseTipo() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 100.0, 4.0, 100,
				new Coordenada(0.0, 0.0)));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 50.0, 2.0, 70,
				new Coordenada(0.0, 0.0)));

		Date desde = new Date();
		Date hasta = new Date();
		Double costo = 200.0;

		Promocion promocion = new PromocionAbsoluta(atracciones, desde, hasta,
				costo);

		Assert.assertTrue(promocion.hasTipoAtraccion(TipoAtraccion.DEGUSTACION));
	}

	@Test
	public void consultarSiTieneUnTipoDeAtraccionDebeDevolverFalseSiNoHayNingunaAtraccionDeEseTipo() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 100.0, 4.0, 100,
				new Coordenada(0.0, 0.0)));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 50.0, 4.0, 70,
				new Coordenada(0.0, 0.0)));

		Date desde = new Date();
		Date hasta = new Date();
		Double costo = 200.0;

		Promocion promocion = new PromocionAbsoluta(atracciones, desde, hasta,
				costo);

		Assert.assertFalse(promocion.hasTipoAtraccion(TipoAtraccion.PAISAJE));
	}

	@Test
	public void consultarLaDuracionDeberiaDevolverLaSumaDeLaDuracionDeTodasLasAtracciones() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 100.0, 4.0, 100,
				new Coordenada(0.0, 0.0)));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 50.0, 2.0, 70,
				new Coordenada(0.0, 0.0)));
		atracciones.add(new Atraccion(TipoAtraccion.PAISAJE, 50.0, 6.0, 150,
				new Coordenada(0.0, 0.0)));

		Date desde = new Date();
		Date hasta = new Date();
		Double costo = 200.0;

		Double duracionEsperada = 12.0;

		PromocionAbsoluta promocion = new PromocionAbsoluta(atracciones, desde,
				hasta, costo);

		Assert.assertEquals(duracionEsperada, promocion.getDuracion(), 0.000001);
	}

	@Test
	public void consultarLaDuracionDeberiaDevolverLaSumaDeLaDuracionDeTodasLasAtraccionesCualquierSea() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 100.0, 10.0, 200,
				new Coordenada(0.0, 0.0)));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 50.0, 10.0,
				60, new Coordenada(0.0, 0.0)));
		atracciones.add(new Atraccion(TipoAtraccion.PAISAJE, 50.0, 10.0, 150,
				new Coordenada(0.0, 0.0)));

		Date desde = new Date();
		Date hasta = new Date();
		Double costo = 200.0;

		Double duracionEsperada = 30.0;

		PromocionAbsoluta promocion = new PromocionAbsoluta(atracciones, desde,
				hasta, costo);

		Assert.assertEquals(duracionEsperada, promocion.getDuracion(), 0.000001);
	}

	@Test
	public void consultarLaDuracionDeberiaDevolver0SiNoHayAtracciones() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Date desde = new Date();
		Date hasta = new Date();
		Double costo = 200.0;

		Double duracionEsperada = 0.0;

		PromocionAbsoluta promocion = new PromocionAbsoluta(atracciones, desde,
				hasta, costo);

		Assert.assertEquals(duracionEsperada, promocion.getDuracion(), 0.000001);
	}

	@Test
	public void consultarLaDistanciaALaAtraccionMasCercana() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 100.0, 10.0, 200,
				new Coordenada(100.0, 0.0)));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 50.0, 10.0,
				100, new Coordenada(80.0, 0.0)));
		atracciones.add(new Atraccion(TipoAtraccion.PAISAJE, 50.0, 10.0, 100,
				new Coordenada(90.0, 0.0)));

		Date desde = new Date();
		Date hasta = new Date();
		Double costo = 200.0;

		Double latitud = 0.0;
		Double longitud = 0.0;
		Double distanciaEsperada = 80.0;

		PromocionAbsoluta promocion = new PromocionAbsoluta(atracciones, desde,
				hasta, costo);

		Assert.assertEquals(distanciaEsperada,
				promocion.getDistanciaAtraccionMasCercana(latitud, longitud));
	}

	@Test
	public void consultarLaDistanciaALaAtraccionMasCercanaCualquieraSea() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 100.0, 10.0, 400,
				new Coordenada(800.0, 0.0)));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 50.0, 10.0,
				100, new Coordenada(80.0, 0.0)));
		atracciones.add(new Atraccion(TipoAtraccion.PAISAJE, 50.0, 10.0, 200,
				new Coordenada(70.0, 0.0)));

		Date desde = new Date();
		Date hasta = new Date();
		Double costo = 200.0;

		Double latitud = 0.0;
		Double longitud = 0.0;
		Double distanciaEsperada = 70.0;

		PromocionAbsoluta promocion = new PromocionAbsoluta(atracciones, desde,
				hasta, costo);

		Assert.assertEquals(distanciaEsperada,
				promocion.getDistanciaAtraccionMasCercana(latitud, longitud));
	}

	@Test
	public void consultarLaDistanciaALaAtraccionMasCercanaSiNoHayAtraccionesDebeDevolverMenos1() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Date desde = new Date();
		Date hasta = new Date();
		Double costo = 200.0;

		Double latitud = 0.0;
		Double longitud = 0.0;
		Double distanciaEsperada = -1.0;

		PromocionAbsoluta promocion = new PromocionAbsoluta(atracciones, desde,
				hasta, costo);

		Assert.assertEquals(distanciaEsperada,
				promocion.getDistanciaAtraccionMasCercana(latitud, longitud));
	}

}
