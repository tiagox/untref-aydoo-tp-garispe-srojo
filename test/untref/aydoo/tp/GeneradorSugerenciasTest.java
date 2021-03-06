package untref.aydoo.tp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GeneradorSugerenciasTest {

	private Usuario usuario;

	private Promocion promocionAbsolutaVigente;
	private Promocion promocionPorcentualVigente;
	private Promocion promocionAxBNoVigente;
	private Promocion promocionAbsolutaVigenteBarata;
	private Promocion promocionPorcentualVigenteBarata2;
	private Promocion promocionPorcentualVigenteBarata;

	private List<Sugerible> promocionesDisponibles;

	private Date diaDeVisita;

	/* Atributo auxiliar para crear fechas. */
	private Calendar calendario = new GregorianCalendar();

	@Before
	public void setUpPromocionesDisponibles() {

		Atraccion atraccionDeAventura = new Atraccion(TipoAtraccion.AVENTURA, 100.0, 8.0, 200, new Coordenada(10.0, 0.0));
		Atraccion atraccionDeDegustacion = new Atraccion(TipoAtraccion.DEGUSTACION, 50.0, 2.0, 50, new Coordenada(100.0, 100.0));
		Atraccion atraccionDePaisaje = new Atraccion(TipoAtraccion.PAISAJE, 100.0, 4.0, 150, new Coordenada(-100.0, 100.0));
		Atraccion atraccionDeAventuraCara = new Atraccion(TipoAtraccion.AVENTURA, 500.0, 24.0, 170, new Coordenada(100.0, -100.0));
		Atraccion atraccionDePaisajeCara = new Atraccion(TipoAtraccion.PAISAJE, 400.0, 5.0, 100, new Coordenada(200.0, 100.0));
		Atraccion atraccionDeAventura2 = new Atraccion(TipoAtraccion.AVENTURA, 100.0, 8.0, 90, new Coordenada(100.0, 100.0));

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
		this.promocionAbsolutaVigente = new PromocionAbsoluta(atraccionesPromocionAbsoluta, desde, hasta, precio);

		// Promoción Absoluta Barata.
		List<Atraccion> atraccionesPromocionAbsolutaBarata = new ArrayList<Atraccion>();
		atraccionesPromocionAbsoluta.add(atraccionDeDegustacion);
		atraccionesPromocionAbsoluta.add(atraccionDeAventuraCara);

		precio = 280.0;
		this.promocionAbsolutaVigenteBarata = new PromocionAbsoluta(atraccionesPromocionAbsolutaBarata, desde, hasta, precio);

		// Promoción Porcentual Común.
		List<Atraccion> atraccionesPromocionPorcentual = new ArrayList<Atraccion>();
		atraccionesPromocionPorcentual.add(atraccionDeAventura);
		atraccionesPromocionPorcentual.add(atraccionDeDegustacion);
		atraccionesPromocionPorcentual.add(atraccionDePaisaje);

		Double descuento = 40.0;
		this.promocionPorcentualVigente = new PromocionPorcentual(atraccionesPromocionPorcentual, desde, hasta, descuento);

		// Promoción Porcentual Barata.
		List<Atraccion> atraccionesPromocionPorcentualBarata = new ArrayList<Atraccion>();
		atraccionesPromocionPorcentualBarata.add(atraccionDeAventura);
		atraccionesPromocionPorcentualBarata.add(atraccionDeDegustacion);
		atraccionesPromocionPorcentualBarata.add(atraccionDePaisaje);
		atraccionesPromocionPorcentualBarata.add(atraccionDePaisajeCara);

		descuento = 80.0;
		this.promocionPorcentualVigenteBarata = new PromocionPorcentual(atraccionesPromocionPorcentualBarata, desde, hasta, descuento);

		// Promoción Porcentual Barata 2.
		List<Atraccion> atraccionesPromocionPorcentualVigenteBarata2 = new ArrayList<Atraccion>();
		atraccionesPromocionPorcentualVigenteBarata2.add(atraccionDeAventura2);

		descuento = 80.0;
		this.promocionPorcentualVigenteBarata2 = new PromocionPorcentual(atraccionesPromocionPorcentualVigenteBarata2, desde, hasta, descuento);

		// Promoción AxB Común No vigente.
		Double costoAtraccionGratis = 100.0;
		Atraccion atraccionGratis = new Atraccion(TipoAtraccion.PAISAJE, costoAtraccionGratis, 3.0, 100, new Coordenada(50.0, 50.0));

		this.calendario.set(2014, 4, 1); // "2014-05-01"
		desde = this.calendario.getTime();
		this.calendario.set(2014, 5, 30); // "2014-06-30"
		hasta = this.calendario.getTime();

		List<Atraccion> atraccionesPromocionAxB = new ArrayList<Atraccion>();
		atraccionesPromocionAxB.add(atraccionDeAventura);
		atraccionesPromocionAxB.add(atraccionDeDegustacion);
		atraccionesPromocionAxB.add(atraccionDePaisaje);

		this.promocionAxBNoVigente = new PromocionAxB(atraccionesPromocionAxB, desde, hasta, atraccionGratis);

		// Lista completa de promociones disponibles.
		promocionesDisponibles = new ArrayList<Sugerible>();
		promocionesDisponibles.add(promocionAbsolutaVigente);
		promocionesDisponibles.add(promocionPorcentualVigente);
		promocionesDisponibles.add(promocionAxBNoVigente);
		promocionesDisponibles.add(promocionAbsolutaVigenteBarata);
		promocionesDisponibles.add(promocionPorcentualVigenteBarata);
		promocionesDisponibles.add(promocionPorcentualVigenteBarata2);
	}

	@Before
	public void setUpUsuario() {
		Double presupuesto = 300.0;
		Double tiempoDisponible = 15.0;
		Double tiempoMaximoDeViaje = 1.0;
		Double velocidadTraslado = 40.0;
		Double latitud = 25.0;
		Double longitud = 25.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);

		usuario = new Usuario(presupuesto, tiempoDisponible, tiempoMaximoDeViaje, velocidadTraslado, ubicacion, TipoAtraccion.AVENTURA);
	}

	@Before
	public void setUpDiaDeVisita() {
		this.calendario.set(2014, 2, 15); // "2014-03-15"
		diaDeVisita = this.calendario.getTime();
	}

	@Test
	public void debeSugerirSoloPromocionesVigentes() {
		GeneradorSugerencias generadorSugerencias = new GeneradorSugerencias(promocionesDisponibles);

		List<Sugerible> sugerencias = generadorSugerencias.getSugerencias(usuario, diaDeVisita);

		for (Sugerible sugerencia : sugerencias) {
			Assert.assertTrue(sugerencia.isVigente(diaDeVisita));
		}
	}

	@Test
	public void debeSugerirSoloPromocionesQueNoSuperenElPresupuestoDelUsuario() {
		GeneradorSugerencias generadorSugerencias = new GeneradorSugerencias(promocionesDisponibles);

		List<Sugerible> sugerencias = generadorSugerencias.getSugerencias(usuario, diaDeVisita);

		for (Sugerible sugerencia : sugerencias) {
			Assert.assertTrue(usuario.estaBienPrecio(sugerencia.getPrecio()));
		}
	}

	@Test
	public void debeSugerirSoloPromocionesQueTenganAtraccionesDelTipoQueElUsuarioPrefiere() {
		GeneradorSugerencias generadorSugerencias = new GeneradorSugerencias(promocionesDisponibles);

		List<Sugerible> sugerencias = generadorSugerencias.getSugerencias(usuario, diaDeVisita);

		for (Sugerible sugerencia : sugerencias) {
			Assert.assertTrue(usuario.estanBienTiposAtraccion(sugerencia.getListaTiposAtraccion()));
		}
	}

	@Test
	public void debeSugerirSoloPromocionesQueTenganUnaDuracionMenorALaQueElUsuarioTieneDisponible() {
		GeneradorSugerencias generadorSugerencias = new GeneradorSugerencias(promocionesDisponibles);

		List<Sugerible> sugerencias = generadorSugerencias.getSugerencias(usuario, diaDeVisita);

		for (Sugerible sugerencia : sugerencias) {
			Assert.assertTrue(usuario.estaBienDuracion(sugerencia.getDuracion()));
		}
	}

	@Test
	public void debeSugerirSoloPromocionesCuyaAtraccionMasCercaQueEstenAMenosDeUnaHoraDeViaje() {
		GeneradorSugerencias generadorSugerencias = new GeneradorSugerencias(
				promocionesDisponibles);

		List<Sugerible> sugerencias = generadorSugerencias.getSugerencias(usuario, diaDeVisita);

		for (Sugerible sugerencia : sugerencias) {
			Assert.assertTrue(usuario.estanBienUbicaciones(sugerencia.getListaUbicaciones()));
		}
	}
}
