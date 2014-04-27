package untref.aydoo.tp.tests;

import org.junit.Assert;
import org.junit.Test;

import untref.aydoo.tp.Atraccion;

public class AtraccionTest {

	@Test
	public void pedirElCostoDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double costo = 100.0;
		Atraccion atraccion = new Atraccion(costo);

		Assert.assertEquals(costo, atraccion.getCosto());
	}

	@Test
	public void pedirElCostoDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double costo = 200.0;
		Atraccion atraccion = new Atraccion(costo);

		Assert.assertEquals(costo, atraccion.getCosto());
	}

}
