package untref.aydoo.tp.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tp.TipoAtraccion;
import untref.aydoo.tp.Usuario;

public class UsuarioTest {

	private Double presupuesto = 1000.0;
	private Double tiempoDisponible = 120.0;
	private Double velocidadTraslado = 15.0;
	private TipoAtraccion tipoPreferido = TipoAtraccion.AVENTURA;

	private Usuario usuario;

	@Before
	public void setup() {
		this.usuario = new Usuario(presupuesto,
				tiempoDisponible, velocidadTraslado, tipoPreferido);
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

}
