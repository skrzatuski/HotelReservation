package config;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBExistCheck {
    private String dbname;
    private String catalogs;
    boolean dbStatus = false;
    Connection conDB = null;
    ResultSet rs = null;
    public void checkIfDbExists(){
        try {
            dbname = "hotel";
            conDB = DatabaseConnection.getCon();

            if (conDB != null) {
                dbStatus = true;
                System.out.println("Connection successful, checking db exists");
                rs = conDB.getMetaData().getCatalogs();
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