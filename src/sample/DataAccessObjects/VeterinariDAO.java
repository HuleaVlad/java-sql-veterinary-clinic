package sample.DataAccessObjects;

import sample.Veterinari;
import sample.SqlConf;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by HV on 17-Jan-18.
 */
public class VeterinariDAO {
    public static ArrayList<Veterinari> VeterinariGET() {
        CallableStatement cStmt = null;
        ResultSet rs = null;
        ArrayList<Veterinari> veterinari = new ArrayList<>();
        try {
            SqlConf.dbConnect();
            cStmt = SqlConf.getConnection().prepareCall("{call [dbo].[VeterinariSEARCH]()}",
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
                Veterinari veterinar = new Veterinari();
                veterinar.setIdVeterinar(rs.getInt("id_veterinar"));
                veterinar.setNumeVeterinar(rs.getString("nume_v"));
                veterinar.setPrenumeVeterinar(rs.getString("prenume_v"));
                veterinar.setAdresaVeterinar(rs.getString("adresa_v"));
                veterinar.setEmailVeterinar(rs.getString("email_v"));
                veterinar.setTelefonVeterinar(rs.getInt("telefon_v"));

                veterinari.add(veterinar);
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
        return veterinari;
    }

}
