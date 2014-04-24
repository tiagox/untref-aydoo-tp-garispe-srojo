package untref.aydoo.tp.tests;

import org.junit.Assert;
import org.junit.Test;

import untref.aydoo.tp.Atraccion;
import untref.aydoo.tp.TipoAtraccion;

public class AtraccionTest {

	@Test
	public void instanciarUnObjetoDeberiaAceptarTodosLosAtributosEnElConstructor() {
		String nombre = "Mi atracción";
		Double longitud = 0.0;
		Double latitud = 0.0;
		Double costo = 0.0;
		Double duracion = 0.0;
		Integer cupoVisitantes = 0;
		TipoAtraccion tipo = TipoAtraccion.PAISAJE;

		Atraccion atraccion = new Atraccion(nombre, longitud, latitud, costo,
				duracion, cupoVisitantes, tipo);

		Assert.assertNotNull(atraccion);

	}

}
