package sample.DataAccessObjects;

import sample.Consultatii;
import sample.Hrana;
import sample.SqlConf;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by HV on 17-Jan-18.
 */
public class HranaDAO {

    public static ArrayList<Hrana> HranaGET() {
    CallableStatement cStmt = null;
    ResultSet rs = null;
    ArrayList<Hrana> hranaArrayList = new ArrayList<>();
    try {
        SqlConf.dbConnect();
        cStmt = SqlConf.getConnection().prepareCall("{call [dbo].[HranaSEARCH]()}",
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
            Hrana hrana = new Hrana();
            hrana.setIdHrana(rs.getInt("id_hrana"));
            hrana.setTipHrana(rs.getString("tip_hrana"));
            hrana.setBrand(rs.getString("brand"));
            hrana.setPret(rs.getInt("pret"));

            hranaArrayList.add(hrana);
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
    return hranaArrayList;
}

}
