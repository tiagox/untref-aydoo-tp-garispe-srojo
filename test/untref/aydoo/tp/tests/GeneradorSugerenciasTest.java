package untref.aydoo.tp.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import untref.aydoo.tp.GeneradorSugerencias;
import untref.aydoo.tp.Promocion;

public class GeneradorSugerenciasTest {

	@Test
	public void generadorSugerenciasDeberiaAceptarUnaListaDePromociones() {
		List<Promocion> promociones = new ArrayList<Promocion>();
		GeneradorSugerencias generadorSugerencias = new GeneradorSugerencias(promociones);
		
		Assert.assertNotNull(generadorSugerencias);
	}

}
