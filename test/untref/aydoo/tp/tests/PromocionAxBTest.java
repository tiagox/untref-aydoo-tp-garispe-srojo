package untref.aydoo.tp.tests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import untref.aydoo.tp.Atraccion;
import untref.aydoo.tp.PromocionAxB;
import untref.aydoo.tp.TipoAtraccion;

public class PromocionAxBTest {

	@Test
	public void consultarLaVigenciaDeberiaDevolverFalseSiLaFechaEsMayorQueLaFechaHasta() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Calendar calendario = new GregorianCalendar();
		calendario.set(2014, 2, 1); // "2014-03-01"
		Date desde = calendario.getTime();
		calendario.set(2014, 3, 30); // "2014-04-30"
		Date hasta = calendario.getTime();

		Double costoAtraccionGratis = 100.0;
		Double duracion = 6.0;
		Double latitud = 0.0;
		Double longitud = 0.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.PAISAJE,
				costoAtraccionGratis, duracion, latitud, longitud);

		calendario.set(2014, 4, 15); // "2014-05-15"
		Date hoy = calendario.getTime();

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta,
				atraccionGratis);

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

		Double costoAtraccionGratis = 100.0;
		Double duracion = 6.0;
		Double latitud = 0.0;
		Double longitud = 0.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.PAISAJE,
				costoAtraccionGratis, duracion, latitud, longitud);

		calendario.set(2013, 1, 15); // "2014-02-15"
		Date hoy = calendario.getTime();

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta,
				atraccionGratis);

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

		Double costoAtraccionGratis = 100.0;
		Double duracion = 6.0;
		Double latitud = 0.0;
		Double longitud = 0.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.PAISAJE,
				costoAtraccionGratis, duracion, latitud, longitud);

		calendario.set(2015, 2, 15); // "2014-03-15"
		Date hoy = calendario.getTime();

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta,
				atraccionGratis);

		Assert.assertTrue(promocion.isVigente(hoy));
	}

	@Test
	public void consultarElPrecioDeLaPromocionDeberiaDevolverElTotalDeLasAtraccionesQueFueronAgregadas() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Double precioAtraccion = 100.0;
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, precioAtraccion,
				6.0, 0.0, 0.0));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION,
				precioAtraccion, 2.0, 0.0, 0.0));
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, precioAtraccion,
				8.0, 0.0, 0.0));
		Date desde = new Date();
		Date hasta = new Date();

		Double costoAtraccionGratis = 100.0;
		Double duracion = 6.0;
		Double latitud = 0.0;
		Double longitud = 0.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.PAISAJE,
				costoAtraccionGratis, duracion, latitud, longitud);

		Double precioEsperado = 300.0;

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta,
				atraccionGratis);

		Assert.assertEquals(precioEsperado, promocion.getPrecio(), 0.000001);
	}

	@Test
	public void consultarElPrecioDeLaPromocionDeberiaDevolver0NoHayAtraccionesEnLaPromocion() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Date desde = new Date();
		Date hasta = new Date();

		Double costoAtraccionGratis = 100.0;
		Double duracion = 6.0;
		Double latitud = 0.0;
		Double longitud = 0.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.PAISAJE,
				costoAtraccionGratis, duracion, latitud, longitud);

		Double precioEsperado = 0.0;

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta,
				atraccionGratis);

		Assert.assertEquals(precioEsperado, promocion.getPrecio(), 0.000001);
	}

	@Test
	public void consultarElPrecioDeLaPromocionDeberiaDevolver100SiHaySoloUnaAtraccionQueCuesta100() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Double precioAtraccion = 100.0;
		atracciones.add(new Atraccion(TipoAtraccion.PAISAJE, precioAtraccion,
				3.0, 0.0, 0.0));
		Date desde = new Date();
		Date hasta = new Date();

		Double costoAtraccionGratis = 100.0;
		Double duracion = 6.0;
		Double latitud = 0.0;
		Double longitud = 0.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.PAISAJE,
				costoAtraccionGratis, duracion, latitud, longitud);

		Double precioEsperado = 100.0;

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta,
				atraccionGratis);

		Assert.assertEquals(precioEsperado, promocion.getPrecio(), 0.000001);
	}

	@Test
	public void consultarSiTieneUnTipoDeAtraccionDebeDevolverTrueSiHayAlMenosUnaAtraccionDeEseTipo() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 100.0, 5.0, 0.0,
				0.0));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 50.0, 1.0,
				0.0, 0.0));

		Date desde = new Date();
		Date hasta = new Date();

		Double costoAtraccionGratis = 100.0;
		Double duracion = 6.0;
		Double latitud = 0.0;
		Double longitud = 0.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.AVENTURA,
				costoAtraccionGratis, duracion, latitud, longitud);

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta,
				atraccionGratis);

		Assert.assertTrue(promocion.hasTipoAtraccion(TipoAtraccion.DEGUSTACION));
	}

	@Test
	public void consultarSiTieneUnTipoDeAtraccionDebeDevolverTrueSiHayAlMenosUnaAtraccionDeEseTipoInclusoLaAtraccionGratis() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 100.0, 1.0,
				0.0, 0.0));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 50.0, 2.0,
				0.0, 0.0));

		Date desde = new Date();
		Date hasta = new Date();

		Double costoAtraccionGratis = 100.0;
		Double duracion = 6.0;
		Double latitud = 0.0;
		Double longitud = 0.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.AVENTURA,
				costoAtraccionGratis, duracion, latitud, longitud);

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta,
				atraccionGratis);

		Assert.assertTrue(promocion.hasTipoAtraccion(TipoAtraccion.AVENTURA));
	}

	@Test
	public void consultarSiTieneUnTipoDeAtraccionDebeDevolverFalseSiNoHayNingunaAtraccionDeEseTipo() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 100.0, 8.0, 0.0,
				0.0));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 50.0, 3.0,
				0.0, 0.0));

		Date desde = new Date();
		Date hasta = new Date();

		Double costoAtraccionGratis = 100.0;
		Double duracion = 6.0;
		Double latitud = 0.0;
		Double longitud = 0.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.AVENTURA,
				costoAtraccionGratis, duracion, latitud, longitud);

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta,
				atraccionGratis);

		Assert.assertFalse(promocion.hasTipoAtraccion(TipoAtraccion.PAISAJE));
	}

	@Test
	public void consultarLaDuracionDeberiaDevolverLaSumaDeLaDuracionDeTodasLasAtraccionesInclusoLaGratuita() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 100.0, 4.0, 0.0,
				0.0));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 50.0, 2.0,
				0.0, 0.0));
		atracciones.add(new Atraccion(TipoAtraccion.PAISAJE, 50.0, 6.0, 0.0,
				0.0));

		Date desde = new Date();
		Date hasta = new Date();

		Double costoAtraccionGratis = 100.0;
		Double duracion = 6.0;
		Double latitud = 0.0;
		Double longitud = 0.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.AVENTURA,
				costoAtraccionGratis, duracion, latitud, longitud);

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta,
				atraccionGratis);

		Double duracionEsperada = 18.0;

		Assert.assertEquals(duracionEsperada, promocion.getDuracion(), 0.000001);
	}

	@Test
	public void consultarLaDuracionDeberiaDevolverLaSumaDeLaDuracionDeTodasLasAtraccionesCualquierSeaInclusoLaGratuita() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 100.0, 10.0, 0.0,
				0.0));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 50.0, 10.0,
				0.0, 0.0));
		atracciones.add(new Atraccion(TipoAtraccion.PAISAJE, 50.0, 10.0, 0.0,
				0.0));

		Date desde = new Date();
		Date hasta = new Date();

		Double costoAtraccionGratis = 100.0;
		Double duracion = 6.0;
		Double latitud = 0.0;
		Double longitud = 0.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.AVENTURA,
				costoAtraccionGratis, duracion, latitud, longitud);

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta,
				atraccionGratis);

		Double duracionEsperada = 36.0;

		Assert.assertEquals(duracionEsperada, promocion.getDuracion(), 0.000001);
	}

	@Test
	public void consultarLaDuracionDeberiaDevolver0SiNoHayAtraccionesInclusoLaGratuita() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Date desde = new Date();
		Date hasta = new Date();

		Double costoAtraccionGratis = 100.0;
		Double duracion = 0.0;
		Double latitud = 0.0;
		Double longitud = 0.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.AVENTURA, costoAtraccionGratis, duracion, latitud, longitud);

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta, atraccionGratis);

		Double duracionEsperada = 0.0;

		Assert.assertEquals(duracionEsperada, promocion.getDuracion(), 0.000001);
	}

	@Test
	public void consultarLaDistanciaALaAtraccionMasCercana() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 100.0, 10.0, 100.0, 0.0));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 50.0, 10.0, 80.0, 0.0));
		atracciones.add(new Atraccion(TipoAtraccion.PAISAJE, 50.0, 10.0, 90.0, 0.0));

		Date desde = new Date();
		Date hasta = new Date();

		Double costoAtraccionGratis = 100.0;
		Double duracion = 0.0;
		Double latitud = 110.0;
		Double longitud = 0.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.AVENTURA, costoAtraccionGratis, duracion, latitud, longitud);

		Double latitudUsuario = 0.0;
		Double longitudUsuario = 0.0;
		Double distanciaEsperada = 80.0;

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta, atraccionGratis);

		Assert.assertEquals(distanciaEsperada, promocion.getDistanciaAtraccionMasCercana(latitudUsuario, longitudUsuario));
	}


	@Test
	public void consultarLaDistanciaALaAtraccionMasCercanaIncluyendoLaGratuita() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 100.0, 10.0, 100.0, 0.0));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 50.0, 10.0, 80.0, 0.0));
		atracciones.add(new Atraccion(TipoAtraccion.PAISAJE, 50.0, 10.0, 90.0, 0.0));

		Date desde = new Date();
		Date hasta = new Date();

		Double costoAtraccionGratis = 100.0;
		Double duracion = 0.0;
		Double latitud = 70.0;
		Double longitud = 0.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.AVENTURA, costoAtraccionGratis, duracion, latitud, longitud);

		Double latitudUsuario = 0.0;
		Double longitudUsuario = 0.0;
		Double distanciaEsperada = 70.0;

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta, atraccionGratis);

		Assert.assertEquals(distanciaEsperada, promocion.getDistanciaAtraccionMasCercana(latitudUsuario, longitudUsuario));
	}

	@Test
	public void consultarLaDistanciaALaAtraccionMasCercanaCualquieraSea() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 100.0, 10.0, 800.0, 0.0));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 50.0, 10.0, 80.0, 0.0));
		atracciones.add(new Atraccion(TipoAtraccion.PAISAJE, 50.0, 10.0, 70.0, 0.0));

		Date desde = new Date();
		Date hasta = new Date();

		Double costoAtraccionGratis = 100.0;
		Double duracion = 0.0;
		Double latitud = 110.0;
		Double longitud = 0.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.AVENTURA, costoAtraccionGratis, duracion, latitud, longitud);

		Double latitudUsuario = 0.0;
		Double longitudUsuario = 0.0;
		Double distanciaEsperada = 70.0;

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta, atraccionGratis);

		Assert.assertEquals(distanciaEsperada, promocion.getDistanciaAtraccionMasCercana(latitudUsuario, longitudUsuario));
	}

	@Test
	public void consultarLaDistanciaALaAtraccionMasCercanaSiNoHayAtraccionesDebeDevolverLaDistanciaALaGratuita() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Date desde = new Date();
		Date hasta = new Date();

		Double costoAtraccionGratis = 100.0;
		Double duracion = 0.0;
		Double latitud = 110.0;
		Double longitud = 0.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.AVENTURA, costoAtraccionGratis, duracion, latitud, longitud);

		Double latitudUsuario = 0.0;
		Double longitudUsuario = 0.0;
		Double distanciaEsperada = 110.0;

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta, atraccionGratis);

		Assert.assertEquals(distanciaEsperada, promocion.getDistanciaAtraccionMasCercana(latitudUsuario, longitudUsuario));
	}

}
