package Lib.manag;

import java.sql.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Connect conn = new Connect();
        conn.connect();
        Statement statement = null;
        try {
            statement = conn.con.createStatement();

            ResultSet resultat = statement.executeQuery("SELECT * FROM Auteurs");
            int i = 0;
            Object[] auteurs = new Object[2];
            while(resultat.next()) {
                Auteurs a = new Auteurs(resultat);
                auteurs[i] = Arrays.toString(a.auteur);
                i++;
            }
            conn.connect_end();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}




