package untref.aydoo.tp.tests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tp.Atraccion;
import untref.aydoo.tp.GeneradorSugerencias;
import untref.aydoo.tp.Promocion;
import untref.aydoo.tp.PromocionAbsoluta;
import untref.aydoo.tp.PromocionAxB;
import untref.aydoo.tp.PromocionPorcentual;
import untref.aydoo.tp.TipoAtraccion;
import untref.aydoo.tp.Usuario;

public class GeneradorSugerenciasTest {

	private Usuario usuario;

	private Promocion promocionAbsolutaVigente;
	private Promocion promocionPorcentualVigente;
	private Promocion promocionAxBNoVigente;
	private Promocion promocionAbsolutaVigenteBarata;

	private List<Promocion> promocionesDisponibles;

	private Date diaDeVisita;

	/* Atributo auxiliar para crear fechas. */
	private Calendar calendario = new GregorianCalendar();

	@Before
	public void setUpPromocionesDisponibles() {

		Atraccion atraccionDeAventura = new Atraccion(TipoAtraccion.AVENTURA,
				100.0);
		Atraccion atraccionDeDegustacion = new Atraccion(
				TipoAtraccion.DEGUSTACION, 50.0);
		Atraccion atraccionDePaisaje = new Atraccion(TipoAtraccion.PAISAJE,
				100.0);
		Atraccion atraccionDeAventuraCara = new Atraccion(
				TipoAtraccion.AVENTURA, 500.0);
		// Atraccion atraccionDeDegustacionCara = new Atraccion(
		// TipoAtraccion.DEGUSTACION, 700.0);
		Atraccion atraccionDePaisajeCara = new Atraccion(TipoAtraccion.PAISAJE,
				400.0);

		this.calendario.set(2014, 2, 1); // "2014-03-01"
		Date desde = this.calendario.getTime();
		this.calendario.set(2014, 3, 30); // "2014-04-30"
		Date hasta = this.calendario.getTime();

		// Promoción Absoluta Común
		List<Atraccion> atraccionesPromocionAbsoluta = new ArrayList<Atraccion>();
		atraccionesPromocionAbsoluta.add(atraccionDeAventura);
		atraccionesPromocionAbsoluta.add(atraccionDeDegustacion);
		atraccionesPromocionAbsoluta.add(atraccionDePaisaje);
		atraccionesPromocionAbsoluta.add(atraccionDePaisajeCara);

		Double precio = 450.0;
		this.promocionAbsolutaVigente = new PromocionAbsoluta(
				atraccionesPromocionAbsoluta, desde, hasta, precio);

		// Promoción Absoluta Barata.
		List<Atraccion> atraccionesPromocionAbsolutaBarata = new ArrayList<Atraccion>();
		atraccionesPromocionAbsoluta.add(atraccionDeDegustacion);
		atraccionesPromocionAbsoluta.add(atraccionDeAventuraCara);

		precio = 280.0;
		this.promocionAbsolutaVigenteBarata = new PromocionAbsoluta(
				atraccionesPromocionAbsolutaBarata, desde, hasta, precio);

		// Promoción Porcentual Común.
		List<Atraccion> atraccionesPromocionPorcentual = new ArrayList<Atraccion>();
		atraccionesPromocionPorcentual.add(atraccionDeAventura);
		atraccionesPromocionPorcentual.add(atraccionDeDegustacion);
		atraccionesPromocionPorcentual.add(atraccionDePaisaje);

		Double descuento = 40.0;
		this.promocionPorcentualVigente = new PromocionPorcentual(
				atraccionesPromocionPorcentual, desde, hasta, descuento);

		// Promoción AxB Común No vigente.
		Double costoAtraccionGratis = 100.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.PAISAJE,
				costoAtraccionGratis);

		this.calendario.set(2014, 4, 1); // "2014-05-01"
		desde = this.calendario.getTime();
		this.calendario.set(2014, 5, 30); // "2014-06-30"
		hasta = this.calendario.getTime();

		List<Atraccion> atraccionesPromocionAxB = new ArrayList<Atraccion>();
		atraccionesPromocionAxB.add(atraccionDeAventura);
		atraccionesPromocionAxB.add(atraccionDeDegustacion);
		atraccionesPromocionAxB.add(atraccionDePaisaje);

		this.promocionAxBNoVigente = new PromocionAxB(atraccionesPromocionAxB,
				desde, hasta, atraccionGratis);

		// Lista completa de promociones disponibles.
		this.promocionesDisponibles = new ArrayList<Promocion>();
		this.promocionesDisponibles.add(promocionAbsolutaVigente);
		this.promocionesDisponibles.add(promocionPorcentualVigente);
		this.promocionesDisponibles.add(promocionAxBNoVigente);
		this.promocionesDisponibles.add(promocionAbsolutaVigenteBarata);
	}

	@Before
	public void setUpUsuario() {
		Double presupuesto = 300.0;
		Double tiempoDisponible = 72.0;
		Double velocidadTraslado = 40.0;

		this.usuario = new Usuario(presupuesto, tiempoDisponible,
				velocidadTraslado, TipoAtraccion.AVENTURA);
	}

	@Before
	public void setUpDiaDeVisita() {
		this.calendario.set(2014, 2, 15); // "2014-03-15"
		this.diaDeVisita = this.calendario.getTime();
	}

	@Test
	public void debeSugerirSoloPromocionesVigentes() {
		GeneradorSugerencias generadorSugerencias = new GeneradorSugerencias(
				this.promocionesDisponibles);

		List<Promocion> sugerencias = generadorSugerencias.getSugerencias(
				this.usuario, this.diaDeVisita);

		for (Promocion promocion : sugerencias) {
			Assert.assertTrue(promocion.isVigente(this.diaDeVisita));
		}
	}

	@Test
	public void debeSugerirSoloPromocionesQueNoSuperenElPresupuestoDelUsuario() {
		GeneradorSugerencias generadorSugerencias = new GeneradorSugerencias(
				this.promocionesDisponibles);

		List<Promocion> sugerencias = generadorSugerencias.getSugerencias(
				this.usuario, this.diaDeVisita);

		for (Promocion promocion : sugerencias) {
			Assert.assertTrue(promocion.getPrecio() < this.usuario
					.getPresupuesto());
		}
	}

	@Test
	public void debeSugerirSoloPromocionesQueTenganAtraccionesDelTipoQueElUsuarioPrefiere() {
		GeneradorSugerencias generadorSugerencias = new GeneradorSugerencias(
				this.promocionesDisponibles);

		List<Promocion> sugerencias = generadorSugerencias.getSugerencias(
				this.usuario, this.diaDeVisita);

		for (Promocion promocion : sugerencias) {
			Assert.assertTrue(promocion.hasTipoAtraccion(this.usuario
					.getTipoPreferido()));
		}
	}

}