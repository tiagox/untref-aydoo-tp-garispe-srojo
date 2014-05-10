package untref.aydoo.tp;

import org.junit.Assert;
import org.junit.Test;

public class AtraccionTest {

	@Test
	public void pedirElCostoDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double costo = 100.0;
		Double duracion = 1.0;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion, latitud, longitud);

		Assert.assertEquals(costo, atraccion.getCosto());
	}

	@Test
	public void pedirElCostoDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double costo = 200.0;
		Double duracion = 1.0;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion, latitud, longitud);

		Assert.assertEquals(costo, atraccion.getCosto());
	}

	@Test
	public void pedirElTipoDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double costo = 100.0;
		Double duracion = 1.0;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Atraccion atraccion = new Atraccion(TipoAtraccion.DEGUSTACION, costo,
				duracion, latitud, longitud);

		Assert.assertEquals(TipoAtraccion.DEGUSTACION, atraccion.getTipo());
	}

	@Test
	public void pedirElTipoDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double costo = 100.0;
		Double duracion = 1.0;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion, latitud, longitud);

		Assert.assertEquals(TipoAtraccion.AVENTURA, atraccion.getTipo());
	}

	@Test
	public void pedirLaDuracionDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double costo = 100.0;
		Double duracion = 2.0;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Atraccion atraccion = new Atraccion(TipoAtraccion.DEGUSTACION, costo,
				duracion, latitud, longitud);

		Assert.assertEquals(duracion, atraccion.getDuracion());
	}

	@Test
	public void pedirLaDuracionDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double costo = 100.0;
		Double duracion = 5.0;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion, latitud, longitud);

		Assert.assertEquals(duracion, atraccion.getDuracion());
	}

	@Test
	public void medirLaDistanciaDesdeLaMismaHubicacionDeLaAtraccionDeberiaDevolver0() {
		Double costo = 100.0;
		Double duracion = 5.0;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion, latitud, longitud);

		Double distanciaEsperada = 0.0;

		Assert.assertEquals(distanciaEsperada,
				atraccion.calcularDistanciaA(latitud, longitud));
	}

	@Test
	public void medirLaDistanciaDeberiaDevolverLaDistanciaEnLineaRecta() {
		Double costo = 100.0;
		Double duracion = 5.0;
		Double latitud = -100.0;
		Double longitud = 200.0;
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion, latitud, longitud);

		Double latitudUsuario = 200.0;
		Double longitudUsuario = 600.0;
		Double distanciaEsperada = 500.0;

		Assert.assertEquals(distanciaEsperada,
				atraccion.calcularDistanciaA(latitudUsuario, longitudUsuario));
	}

}
