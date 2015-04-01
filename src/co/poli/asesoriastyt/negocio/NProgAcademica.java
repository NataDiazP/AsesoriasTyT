/**
 * 
 */
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.util.List;

import co.poli.asesoriastyt.dao.DAOProgAcademica;
import co.poli.asesoriastyt.model.Asignatura;
import co.poli.asesoriastyt.model.ProgAcademica;
import co.poli.asesoriastyt.util.Conexion;

/**
 * @author natad_000
 *
 */
public class NProgAcademica {

	DAOProgAcademica daoProgAcademica;
	Connection c;

	public int Crear(ProgAcademica ProgAcademica) {
		daoProgAcademica = new DAOProgAcademica();
		c = new Conexion().getConnection();
		int resultadoCrear = daoProgAcademica.Crear(c, ProgAcademica);
		return resultadoCrear;
	}

	public int Modificar(ProgAcademica ProgAcademica) {
		daoProgAcademica = new DAOProgAcademica();
		c = new Conexion().getConnection();
		int resultadoModificar = daoProgAcademica.Modificar(c, ProgAcademica);
		return resultadoModificar;
	}

	public ProgAcademica Buscar(String ProgAcademica) {
		daoProgAcademica = new DAOProgAcademica();
		c = new Conexion().getConnection();
		ProgAcademica resultadoBuscar = daoProgAcademica.Buscar(c, ProgAcademica);
		return resultadoBuscar;
	}

	public int Eliminar(ProgAcademica ProgAcademica) {
		daoProgAcademica = new DAOProgAcademica();
		c = new Conexion().getConnection();
		int resultadoEliminar = daoProgAcademica.Eliminar(c, ProgAcademica);
		return resultadoEliminar;
	}

	public List<Asignatura> AsignaturasDocente(String idDocente) {
		daoProgAcademica = new DAOProgAcademica();
		c = new Conexion().getConnection();
		return daoProgAcademica.asignaturasDocente(c, idDocente);
	}

	public List<ProgAcademica> ListadoProgAcademica() {
		daoProgAcademica = new DAOProgAcademica();
		c = new Conexion().getConnection();
		return daoProgAcademica.listarProgAcademica(c);
	}
}