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
                System.out.println("Brak wlasciwej bazy danych");
                dbStatus = false;
            }
        } catch (SQLException throwables) {
            System.out.println(throwables);
        }
    }

    public boolean isDbStatus() {
        return dbStatus;
    }
}