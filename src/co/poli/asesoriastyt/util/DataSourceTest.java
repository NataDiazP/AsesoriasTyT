/**
 * 
 */
package co.poli.asesoriastyt.util;

/**
 * @author Paola
 *
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import javax.sql.DataSource;
 
public class DataSourceTest {
 
    public static void main(String[] args) {
         
        testDataSource("mysql");
        System.out.println("**********");
        testDataSource("oracle");
 
    }
 
    private static void testDataSource(String dbType) {
        DataSource ds = null;
        if("mysql".equals(dbType)){
            ds = JRDataSource.getMySQLDataSource();
        }else{
            System.out.println("invalid db type");
            return;
        }
         
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from perfiles");
            while(rs.next()){
                System.out.println("Perfil ID="+rs.getString("empid")+", Name="+rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
                try {
                    if(rs != null) rs.close();
                    if(stmt != null) stmt.close();
                    if(con != null) con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
 
}