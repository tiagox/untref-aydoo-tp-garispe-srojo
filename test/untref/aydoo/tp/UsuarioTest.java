package untref.aydoo.tp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	private Double presupuesto = 1000.0;
	private Double tiempoDisponible = 120.0;
	private Double velocidadTraslado = 15.0;
	private Double latitud = 100.0;
	private Double longitud = 100.0;
	private TipoAtraccion tipoPreferido = TipoAtraccion.AVENTURA;

	private Usuario usuario;

	@Before
	public void setup() {
		this.usuario = new Usuario(presupuesto,
				tiempoDisponible, velocidadTraslado, latitud, longitud, tipoPreferido);
	}

	@Test
	public void pedirElPresupuestoDeberiaDevolverElMismoPresupuestoAsignadoAlCrearlo() {
		Assert.assertEquals(this.presupuesto, usuario.getPresupuesto());
	}

	@Test
	public void pedirElTiempoDisponibleDeberiaDevolverElMismoTiempoDisponibleAsignadoAlCrearlo() {
		Assert.assertEquals(this.tiempoDisponible,
				usuario.getTiempoDisponible());
	}

	@Test
	public void pedirLaVelocidadDeTrasladoDeberiaDevolverLaMismaVelocidadTrasladoAsignadoAlCrearlo() {
		Assert.assertEquals(this.velocidadTraslado,
				usuario.getVelocidadTraslado());
	}

	@Test
	public void pedirElTipoPreferidoDeberiaDevolverElMismoTipoPreferidoAsignadoAlCrearlo() {
		Assert.assertEquals(this.tipoPreferido, usuario.getTipoPreferido());
	}

	@Test
	public void pedirLaLatitudDeberiaDevolverElMismoTipoPreferidoAsignadoAlCrearlo() {
		Assert.assertEquals(this.latitud, usuario.getLatitud());
	}

	@Test
	public void pedirLaLongitudDeberiaDevolverElMismoTipoPreferidoAsignadoAlCrearlo() {
		Assert.assertEquals(this.longitud, usuario.getLongitud());
	}


}
