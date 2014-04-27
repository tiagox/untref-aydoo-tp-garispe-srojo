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
			if (promocion.isVigente(dia)
					&& promocion.getPrecio() <= usuario.getPresupuesto()
					&& promocion.hasTipoAtraccion(usuario.getTipoPreferido())
					&& promocion.getDuracion() <= usuario.getTiempoDisponible()) {
				sugerencias.add(promocion);
			}
		}
		return sugerencias;
	}
}
