package co.poli.asesoriastyt.dao;

/**
 * @author pavargas
 *
 */
public class AulasSQL {
	
	public static String Crear() {
		return "INSERT INTO aulas (Id_Aula,Id_Bloque_Aula) VALUES (?, ?)";
	}

	public static String Modificar() {
		return "UPDATE aulas SET Id_Bloque_Aula=? WHERE Id_Aula=?";
	}

	public static String Consultar(String Id_Aula) {
		return "SELECT * FROM aulas WHERE Id_Aula = " + Id_Aula + "";
	}

	public static String Eliminar() {
		return "DELETE FROM aulas WHERE Id_Aula=?";
	}
}
