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
	public void preguntarPorLaVigenciaDeveriaDevolverFalseSiLaFechaEsMayorQueLaFechaHasta() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Calendar calendario = new GregorianCalendar();
		calendario.set(2014, 2, 1); // "2014-03-01"
		Date desde = calendario.getTime();
		calendario.set(2014, 3, 30); // "2014-04-30"
		Date hasta = calendario.getTime();

		Double costoAtraccionGratis = 100.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.PAISAJE,
				costoAtraccionGratis);

		calendario.set(2014, 4, 15); // "2014-05-15"
		Date hoy = calendario.getTime();

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta,
				atraccionGratis);

		Assert.assertFalse(promocion.isVigente(hoy));
	}

	@Test
	public void preguntarPorLaVigenciaDeveriaDevolverFalseSiLaFechaEsMenosQueLaFechaDesde() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Calendar calendario = new GregorianCalendar();
		calendario.set(2013, 2, 1); // "2014-03-01"
		Date desde = calendario.getTime();
		calendario.set(2013, 3, 30); // "2014-04-30"
		Date hasta = calendario.getTime();

		Double costoAtraccionGratis = 100.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.PAISAJE,
				costoAtraccionGratis);

		calendario.set(2013, 1, 15); // "2014-02-15"
		Date hoy = calendario.getTime();

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta,
				atraccionGratis);

		Assert.assertFalse(promocion.isVigente(hoy));
	}

	@Test
	public void preguntarPorLaVigenciaDeveriaDevolverTrueSiLaFechaEstaEntreLasFechasDesdeYHasta() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Calendar calendario = new GregorianCalendar();
		calendario.set(2015, 2, 1); // "2014-03-01"
		Date desde = calendario.getTime();
		calendario.set(2015, 3, 30); // "2014-04-30"
		Date hasta = calendario.getTime();

		Double costoAtraccionGratis = 100.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.PAISAJE,
				costoAtraccionGratis);

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
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, precioAtraccion));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION,
				precioAtraccion));
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, precioAtraccion));
		Date desde = new Date();
		Date hasta = new Date();

		Double costoAtraccionGratis = 100.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.PAISAJE,
				costoAtraccionGratis);

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
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.PAISAJE,
				costoAtraccionGratis);

		Double precioEsperado = 0.0;

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta,
				atraccionGratis);

		Assert.assertEquals(precioEsperado, promocion.getPrecio(), 0.000001);
	}

	@Test
	public void consultarElPrecioDeLaPromocionDeberiaDevolver100SiHaySoloUnaAtraccionQueCuesta100() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Double precioAtraccion = 100.0;
		atracciones.add(new Atraccion(TipoAtraccion.PAISAJE, precioAtraccion));
		Date desde = new Date();
		Date hasta = new Date();

		Double costoAtraccionGratis = 100.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.PAISAJE,
				costoAtraccionGratis);

		Double precioEsperado = 100.0;

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta,
				atraccionGratis);

		Assert.assertEquals(precioEsperado, promocion.getPrecio(), 0.000001);
	}

	@Test
	public void consultarSiTieneUnTipoDeAtraccionDebeDevolverTrueSiHayAlMenosUnaAtraccionDeEseTipo() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 100.0));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 50.0));

		Date desde = new Date();
		Date hasta = new Date();

		Double costoAtraccionGratis = 100.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.AVENTURA,
				costoAtraccionGratis);

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta,
				atraccionGratis);

		Assert.assertTrue(promocion.hasTipoAtraccion(TipoAtraccion.DEGUSTACION));
	}

	@Test
	public void consultarSiTieneUnTipoDeAtraccionDebeDevolverTrueSiHayAlMenosUnaAtraccionDeEseTipoInclusoLaAtraccionGratis() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 100.0));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 50.0));

		Date desde = new Date();
		Date hasta = new Date();

		Double costoAtraccionGratis = 100.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.AVENTURA,
				costoAtraccionGratis);

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta,
				atraccionGratis);

		Assert.assertTrue(promocion.hasTipoAtraccion(TipoAtraccion.AVENTURA));
	}

	@Test
	public void consultarSiTieneUnTipoDeAtraccionDebeDevolverFalseSiNoHayNingunaAtraccionDeEseTipo() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 100.0));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 50.0));

		Date desde = new Date();
		Date hasta = new Date();

		Double costoAtraccionGratis = 100.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.AVENTURA,
				costoAtraccionGratis);

		PromocionAxB promocion = new PromocionAxB(atracciones, desde, hasta,
				atraccionGratis);

		Assert.assertFalse(promocion.hasTipoAtraccion(TipoAtraccion.PAISAJE));
	}

}
