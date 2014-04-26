package untref.aydoo.tp.tests;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tp.Atraccion;
import untref.aydoo.tp.PromocionPorcentual;
import untref.aydoo.tp.TipoAtraccion;

public class PromocionPorcentualTest {

	private Atraccion atraccion = new Atraccion("Atraccion", 100.0, 150.0,
			2500.0, 120.0, 100, TipoAtraccion.AVENTURA);

	private String nombre = "Promocion Porcentual";
	private Integer periodoVigencia = 20; // Dias
	private List<Atraccion> atracciones = new LinkedList<Atraccion>();

	private Double porcentajeDescuento = 40.0;

	private PromocionPorcentual promocionPorcentual;

	@Before
	public void setup() {

		promocionPorcentual = new PromocionPorcentual(this.nombre,
				this.periodoVigencia, this.atracciones);

		promocionPorcentual.getAtracciones().add(this.atraccion);

	}

	@Test
	public void pedirElNombreDeberiaDevolverElMismoNombreAsignadoAlCrearla() {
		Assert.assertEquals(this.nombre, this.promocionPorcentual.getNombre());
	}

	@Test
	public void pedirElPeriodoDeVigenciaDeberiaDevolverElMismoPeriodoVigenciaAsignadoAlCrearla() {
		Assert.assertEquals(this.periodoVigencia,
				this.promocionPorcentual.getPeriodoVigencia());
	}

	@Test
	public void pedirElCostoTotalConDescDeberiaDevolverElCostoTotalMenosElDescuentoDe40Porciento() {
		Assert.assertEquals(1500.0,
				this.promocionPorcentual.descuento(this.porcentajeDescuento),
				0.000001);
	}
}
