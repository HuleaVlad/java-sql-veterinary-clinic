package sample.DataAccessObjects;

import sample.Proprietar;
import sample.SqlConf;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by HV on 17-Jan-18.
 */
public class ProprietarDAO {
    public static ArrayList<Proprietar> ProprietarGET() {
        CallableStatement cStmt = null;
        ResultSet rs = null;
        ArrayList<Proprietar> proprietari = new ArrayList<>();
        try {
            SqlConf.dbConnect();
            cStmt = SqlConf.getConnection().prepareCall("{call [dbo].[ProprietarSEARCH]()}",
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
                Proprietar proprietar = new Proprietar();
                proprietar.setIdProprietar(rs.getInt("id_proprietar"));
                proprietar.setNumeProprietar(rs.getString("nume_proprietar"));
                proprietar.setPrenumePropr(rs.getString("prenume_proprietar"));
                proprietar.setMailProprietar(rs.getString("mail_proprietar"));
                proprietar.setTelefonProprietar(rs.getInt("telefon_proprietar"));

                proprietari.add(proprietar);
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
        return proprietari;
    }

}
