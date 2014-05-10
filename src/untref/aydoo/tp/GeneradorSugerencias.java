package untref.aydoo.tp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GeneradorSugerencias {

	private List<Sugerible> promociones;

	public GeneradorSugerencias(List<Sugerible> promociones) {
		this.promociones = promociones;
	}

	public List<Sugerible> getSugerencias(Usuario usuario, Date dia) {
		List<Sugerible> sugerencias = new ArrayList<Sugerible>();
		for (Sugerible sugerenciaPosible : this.promociones) {
			if (esSugeriblePara(usuario, dia, sugerenciaPosible)) {
				sugerencias.add(sugerenciaPosible);
			}
		}
		return sugerencias;
	}

	private Boolean esSugeriblePara(Usuario usuario, Date dia,
			Sugerible sugerenciaPosible) {
		return laPromocionEstaVigente(dia, sugerenciaPosible)
				&& elPresupuestoDelUsuarioSuficiente(usuario, sugerenciaPosible)
				&& tieneAlMenosUnaAtraccionDeLasFavoritasDelUsuario(usuario,
						sugerenciaPosible)
				&& elTiempoQueTieneElUsuarioEsSuficiente(usuario, sugerenciaPosible)
				&& estaAMenosDeUnaHoraDeViajeDelUsuario(usuario, sugerenciaPosible);
	}

	private Boolean laPromocionEstaVigente(Date dia, Sugerible sugerenciaPosible) {
		return sugerenciaPosible.isVigente(dia);
	}

	private Boolean tieneAlMenosUnaAtraccionDeLasFavoritasDelUsuario(
			Usuario usuario, Sugerible sugerenciaPosible) {
		return sugerenciaPosible.hasTipoAtraccion(usuario.getTipoPreferido());
	}

	private Boolean estaAMenosDeUnaHoraDeViajeDelUsuario(Usuario usuario,
			Sugerible sugerenciaPosible) {
		return sugerenciaPosible.getDistanciaAtraccionMasCercana(usuario.getLatitud(),
				usuario.getLongitud()) / usuario.getVelocidadTraslado() <= 1.0;
	}

	private Boolean elTiempoQueTieneElUsuarioEsSuficiente(Usuario usuario,
			Sugerible sugerenciaPosible) {
		return sugerenciaPosible.getDuracion() <= usuario.getTiempoDisponible();
	}

	private Boolean elPresupuestoDelUsuarioSuficiente(Usuario usuario,
			Sugerible sugerenciaPosible) {
		return sugerenciaPosible.getPrecio() <= usuario.getPresupuesto();
	}
}
