package untref.aydoo.tp;

import java.util.Date;

public interface Sugerible {

	public Boolean isVigente(Date dia);

	public Double getPrecio();

	public Boolean hasTipoAtraccion(TipoAtraccion tipoPreferido);

	public Double getDuracion();

	public Double getDistanciaAtraccionMasCercana(Double latitud,
			Double longitud);

}
