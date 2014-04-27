package untref.aydoo.tp.tests;

import org.junit.Assert;
import org.junit.Test;

import untref.aydoo.tp.Atraccion;
import untref.aydoo.tp.TipoAtraccion;

public class AtraccionTest {

	@Test
	public void pedirElCostoDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double costo = 100.0;
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo);

		Assert.assertEquals(costo, atraccion.getCosto());
	}

	@Test
	public void pedirElCostoDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double costo = 200.0;
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo);

		Assert.assertEquals(costo, atraccion.getCosto());
	}

	@Test
	public void pedirElTipoDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double costo = 100.0;
		Atraccion atraccion = new Atraccion(TipoAtraccion.DEGUSTACION, costo);

		Assert.assertEquals(TipoAtraccion.DEGUSTACION, atraccion.getTipo());
	}

	@Test
	public void pedirElTipoDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double costo = 100.0;
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, costo);

		Assert.assertEquals(TipoAtraccion.AVENTURA, atraccion.getTipo());
	}

}
