
package projetpoo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
/**
 *
 * @author hp
 */
public class MYCONNECTION {
    // IN THIS CLASS WE WILL MAKE OUR CONNECTION WITH THE MYSQL DATABASE
    public Connection createConnection() 
    {
        Connection connection = null;
        MysqlDataSource mds =new MysqlDataSource();
        mds.SetServerName("localhost");
        mds.SetPortNumber(3306);
        mds.SetUser("root");
        mds.SetPassword("hafsa0705");
        mds.SetDatabaseName("hotel");
        try {
            connection=mds.getConnection();
        } catch (SQLException e) {
            Logger.getLogger(MYCONNECTION.class.getName()).log(Level.SEVERE,null,e);
        }
       
}
}
