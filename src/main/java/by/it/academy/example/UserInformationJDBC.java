package by.it.academy.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class UserInformationJDBC {
    private static final Logger logger = LoggerFactory.getLogger("LOGS");
    private static final HikariConfig config = new HikariConfig();
    private static final DataSource ds;

    static {
        config.setDriverClassName(UserParameters.getJdbcDriver());
        config.setJdbcUrl( UserParameters.getUrl() );
        config.setUsername( UserParameters.getUsername() );
        config.setPassword( UserParameters.getPassword() );
        config.setMaxLifetime(2000);
        config.setMaximumPoolSize(30);
        ds = new HikariDataSource(config);
    }

    public static Connection getPoolConnection (){
        try {logger.trace("getConnection success");
            return ds.getConnection();
        } catch (SQLException e) {
            logger.error("There was an error in the class UserInformationJDBC",e);
            return null;
        }
    }
    public static Connection createNewPoolConnection (DataSource dataSource){
        try {logger.trace("getConnection success");
            return ds.getConnection();
        } catch (SQLException e) {
            logger.error("There was an error in the class UserInformationJDBC",e);
            return null;
        }
    }
}

class UserParameters {
    @Getter @Setter
    static String jdbcDriver = "org.postgresql.Driver";
    @Getter @Setter
    static String url = "jdbc:postgresql://localhost:5432/test_db";
    @Getter @Setter
    static String username = "postgres" ;
    @Getter @Setter
    static String password = "root";
}

