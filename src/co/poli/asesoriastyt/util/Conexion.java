/**
 * 
 */
package co.poli.asesoriastyt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *  Class Conexion.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class Conexion {

	/**  Con. */
	public Connection Con;

	/**
	 * Gets  connection.
	 *
	 * @return  connection
	 */
	public Connection getConnection() {
		ConexionDB();
		return Con;
	}

	/**
	 * Sets  con.
	 *
	 * @param Con  new con
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
			setCon(DriverManager.getConnection("jdbc:mysql://localhost:3306/dbasesoriastyt", "root", ""));
		} catch (SQLException e4) {
			System.out.print("SQLException" + e4.getMessage());
		} catch (Exception e5) {
			System.out.print("SQLException" + e5.getMessage());
		}
	}
}
