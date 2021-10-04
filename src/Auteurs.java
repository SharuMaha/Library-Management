import java.sql.*;

public class Auteurs {
    String[] auteur = new String[3];

    Auteurs(ResultSet resultat) {
        auteur[0] = resultat.getString("id_auteur");
        auteur[1] = resultat.getString("prénom");
        auteur[2] = resultat.getString("nom");

    }
}
