package sample.DataAccessObjects;

import sample.Consultatii;
import sample.SqlConf;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;

public class ConsultatiiDAO {
    public static ArrayList<Consultatii> ConsultatiiAnimalGET(String numeAnimal, Integer idTratament) {
        CallableStatement cStmt = null;
        ResultSet rs = null;
        ArrayList<Consultatii>  consultatii = new ArrayList<>();
        try {
            SqlConf.dbConnect();
            cStmt = SqlConf.getConnection().prepareCall("{call [dbo].[ConsultatiiTabAnimaleSEARCH](?, ?)}",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            cStmt.setString("nume_animal",numeAnimal );
            cStmt.setInt("id_tratament", idTratament);


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
                Consultatii consultatie = new Consultatii();
                consultatie.setIdConsultatie(rs.getInt("id_consultatie"));
                consultatie.setDataConsultatie(rs.getDate("data_consultatie"));
                consultatie.setNumeVeterinar(rs.getString("nume_v"));
                consultatie.setPrenumeVeterinar(rs.getString("prenume_v"));
                consultatie.setNumeMedicament(rs.getString("nume_medicament"));

                consultatii.add(consultatie);
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
        return consultatii;
    }

    public static ArrayList<Consultatii> ConsultatiiConsultatieGET(Date dataConsultatie, Integer idVeterinar) {
        CallableStatement cStmt = null;
        ResultSet rs = null;
        ArrayList<Consultatii> consultatii = new ArrayList<>();
        try {
            SqlConf.dbConnect();
            cStmt = SqlConf.getConnection().prepareCall("{call [dbo].[ConsultatiiTabConsultatieSEARCH](?, ?)}",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            cStmt.setDate("data_consultatie", (java.sql.Date) dataConsultatie);
            cStmt.setInt("id_veterinar", idVeterinar);


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
                Consultatii consultatie = new Consultatii();
                consultatie.setIdConsultatie(rs.getInt("id_consultatie"));
                consultatie.setDataConsultatie(rs.getDate("data_consultatie"));
                consultatie.setNumeVeterinar(rs.getString("nume_v"));
                consultatie.setPrenumeVeterinar(rs.getString("prenume_v"));
                consultatie.setNumeMedicament(rs.getString("nume_medicament"));

                consultatii.add(consultatie);
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
        return consultatii;
    }

    public static ArrayList<Consultatii> ConsultatiiREFRESHGET() {
        CallableStatement cStmt = null;
        ResultSet rs = null;
        ArrayList<Consultatii> consultatii = new ArrayList<>();
        try {
            SqlConf.dbConnect();
            cStmt = SqlConf.getConnection().prepareCall("{call [dbo].[ConsultatiiREFRESH]()}",
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
                Consultatii consultatie = new Consultatii();
                consultatie.setIdConsultatie(rs.getInt("id_consultatie"));
                consultatie.setDataConsultatie(rs.getDate("data_consultatie"));
                consultatie.setNumeMedicament(rs.getString("nume_medicament"));
                consultatie.setNumeVeterinar(rs.getString("nume_v"));
                consultatie.setPrenumeVeterinar(rs.getString("prenume_v"));


                consultatii.add(consultatie);
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
        return consultatii;
    }

    public static void ConsultatiiINS(Consultatii consultatie) {
        CallableStatement cStmt = null;
        ResultSet rs = null;
        try {
            SqlConf.dbConnect();
            cStmt = SqlConf.getConnection().prepareCall("{call [dbo].[ConsultatiiINS](?, ?, ?, ?, ?, ?,?)}",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            cStmt.registerOutParameter("id_consultatie", Types.INTEGER);
            cStmt.setDate("data_consultatie", java.sql.Date.valueOf((consultatie.getDataConsultatie().toString())));
            cStmt.setString("diagnostic", String.valueOf(consultatie.getDiagnostic()));
            cStmt.setString("nume_medicament", String.valueOf(consultatie.getNumeMedicament()));
            cStmt.setInt("id_animal", consultatie.getIdAnimal());
            cStmt.setString("nume_veterinar", String.valueOf(consultatie.getNumeVeterinar()));
            cStmt.setString("prenume_veterinar", String.valueOf(consultatie.getPrenumeVeterinar()));


            cStmt.execute();
            consultatie.setIdAnimal(cStmt.getInt("id_consultatie"));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
            if (cStmt != null) {
                try {
                    cStmt.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }

        System.out.println("Insert - DONE!");
    }

    public static void ConsultatiiUPD(Consultatii consultatie) {
        CallableStatement cStmt = null;
        ResultSet rs = null;
        try {
            SqlConf.dbConnect();
            cStmt = SqlConf.getConnection().prepareCall("{call [dbo].[ConsultatiiUPD](?, ?, ?, ?, ?, ?)}",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            cStmt.setInt("id_consultatie", consultatie.getIdConsultatie());
            cStmt.setDate("data_consultatie", java.sql.Date.valueOf(consultatie.getDataConsultatie().toString()));
            cStmt.setString("diagnostic", String.valueOf(consultatie.getDiagnostic()));
            cStmt.setInt("id_tratament", consultatie.getIdTratament());
            cStmt.setInt("id_animal", consultatie.getIdAnimal());
            cStmt.setInt("id_veterinar", consultatie.getIdVeterinar());

            cStmt.execute();
            System.out.println("Done!");

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
        System.out.println("Update - DONE!");
    }

    public static void ConsultatiiDEL(Consultatii consultatie) {
        CallableStatement cStmt = null;
        ResultSet rs = null;

        try {
            SqlConf.dbConnect();
            cStmt = SqlConf.getConnection().prepareCall("{call [dbo].[ConsultatiiDEL](?)}",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            cStmt.setInt("id_consultatie", consultatie.getIdConsultatie());

            cStmt.execute();
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
        System.out.println("Delete - DONE!");
    }
}
