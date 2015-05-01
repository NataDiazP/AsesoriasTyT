/**
 * 
 */
package co.poli.asesoriastyt.util;

	import javax.sql.DataSource;
	import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
	 
	public class JRDataSource {
		
		private static final MysqlDataSource mysqlDS = new MysqlDataSource();
		
		static {
			mysqlDS.setURL("jdbc:mysql://localhost:3306/dbasesoriastyt2");
			mysqlDS.setUser("root");
			mysqlDS.setPassword("");
		}
	    public static DataSource getMySQLDataSource() {
	        return mysqlDS;
	    }
}