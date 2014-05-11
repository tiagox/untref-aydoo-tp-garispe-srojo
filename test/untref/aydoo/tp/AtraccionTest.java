package untref.aydoo.tp;

import org.junit.Assert;
import org.junit.Test;

public class AtraccionTest {

	@Test
	public void pedirElCostoDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double costo = 100.0;
		Double duracion = 1.0;
		Integer cupoVisitantes = 150;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(costo, atraccion.getCosto());
	}

	@Test
	public void pedirElCostoDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double costo = 200.0;
		Double duracion = 1.0;
		Integer cupoVisitantes = 150;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(costo, atraccion.getCosto());
	}

	@Test
	public void pedirElTipoDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double costo = 100.0;
		Double duracion = 1.0;
		Integer cupoVisitantes = 150;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.DEGUSTACION, costo,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(TipoAtraccion.DEGUSTACION, atraccion.getTipo());
	}

	@Test
	public void pedirElTipoDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double costo = 100.0;
		Double duracion = 1.0;
		Integer cupoVisitantes = 150;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(TipoAtraccion.AVENTURA, atraccion.getTipo());
	}

	@Test
	public void pedirLaDuracionDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double costo = 100.0;
		Double duracion = 2.0;
		Integer cupoVisitantes = 150;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(duracion, atraccion.getDuracion());
	}

	@Test
	public void pedirLaDuracionDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double costo = 100.0;
		Double duracion = 5.0;
		Integer cupoVisitantes = 150;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(duracion, atraccion.getDuracion());
	}

	@Test
	public void pedirElCupoDeVisitantesDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double costo = 100.0;
		Double duracion = 2.0;
		Integer cupoVisitantes = 150;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(cupoVisitantes, atraccion.getCupoVisitantes());
	}

	@Test
	public void pedirElCupoDeVisitantesDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double costo = 100.0;
		Double duracion = 5.0;
		Integer cupoVisitantes = 150;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(cupoVisitantes, atraccion.getCupoVisitantes());
	}

	@Test
	public void pedirLaUbicacionDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double costo = 100.0;
		Double duracion = 2.0;
		Integer cupoVisitantes = 150;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(ubicacion, atraccion.getUbicacion());
	}

	@Test
	public void pedirLaUbicacionDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double costo = 100.0;
		Double duracion = 5.0;
		Integer cupoVisitantes = 150;
		Double latitud = 1100.0;
		Double longitud = 140.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(ubicacion, atraccion.getUbicacion());
	}

}
