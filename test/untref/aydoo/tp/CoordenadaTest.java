package untref.aydoo.tp;

import org.junit.Assert;
import org.junit.Test;

public class CoordenadaTest {

	@Test
	public void medirLaDistanciaDesdeLaMismaUbicacionDeberiaDevolver0() {
		Double latitud = 12.34;
		Double longitud = 46.56;
		Coordenada origen = new Coordenada(latitud, longitud);
		Coordenada destino = new Coordenada(latitud, longitud);

		Double distanciaEsperada = 0.0;

		Assert.assertEquals(distanciaEsperada,
				origen.calcularDistanciaA(destino));
	}

	@Test
	public void medirLaDistanciaDeberiaDevolverLaDistanciaEnLineaRecta() {
		Double latitud = -100.0;
		Double longitud = 200.0;
		Coordenada origen = new Coordenada(latitud, longitud);

		Double latitudDestino = 200.0;
		Double longitudDestino = 600.0;
		Coordenada destino = new Coordenada(latitudDestino, longitudDestino);

		Double distanciaEsperada = 500.0;

		Assert.assertEquals(distanciaEsperada,
				origen.calcularDistanciaA(destino));
	}
	
	@Test
	public void compararSiEsIgualAOtraDeberiaDevolverVerdaderoSiRepresentanLaMismaUbicación() {
		Double latitud = 99.49;
		Double longitud = -54.31;
		Coordenada origen = new Coordenada(latitud, longitud);

		Assert.assertTrue(origen.esIgualA(new Coordenada(latitud, longitud)));
		Assert.assertTrue((new Coordenada(100.0, 0.0)).esIgualA(new Coordenada(100.0, 0.0)));
	}

	@Test
	public void compararSiEsIgualAOtraDeberiaDevolverFalsoSiNoRepresentanLaMismaUbicación() {
		Double latitud = 99.49;
		Double longitud = -54.31;
		Coordenada origen = new Coordenada(latitud, longitud);
		
		Assert.assertTrue((new Coordenada(100.0, 0.0)).esIgualA(new Coordenada(100.0, 0.0)));
		Assert.assertFalse(origen.esIgualA(new Coordenada(latitud, -54.32)));
		Assert.assertFalse(origen.esIgualA(new Coordenada(99.48, longitud)));
	}

}
