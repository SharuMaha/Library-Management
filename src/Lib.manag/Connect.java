package Lib.manag;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    Connection con = null;
    public Connect(){

    }
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:Biblio.db");
            con.setAutoCommit(false);
            System.out.println("Ouverture bien effectuée");
            // Exception SQLException
        } catch (Exception e) {
            System.out.println("Impossible d'ouvrir");
            System.out.println(e);
        }


    }
    public void connect_end() {
        try {
            con.close();
            System.out.println("Fermeture bien effectuée");
        } catch(Exception e) {
            System.out.println("erreur fermeture");
        }
    }
}
