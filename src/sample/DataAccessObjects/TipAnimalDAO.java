package sample.DataAccessObjects;

import sample.TipAnimal;
import sample.SqlConf;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by HV on 17-Jan-18.
 */
public class TipAnimalDAO {
    public static ArrayList<TipAnimal> TipAnimalGET() {
        CallableStatement cStmt = null;
        ResultSet rs = null;
        ArrayList<TipAnimal> tipanimalArrayList = new ArrayList<>();
        try {
            SqlConf.dbConnect();
            cStmt = SqlConf.getConnection().prepareCall("{call [dbo].[TipAnimalSEARCH]()}",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            boolean results = cStmt.execute();
            int rowsAffected = 0;

            while (results || rowsAffected != -1) {
                if (results) {
                    rs = cStmt.getResultSet();
                    break;
                } else {
                    rowsAffected = cStmt.getUpdateCount();
                }
                results = cStmt.getMoreResults();
            }
            while (rs != null && rs.next()) {
                TipAnimal tipanimal = new TipAnimal();
                tipanimal.setIdTipAnimal(rs.getInt("id_tip_animal"));
                tipanimal.setNumeAnimal(rs.getString("nume_animal"));
                tipanimal.setDescriereAnimal(rs.getString("descriere_animal"));

                tipanimalArrayList.add(tipanimal);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (cStmt != null) {
                try {
                    cStmt.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
        System.out.println("Select - DONE!");
        return tipanimalArrayList;
    }
}
