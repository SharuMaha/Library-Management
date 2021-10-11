package Lib.manag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Table {
    String nomTable = Table.class.getSimpleName();
    Connect conn = new Connect();
    int numbAttributesInstance;
    ResultSet resultatInstance;
    ResultSetMetaData resultatInstanceRsmd;
    ArrayList<Object> instanceTotale = new ArrayList<Object>();
    ArrayList<String> nomColonnes = new ArrayList<String>();
    ArrayList<String> typeColonnes = new ArrayList<String>();
    Table(ResultSet resultatInstance) throws SQLException {
        this.resultatInstance = resultatInstance;
        resultatInstanceRsmd = resultatInstance.getMetaData();


        int numbAttributesInstance = resultatInstanceRsmd.getColumnCount() ;
        for (int i = 1; i<= numbAttributesInstance; i++) {


            nomColonnes.add(resultatInstanceRsmd.getColumnName(i));
            typeColonnes.add(resultatInstanceRsmd.getColumnTypeName(i));
            instanceTotale.add(resultatInstance.getObject(i));
        }

    }
    Table(ArrayList<Object> InstanceACreer) {
        this.instanceTotale = InstanceACreer;
    }


    void insertdb() throws SQLException {
            conn.connect();
            String valeursInserer = "INSERT ignore INTO " + nomTable+ " VALUES (";
            for (int i = 0; i<instanceTotale.size();i++) {
                valeursInserer += (instanceTotale.get(i));
                if (i < instanceTotale.size()-1) {
                    valeursInserer +=",";
                }
                }
            valeursInserer += ");";



            PreparedStatement insertion = conn.con.prepareStatement(valeursInserer);
            insertion.executeUpdate();
            insertion.close();
            conn.con.commit();
            }

    @Override
    public String toString() {
        return ""+ instanceTotale;
    }
}





