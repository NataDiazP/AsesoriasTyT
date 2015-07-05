/**
 * 
 */
package co.poli.asesoriastyt.util;

	import javax.sql.DataSource;
	import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
	 

/**
	 *  Class JRDataSource.
	 * @author Natalia Díaz , Natalia Velez , Paola Vargas
	 */
	public class JRDataSource {
		
		/**  Constant mysqlDS. */
		private static final MysqlDataSource mysqlDS = new MysqlDataSource();
		
		static {
			mysqlDS.setURL("jdbc:mysql://localhost:3306/dbasesoriastyt");
			mysqlDS.setUser("root");
			mysqlDS.setPassword("");
		}
	    
    	/**
    	 * Gets  my sql data source.
    	 *
    	 * @return  my sql data source
    	 */
    	public static DataSource getMySQLDataSource() {
	        return mysqlDS;
	    }
}