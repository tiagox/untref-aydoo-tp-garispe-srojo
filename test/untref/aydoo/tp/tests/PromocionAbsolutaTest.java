package untref.aydoo.tp.tests;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tp.Atraccion;
import untref.aydoo.tp.PromocionAbsoluta;
import untref.aydoo.tp.TipoAtraccion;

public class PromocionAbsolutaTest {

	private Atraccion atraccion = new Atraccion("Atraccion", 520.0, 230.0,
			5500.0, 80.0, 1000, TipoAtraccion.PAISAJE);
	private String nombre = "Promocion Absoluta";
	private Integer periodoVigencia = 31; // Dias
	private List<Atraccion> atracciones = new LinkedList<Atraccion>();
	private PromocionAbsoluta promocionAbsoluta;

	@Before
	public void setup() {

		promocionAbsoluta = new PromocionAbsoluta(this.nombre,
				this.periodoVigencia, this.atracciones);

		promocionAbsoluta.getAtracciones().add(this.atraccion);

	}

	@Test
	public void pedirElNombreDeberiaDevolverElMismoNombreAsignadoAlCrearla() {
		Assert.assertEquals(this.nombre, this.promocionAbsoluta.getNombre());
	}

	@Test
	public void pedirElPeriodoDeVigenciaDeberiaDevolverElMismoPeriodoVigenciaAsignadoAlCrearla() {
		Assert.assertEquals(this.periodoVigencia,
				this.promocionAbsoluta.getPeriodoVigencia());
	}

	@Test
	public void pedirElCostoTotalConDescDeberiaDevolverElCostoTotalMenosElDescuento() {
		Assert.assertEquals(0.0,
				this.promocionAbsoluta.descuento(this.atraccion.getCosto()),
				0.0);
	}
}
