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
		for (Sugerible sugerencia : this.promociones) {
			if (sugerencia.isVigente(dia)) {
				if (usuario.estaBienPrecio(sugerencia.getPrecio())
						&& usuario.estaBienDuracion(sugerencia.getDuracion())
						&& usuario.estanBienTiposAtraccion(sugerencia
								.getListaTiposAtraccion())
						&& usuario.estanBienUbicaciones(sugerencia
								.getListaUbicaciones())) {
					sugerencias.add(sugerencia);
				}
			}
		}
		return sugerencias;
	}

}
