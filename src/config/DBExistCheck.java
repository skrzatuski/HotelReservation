package config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBExistCheck {
    private String dbname;
    private String catalogs;
    boolean dbStatus = false;
    Connection con = null;
    ResultSet rs = null;
    DatabaseConnection databaseConnection;
    public void checkIfDbExists(){
        try {
            dbname = "hotel";
            con = DatabaseConnection.getCon();

            if (con != null) {
                dbStatus = true;
                System.out.println("Connection successful, checking db exists");
                rs = con.getMetaData().getCatalogs();
            while (rs.next()) {
                catalogs = rs.getString(1);
                if (dbname.equals(catalogs)) {
                    System.out.println("Database " + dbname + " exists");
                }
            }
        }else{
                System.out.println("Unable to connect to DB");
                dbStatus = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean isDbStatus() {
        return dbStatus;
    }
}
