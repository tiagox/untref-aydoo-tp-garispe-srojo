package untref.aydoo.tp.tests;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import untref.aydoo.tp.Atraccion;
import untref.aydoo.tp.PromocionAxB;
import untref.aydoo.tp.TipoAtraccion;

public class PromocionAxBTest {

	@Test
	public void promocionAxBDeberiaAceptarTodosLosAtributosEnSuConstrucctor() {
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(new Atraccion("Asd", 100.0, 100.0, 100.0, 30.0, 100, TipoAtraccion.AVENTURA));
		atracciones.add(new Atraccion("Fgh", 200.0, 200.0, 200.0, 15.0, 200, TipoAtraccion.PAISAJE));
		
		Atraccion beneficio = new Atraccion("Jkl", 50.0, 45.0, 10.5, 20.0, 40, TipoAtraccion.AVENTURA);
		
		String nombre = "Promo 1";
		Integer periodoVigencia = 20;
		
		PromocionAxB promo = new PromocionAxB(atracciones, beneficio, nombre, periodoVigencia);
		
		Assert.assertNotNull(promo);
	}
}
