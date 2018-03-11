package sample.DataAccessObjects;

import sample.Tratament;
import sample.SqlConf;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by HV on 17-Jan-18.
 */
public class TratamentDAO {    public static ArrayList<Tratament> TratamentGET() {
    CallableStatement cStmt = null;
    ResultSet rs = null;
    ArrayList<Tratament> tratamentArrayList = new ArrayList<>();
    try {
        SqlConf.dbConnect();
        cStmt = SqlConf.getConnection().prepareCall("{call [dbo].[TratamentSEARCH]()}",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        rs = cStmt.executeQuery();

        while (rs.next()) {
            Tratament tratament = new Tratament();
            tratament.setIdTratament(rs.getInt("id_tratament"));
            tratament.setNumeMedicament(rs.getString("nume_medicament"));
            tratament.setFolosireMedicament(rs.getString("folosire_medicament"));

            tratamentArrayList.add(tratament);
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
    return tratamentArrayList;
}

}
