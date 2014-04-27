package untref.aydoo.tp.tests;

import org.junit.Assert;
import org.junit.Test;

import untref.aydoo.tp.Atraccion;
import untref.aydoo.tp.TipoAtraccion;

public class AtraccionTest {

	@Test
	public void pedirElCostoDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double costo = 100.0;
		Double duracion = 1.0;
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion);

		Assert.assertEquals(costo, atraccion.getCosto());
	}

	@Test
	public void pedirElCostoDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double costo = 200.0;
		Double duracion = 1.0;
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion);

		Assert.assertEquals(costo, atraccion.getCosto());
	}

	@Test
	public void pedirElTipoDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double costo = 100.0;
		Double duracion = 1.0;
		Atraccion atraccion = new Atraccion(TipoAtraccion.DEGUSTACION, costo,
				duracion);

		Assert.assertEquals(TipoAtraccion.DEGUSTACION, atraccion.getTipo());
	}

	@Test
	public void pedirElTipoDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double costo = 100.0;
		Double duracion = 1.0;
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion);

		Assert.assertEquals(TipoAtraccion.AVENTURA, atraccion.getTipo());
	}

	@Test
	public void pedirLaDuracionDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double costo = 100.0;
		Double duracion = 2.0;
		Atraccion atraccion = new Atraccion(TipoAtraccion.DEGUSTACION, costo,
				duracion);

		Assert.assertEquals(duracion, atraccion.getDuracion());
	}

	@Test
	public void pedirLaDuracionDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double costo = 100.0;
		Double duracion = 5.0;
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo,
				duracion);

		Assert.assertEquals(duracion, atraccion.getDuracion());
	}

}
