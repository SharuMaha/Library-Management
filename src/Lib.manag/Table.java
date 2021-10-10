package Lib.manag;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Table {
    int numbAttributesInstance;
    ResultSetMetaData[] resultatInstanceRsmd;
    ArrayList<Object> instanceTotale;
    ArrayList<String> nomColonnes;
    ArrayList<String> typeColonnes;
    Table(ResultSet resultatInstance) throws SQLException {

        ResultSetMetaData resultatInstanceRsmd = null;
        try {
            resultatInstanceRsmd = resultatInstance.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            int numbAttributesInstance = resultatInstanceRsmd.getColumnCount() ;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        for (int i = 0; i< numbAttributesInstance; i++) {
            nomColonnes.add(resultatInstanceRsmd.getColumnName(i));
            typeColonnes.add(resultatInstanceRsmd.getColumnTypeName(i));
            instanceTotale.add(resultatInstance.getObject(i));
        }





    }


}
