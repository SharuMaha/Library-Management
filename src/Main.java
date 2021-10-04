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
            Object[][] liste = new Object[10][3];

            Auteurs a = new Auteurs(resultat);

            System.out.println(Arrays.toString(a.auteur));
            conn.connect_end();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}




