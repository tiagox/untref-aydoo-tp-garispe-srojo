package untref.aydoo.tp;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	private Double presupuesto = 1000.0;
	private Double tiempoDisponible = 120.0;
	private Double tiempoMaximoDeViaje = 1.5;
	private Double velocidadTraslado = 35.33;
	private Double latitud = 97.98;
	private Double longitud = 102.47;
	private Coordenada ubicacion;
	private TipoAtraccion tipoPreferido = TipoAtraccion.AVENTURA;

	private Usuario usuario;

	@Before
	public void setup() {
		this.ubicacion = new Coordenada(latitud, longitud);

		this.usuario = new Usuario(presupuesto, tiempoDisponible,
				velocidadTraslado, tiempoMaximoDeViaje, ubicacion,
				tipoPreferido);
	}

	@Test
	public void consultarSiElPrecioEstaBienDeberiaDevolverVerdaderoSiPrecioEsMenorOIgualQuePresupesto() {
		Double precio = this.presupuesto - 100;

		Assert.assertTrue(this.usuario.estaBienPrecio(precio));
	}

	@Test
	public void consultarSiElPrecioEstaBienDeberiaDevolverFalsoSiPrecioEsMayorQuePresupesto() {
		Double precio = this.presupuesto + 100;

		Assert.assertFalse(this.usuario.estaBienPrecio(precio));
	}

	@Test
	public void consultarSiLaDuracionEstaBienDeberiaDevolverVerdaderoSiEsMenorOIgualQueTiempoDisponible() {
		Double duracion = this.tiempoDisponible - 50;

		Assert.assertTrue(this.usuario.estaBienDuracion(duracion));
	}

	@Test
	public void consultarSiLaDuracionEstaBienDeberiaDevolverFalsoSiEsMayorQueTiempoDisponible() {
		Double duracion = this.tiempoDisponible + 50;

		Assert.assertFalse(this.usuario.estaBienDuracion(duracion));
	}

	@Test
	public void consultarSiLosTiposDeAtraccionDeUnaListaEstanBienDeberiaDevolverVerdaderoSiHayAlgunTipoPreferido() {
		List<TipoAtraccion> tiposAtraccion = new ArrayList<TipoAtraccion>();
		tiposAtraccion.add(TipoAtraccion.AVENTURA);
		tiposAtraccion.add(TipoAtraccion.PAISAJE);

		Assert.assertTrue(this.usuario.estanBienTiposAtraccion(tiposAtraccion));
	}

	@Test
	public void consultarSiLosTiposDeAtraccionDeUnaListaEstanBienDeberiaDevolverFalsoSiNoHayNingunTipoPreferido() {
		List<TipoAtraccion> tiposAtraccion = new ArrayList<TipoAtraccion>();
		tiposAtraccion.add(TipoAtraccion.PAISAJE);
		tiposAtraccion.add(TipoAtraccion.DEGUSTACION);

		Assert.assertFalse(this.usuario.estanBienTiposAtraccion(tiposAtraccion));
	}

	@Test
	public void consultarSiLasUbicacionesDeUnaListaEstanBienDeberiaDevolverVerdaderoSiHayAlgunaAUnTiempoDeViajeMenorQueElAceptado() {
		List<Coordenada> ubicaciones = new ArrayList<Coordenada>();
		ubicaciones.add(new Coordenada(123.45,  75.33));
		ubicaciones.add(new Coordenada(263.99,  -223.58));
		
		Assert.assertTrue(this.usuario.estanBienUbicaciones(ubicaciones));
	}

	@Test
	public void consultarSiLasUbicacionesDeUnaListaEstanBienDeberiaDevolverFalsoSiTodasEstanAUnTiempoDeViajeMayorQueElAceptado() {
		List<Coordenada> ubicaciones = new ArrayList<Coordenada>();
		ubicaciones.add(new Coordenada(523.45,  455.33));
		ubicaciones.add(new Coordenada(263.99,  -223.58));
		
		Assert.assertFalse(this.usuario.estanBienUbicaciones(ubicaciones));
	}

}
