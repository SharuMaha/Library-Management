package Lib.manag;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Connect conn = new Connect();
        conn.connect();
        Statement statement = null;
        try {
            statement = conn.con.createStatement();

            ResultSet resultat = statement.executeQuery("SELECT * FROM Auteurs");
            ArrayList<Auteur> auteurs = new ArrayList<Auteur>();
            int i = 0;
            ArrayList<Object> auteursEnString = new ArrayList<Object>();
            while(resultat.next()) {
                Auteur a = new Auteur(resultat);
                auteurs.add(a);
                auteursEnString.add(a.instanceTotale);
                i++;
            }



            conn.connect_end();
            System.out.println(auteurs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}




