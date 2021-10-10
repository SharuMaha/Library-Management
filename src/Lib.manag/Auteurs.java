package Lib.manag;

import java.sql.*;

public class Auteurs {
    String[] auteur = new String[3];

    Auteurs(ResultSet resultat) {
        try {
            auteur[0] = resultat.getString("id_auteur");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            auteur[1] = resultat.getString("prénom");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            auteur[2] = resultat.getString("nom");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
