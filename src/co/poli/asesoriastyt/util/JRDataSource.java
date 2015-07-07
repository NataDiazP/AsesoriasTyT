/**
 * 
 */
package co.poli.asesoriastyt.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
	 
	public class JRDataSource {
		
		private static final MysqlDataSource mysqlDS = new MysqlDataSource();
		
		static {
			
			Properties props = new Properties();
			InputStream in = null;
			try {
				
				in = JRDataSource.class.getResourceAsStream("conexion.properties");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   try {
				props.load(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
			String url = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");

			mysqlDS.setURL(url);
			mysqlDS.setUser(username);
			mysqlDS.setPassword(password);
		}
	    public static DataSource getMySQLDataSource() {
	        return mysqlDS;
	    }
}

