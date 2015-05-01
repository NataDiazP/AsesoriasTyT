/**
 * 
 */
package co.poli.asesoriastyt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * The Class Conexion.
 *
 * @author natad_000
 */
public class Conexion {

	/** The Con. */
	public Connection Con;

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		ConexionDB();
		return Con;
	}

	/**
	 * Sets the con.
	 *
	 * @param Con the new con
	 */
	public void setCon(Connection Con) {
		this.Con = Con;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException e1) {
			System.out.println("ClassNotFoundException" + e1.getMessage());
		} catch (InstantiationException e2) {
			System.out.println("InstantiationException" + e2.getMessage());
		} catch (IllegalAccessException e3) {
			System.out.println("IllegalAccessException" + e3.getMessage());
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
	}

	/**
	 * Conexion db.
	 */
	public void ConexionDB() {
		try {
			setCon(DriverManager.getConnection("jdbc:mysql://localhost:3306/dbasesoriastyt2", "root", ""));
		} catch (SQLException e4) {
			System.out.print("SQLException" + e4.getMessage());
		} catch (Exception e5) {
			System.out.print("SQLException" + e5.getMessage());
		}
	}
}
