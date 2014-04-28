package untref.aydoo.tp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GeneradorSugerencias {

	private List<Promocion> promociones;

	public GeneradorSugerencias(List<Promocion> promociones) {
		this.promociones = promociones;
	}

	public List<Promocion> getSugerencias(Usuario usuario, Date dia) {
		List<Promocion> sugerencias = new ArrayList<Promocion>();
		for (Promocion promocion : this.promociones) {
			if (laPromocionEstaVigente(dia, promocion)
					&& elPresupuestoDelUsuarioSuficiente(usuario, promocion)
					&& tieneAlMenosUnaAtraccionDeLasFavoritasDelUsuario(usuario,
							promocion)
					&& elTiempoQueTieneElUsuarioEsSuficiente(usuario, promocion)
					&& estaAMenosDeUnaHoraDeViajeDelUsuario(usuario, promocion)) {
				sugerencias.add(promocion);
			}
		}
		return sugerencias;
	}

	private Boolean laPromocionEstaVigente(Date dia, Promocion promocion) {
		return promocion.isVigente(dia);
	}

	private Boolean tieneAlMenosUnaAtraccionDeLasFavoritasDelUsuario(
			Usuario usuario, Promocion promocion) {
		return promocion.hasTipoAtraccion(usuario.getTipoPreferido());
	}

	private boolean estaAMenosDeUnaHoraDeViajeDelUsuario(Usuario usuario,
			Promocion promocion) {
		return promocion.getDistanciaAtraccionMasCercana(usuario.getLatitud(),
				usuario.getLongitud()) / usuario.getVelocidadTraslado() <= 1.0;
	}

	private boolean elTiempoQueTieneElUsuarioEsSuficiente(Usuario usuario, Promocion promocion) {
		return promocion.getDuracion() <= usuario.getTiempoDisponible();
	}

	private boolean elPresupuestoDelUsuarioSuficiente(Usuario usuario, Promocion promocion) {
		return promocion.getPrecio() <= usuario.getPresupuesto();
	}
}
