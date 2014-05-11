package untref.aydoo.tp;

import junit.framework.Assert;

import org.junit.Test;

public class CoordenadaTest {

	@Test
	public void medirLaDistanciaDesdeLaMismaHubicacionDeLaAtraccionDeberiaDevolver0() {
		Double latitud = 100.0;
		Double longitud = 100.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);

		Double distanciaEsperada = 0.0;

		Assert.assertEquals(distanciaEsperada,
				ubicacion.calcularDistanciaA(latitud, longitud));
	}

	@Test
	public void medirLaDistanciaDeberiaDevolverLaDistanciaEnLineaRecta() {
		Double latitud = -100.0;
		Double longitud = 200.0;
		Coordenada ubicacion = new Coordenada(latitud, longitud);

		Double latitudUsuario = 200.0;
		Double longitudUsuario = 600.0;
		Coordenada ubicacionUsuario = new Coordenada(latitudUsuario, longitudUsuario);

		Double distanciaEsperada = 500.0;

		Assert.assertEquals(distanciaEsperada,
				ubicacion.calcularDistanciaA(ubicacionUsuario.getLatitud(), ubicacionUsuario.getLongitud()));
	}
}
