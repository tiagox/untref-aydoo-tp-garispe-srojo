package untref.aydoo.tp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AtraccionTest {

	@Test
	public void pedirElPrecioDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double precio = 100.0;
		Double duracion = 1.0;
		Integer cupoVisitantes = 150;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, precio,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(precio, atraccion.getPrecio());
	}

	@Test
	public void pedirElPrecioDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double precio = 200.0;
		Double duracion = 1.0;
		Integer cupoVisitantes = 150;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, precio,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(precio, atraccion.getPrecio());
	}

	@Test
	public void pedirElTipoDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double precio = 100.0;
		Double duracion = 1.0;
		Integer cupoVisitantes = 150;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.DEGUSTACION, precio,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(TipoAtraccion.DEGUSTACION, atraccion.getTipo());
	}

	@Test
	public void pedirElTipoDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double precio = 100.0;
		Double duracion = 1.0;
		Integer cupoVisitantes = 150;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, precio,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(TipoAtraccion.AVENTURA, atraccion.getTipo());
	}

	@Test
	public void pedirLaDuracionDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double precio = 100.0;
		Double duracion = 2.0;
		Integer cupoVisitantes = 150;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, precio,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(duracion, atraccion.getDuracion());
	}

	@Test
	public void pedirLaDuracionDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double precio = 100.0;
		Double duracion = 5.0;
		Integer cupoVisitantes = 150;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, precio,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(duracion, atraccion.getDuracion());
	}

	@Test
	public void pedirElCupoDeVisitantesDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double precio = 100.0;
		Double duracion = 2.0;
		Integer cupoVisitantes = 150;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, precio,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(cupoVisitantes, atraccion.getCupoVisitantes());
	}

	@Test
	public void pedirElCupoDeVisitantesDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double precio = 100.0;
		Double duracion = 5.0;
		Integer cupoVisitantes = 150;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, precio,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(cupoVisitantes, atraccion.getCupoVisitantes());
	}

	@Test
	public void pedirLaUbicacionDeberiaDevolverElMismoValorAsignadoAlCrearla() {
		Double precio = 100.0;
		Double duracion = 2.0;
		Integer cupoVisitantes = 150;
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, precio,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(ubicacion, atraccion.getUbicacion());
	}

	@Test
	public void pedirLaUbicacionDeberiaDevolverElValorAsignadoCualquieraSea() {
		Double precio = 100.0;
		Double duracion = 5.0;
		Integer cupoVisitantes = 150;
		Double latitud = 1100.0;
		Double longitud = 140.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, precio,
				duracion, cupoVisitantes, ubicacion);

		Assert.assertEquals(ubicacion, atraccion.getUbicacion());
	}

	@Test
	public void consultarSiEstaVigenteDeberiaDevolverSiempreVerdadero() {
		Double precio = 123.99;
		Double duracion = 2.5;
		Integer cupoVisitantes = 23;
		Coordenada ubicacion = new Coordenada(-654.06, 232.58);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, precio,
				duracion, cupoVisitantes, ubicacion);

		Date dia = new Date();

		Assert.assertTrue(atraccion.isVigente(dia));
	}

	@Test
	public void consultarLaListaDeTiposDeAtraccionDeberiaDevolverUnaListaConElTipoDeLaAtraccion() {
		Double precio = 43.01;
		Double duracion = 1.45;
		Integer cupoVisitantes = 12;
		Coordenada ubicacion = new Coordenada(-234.11, 11.98);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, precio,
				duracion, cupoVisitantes, ubicacion);

		List<TipoAtraccion> listaEsperada = new ArrayList<TipoAtraccion>();
		listaEsperada.add(TipoAtraccion.AVENTURA);

		Assert.assertEquals(listaEsperada, atraccion.getListaTiposAtraccion());
	}

	@Test
	public void consultarLaListaDeTiposDeAtraccionDeberiaDevolverUnaListaConElTipoDeLaAtraccionSiempre() {
		Double precio = 43.01;
		Double duracion = 1.45;
		Integer cupoVisitantes = 12;
		Coordenada ubicacion = new Coordenada(-234.11, 11.98);
		Atraccion atraccion = new Atraccion(TipoAtraccion.DEGUSTACION, precio,
				duracion, cupoVisitantes, ubicacion);

		List<TipoAtraccion> listaEsperada = new ArrayList<TipoAtraccion>();
		listaEsperada.add(TipoAtraccion.DEGUSTACION);

		Assert.assertEquals(listaEsperada, atraccion.getListaTiposAtraccion());
	}

	@Test
	public void consultarLaListaUbicacionesDeberiaDevolverUnaListaConElTipoDeLaAtraccion() {
		Double precio = 43.01;
		Double duracion = 1.45;
		Integer cupoVisitantes = 12;
		Coordenada ubicacion = new Coordenada(-234.11, 11.98);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, precio,
				duracion, cupoVisitantes, ubicacion);

		List<Coordenada> listaEsperada = new ArrayList<Coordenada>();
		listaEsperada.add(ubicacion);

		Assert.assertEquals(listaEsperada, atraccion.getListaUbicaciones());
	}

	@Test
	public void consultarLaListaDeUbicacionesDeberiaDevolverUnaListaConElTipoDeLaAtraccionSiempre() {
		Double precio = 123.99;
		Double duracion = 2.5;
		Integer cupoVisitantes = 23;
		Coordenada ubicacion = new Coordenada(-654.06, 232.58);
		Atraccion atraccion = new Atraccion(TipoAtraccion.AVENTURA, precio,
				duracion, cupoVisitantes, ubicacion);

		List<Coordenada> listaEsperada = new ArrayList<Coordenada>();
		listaEsperada.add(ubicacion);

		Assert.assertEquals(listaEsperada, atraccion.getListaUbicaciones());
	}

}
