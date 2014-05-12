package untref.aydoo.tp;

import java.util.Date;
import java.util.List;

public interface Sugerible {

	public Boolean isVigente(Date dia);

	public Double getPrecio();

	public Double getDuracion();

	public List<TipoAtraccion> getListaTiposAtraccion();

	public List<Coordenada> getListaUbicaciones();

}
