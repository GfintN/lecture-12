package by.it.academy.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class Main {

    public static void main(String[] ar) {
        Logger logger = LoggerFactory.getLogger("LOGS");
        Logger textLog = LoggerFactory.getLogger("TEXT");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = UserInformationJDBC.getPoolConnection();

            if(conn != null) {
                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                stmt = conn.createStatement();
                int insert1 = stmt.executeUpdate(
                        "INSERT INTO test_db.object_storage VALUES ('Wheels', '1-s', 100, '2021-10-24')");
                int insert2 = stmt.executeUpdate(
                        "INSERT INTO test_db.object_storage VALUES ('Sow', '1233d', 5, '2021-10-24')");
                if (insert1 > 0 && insert2 > 0) {
                    conn.commit();
                } else {
                    conn.rollback();
                }
                textLog.info("Insert success");
                rs = stmt.executeQuery("SELECT * FROM test_db.jdbc_test LIMIT 3 OFFSET 2 WHERE id > 3");
                while (rs.next()) {
                    textLog.info("{} \t {} \t\t {}", rs.getInt(1), rs.getString(2), rs.getInt(3));
                }
                logger.trace("Connection and operations in Main success");
            }
        } catch (SQLException e) {
            logger.error("There was an error in the class Main", e);
        } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException x) {
                        logger.error("In finally ResultSet rs don't close",x);
                    }
                }
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException d) {
                        logger.error("In finally Statement stmt don't close",d);
                    }
                }
                if (conn != null) {
                    try {conn.close();
                    } catch (SQLException q) {
                        logger.error("In finally Connection conn don't close",q);
                    }
                }
        }


    }
}
