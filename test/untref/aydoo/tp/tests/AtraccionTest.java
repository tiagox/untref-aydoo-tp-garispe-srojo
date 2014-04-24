package untref.aydoo.tp.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tp.Atraccion;
import untref.aydoo.tp.TipoAtraccion;

public class AtraccionTest {
	
	private String nombre = "Mi atracción";
	private Double longitud = 1000.0;
	private Double latitud = 1000.0;
	private Double costo = 10.0;
	private Double duracion = 30.0;
	private Integer cupoVisitantes = 100;
	private TipoAtraccion tipo = TipoAtraccion.PAISAJE;
	private Atraccion atraccion;
	
	@Before
	public void setup() {
		this.atraccion = new Atraccion(nombre, longitud, latitud, costo,
				duracion, cupoVisitantes, tipo);
	}

	@Test
	public void pedirElNombreDeberiaDevolverElMismoNombreAsignadoAlCrearla() {
		Assert.assertEquals(this.nombre, this.atraccion.getNombre());
	}
	
	@Test
	public void pedirLaLongitudDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Assert.assertEquals(this.longitud, this.atraccion.getLongitud(), 0.000001);
	}

}
