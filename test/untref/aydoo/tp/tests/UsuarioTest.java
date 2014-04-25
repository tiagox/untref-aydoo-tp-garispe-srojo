package untref.aydoo.tp.tests;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import untref.aydoo.tp.TipoAtraccion;
import untref.aydoo.tp.Usuario;

public class UsuarioTest {

	private String nombre = "Isaac";
	private String apellido = "Newton";
	private Double presupuesto = 10000.0;
	private Double tiempoDisponible = 120.0;
	private Double velocidadTraslado = 15.0;
	private TipoAtraccion tipoPreferido = TipoAtraccion.AVENTURA;
	private Usuario usuario;

	@Before
	public void setup() {

		this.usuario = new Usuario(nombre, apellido, presupuesto,
				tiempoDisponible, velocidadTraslado, tipoPreferido);
	}

	@Test
	public void pedirElNombreDeberiaDevolverElMismoNombreAsignadoAlCrearlo() {
		Assert.assertEquals(this.nombre, usuario.getNombre());
	}

	@Test
	public void pedirElApellidoDeberiaDevolverElMismoNombreAsignadoAlCrearlo() {
		Assert.assertEquals(this.apellido, usuario.getApellido());
	}

	@Test
	public void pedirElPresupuestoDeberiaDevolverElMismoNombreAsignadoAlCrearlo() {
		Assert.assertEquals(this.presupuesto, usuario.getPresupuesto());
	}

	@Test
	public void pedirElTiempoDisponibleDeberiaDevolverElMismoNombreAsignadoAlCrearlo() {
		Assert.assertEquals(this.tiempoDisponible,
				usuario.getTiempoDisponible());
	}

	@Test
	public void pedirLaVelocidadDeTrasladoDeberiaDevolverElMismoNombreAsignadoAlCrearlo() {
		Assert.assertEquals(this.velocidadTraslado,
				usuario.getVelocidadTraslado());
	}

	@Test
	public void pedirElTipoPreferidoDeberiaDevolverElMismoNombreAsignadoAlCrearlo() {
		Assert.assertEquals(this.tipoPreferido, usuario.getTipoPreferido());
	}

}
