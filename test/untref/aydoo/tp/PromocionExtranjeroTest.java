package untref.aydoo.tp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class PromocionExtranjeroTest {

	@Test(expected = Error.class)
	public void consultarElPrecioDeberiaDevolverUnErrorSiElDomicilioNoEstaAMasDe200KmDeLaAtraccionMasCercana() {

		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 100.0, 10.0, 300,
				new Coordenada(100.0, 100.0)));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 200.0, 3.0,
				90, new Coordenada(200.0, 200.0)));
		atracciones.add(new Atraccion(TipoAtraccion.PAISAJE, 400.0, 7.0, 100,
				new Coordenada(300.0, 300.0)));
		Date desde = new Date();
		Date hasta = new Date();

		Coordenada domicilio = new Coordenada(150.0, 150.0);

		PromocionExtranjero	promocion = new PromocionExtranjero(atracciones, desde, hasta,
				domicilio);

		Assert.assertNotNull(promocion);

	}

	@Test
	public void consultarElPrecioTotalDeberiaDevolver350SiElPrecioTotalDeAtraccionesEs700() {

		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 100.0, 10.0, 300,
				new Coordenada(100.0, 100.0)));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 200.0, 3.0,
				90, new Coordenada(200.0, 200.0)));
		atracciones.add(new Atraccion(TipoAtraccion.PAISAJE, 400.0, 7.0, 100,
				new Coordenada(300.0, 300.0)));
		Date desde = new Date();
		Date hasta = new Date();
		Coordenada domicilio = new Coordenada(600.0, 600.0);
		
		Double precioEsperado = 350.0;

		PromocionExtranjero promocion = new PromocionExtranjero(atracciones,
				desde, hasta, domicilio);

		Assert.assertEquals(precioEsperado, promocion.getPrecio());
	}
	
	@Test
	public void consultarElPrecioTotalDeberiaDevolver500SiElPrecioTotalDeAtraccionesEs1000() {

		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 400.0, 10.0, 300,
				new Coordenada(100.0, 100.0)));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 200.0, 3.0,
				90, new Coordenada(200.0, 200.0)));
		atracciones.add(new Atraccion(TipoAtraccion.PAISAJE, 400.0, 7.0, 100,
				new Coordenada(300.0, 300.0)));
		Date desde = new Date();
		Date hasta = new Date();
		Coordenada domicilio = new Coordenada(600.0, 600.0);
		
		Double precioEsperado = 500.0;

		PromocionExtranjero promocion = new PromocionExtranjero(atracciones,
				desde, hasta, domicilio);

		Assert.assertEquals(precioEsperado, promocion.getPrecio());
	}
	
	@Test
	public void consultarElPrecioTotalDeberiaDevolver365con90SiElPrecioTotalDeAtraccionesEs731con80() {

		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion(TipoAtraccion.AVENTURA, 400.0, 10.0, 300,
				new Coordenada(100.0, 100.0)));
		atracciones.add(new Atraccion(TipoAtraccion.DEGUSTACION, 200.0, 3.0,
				90, new Coordenada(200.0, 200.0)));
		atracciones.add(new Atraccion(TipoAtraccion.PAISAJE, 131.8, 7.0, 100,
				new Coordenada(300.0, 300.0)));
		Date desde = new Date();
		Date hasta = new Date();
		Coordenada domicilio = new Coordenada(600.0, 600.0);
		
		Double precioEsperado = 365.90;

		PromocionExtranjero promocion = new PromocionExtranjero(atracciones,
				desde, hasta, domicilio);

		Assert.assertEquals(precioEsperado, promocion.getPrecio());
	}
}
