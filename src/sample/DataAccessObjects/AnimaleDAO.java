package sample.DataAccessObjects;

import sample.Animale;
import sample.SqlConf;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by HV on 17-Jan-18.
 */


public class AnimaleDAO {
    public static ArrayList<Animale> AnimaleProprietarGET(String numeProprietar, String prenumeProprietar) {
        CallableStatement cStmt = null;
        ResultSet rs = null;
        ArrayList<Animale> animale = new ArrayList<>();
        try {
            SqlConf.dbConnect();
            cStmt = SqlConf.getConnection().prepareCall("{call [dbo].[AnimaleTabProprietarSearch](?, ?)}",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            cStmt.setString("nume_proprietar",numeProprietar );
            cStmt.setString("prenume_proprietar", prenumeProprietar);


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

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

// The column count starts from 1
            for (int i = 1; i <= columnCount; i++ ) {
                System.out.println( rsmd.getColumnName(i));
                // Do stuff with name
            }

            while (rs != null && rs.next()) {
                Animale animal = new Animale();
                animal.setIdAnimal(rs.getInt("id_animal"));
                animal.setGreutate(rs.getInt("greutate"));
                animal.setSex(rs.getString("sex"));
                animal.setdataNasterii(rs.getDate("data_nasterii"));
                animal.setIdHrana(rs.getInt("id_hrana"));
                animal.setIdProprietar(rs.getInt("id_proprietar"));
                animal.setTipHrana(rs.getString("tip_hrana"));
                animal.setNumeProprietar(rs.getString("nume_proprietar"));
                animal.setPrenumeProprietar((rs.getString("prenume_proprietar")));
                animal.setNumeAnimal((rs.getString("nume_animal")));

                animale.add(animal);
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
        return animale;
    }

    public static ArrayList<Animale> AnimaleVeterinarGET(String numeVeterinar, String prenumeVeterinar) {
        CallableStatement cStmt = null;
        ResultSet rs = null;
        ArrayList<Animale> animale = new ArrayList<>();
        try {
            SqlConf.dbConnect();
            cStmt = SqlConf.getConnection().prepareCall("{call [dbo].[AnimaleTabVeterinarSEARCH](?, ?)}",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            cStmt.setString("nume_v",numeVeterinar );
            cStmt.setString("prenume_v", prenumeVeterinar);


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
                Animale animal = new Animale();
                animal.setIdAnimal(rs.getInt("id_animal"));
                animal.setGreutate(rs.getInt("greutate"));
                animal.setSex(rs.getString("sex"));
                animal.setdataNasterii(rs.getDate("data_nasterii"));
                animal.setIdHrana(rs.getInt("id_hrana"));
                animal.setIdProprietar(rs.getInt("id_proprietar"));
                animal.setTipHrana(rs.getString("tip_hrana"));
                animal.setNumeProprietar(rs.getString("nume_proprietar"));
                animal.setPrenumeProprietar((rs.getString("prenume_proprietar")));
                animal.setNumeAnimal((rs.getString("nume_animal")));

                animale.add(animal);
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
        return animale;
    }

    public static ArrayList<Animale> AnimaleREFRESHGET() {
        CallableStatement cStmt = null;
        ResultSet rs = null;
        ArrayList<Animale> animale = new ArrayList<>();
        try {
            SqlConf.dbConnect();
            cStmt = SqlConf.getConnection().prepareCall("{call [dbo].[AnimaleREFRESH]()}",
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
                Animale animal = new Animale();
                animal.setIdAnimal(rs.getInt("id_animal"));
                animal.setNumeAnimal(rs.getString("nume_animal"));
                animal.setGreutate(rs.getInt("greutate"));
                animal.setSex(rs.getString("sex"));
                animal.setdataNasterii(rs.getDate("data_nasterii"));
                animal.setTipHrana(rs.getString("tip_hrana"));
                animal.setNumeProprietar(rs.getString("nume_proprietar"));
                animal.setPrenumeProprietar(rs.getString("prenume_proprietar"));



                animale.add(animal);
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
        return animale;
    }

    public static void AnimaleINS(Animale animal) {
        CallableStatement cStmt = null;
        ResultSet rs = null;
        try {
            SqlConf.dbConnect();
            cStmt = SqlConf.getConnection().prepareCall("{call [dbo].[AnimaleINS](?, ?, ?, ?, ?, ?, ?, ?,?)}",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            cStmt.registerOutParameter("id_animal", Types.INTEGER);
            cStmt.setInt("greutate", animal.getGreutate());
            cStmt.setString("sex", String.valueOf(animal.getSex()));
            cStmt.setString("descriere", String.valueOf(animal.getDescriere()));
            cStmt.setDate("data_nasterii", java.sql.Date.valueOf(animal.getDataNasterii().toString()));
            cStmt.setString("nume_animal", String.valueOf(animal.getNumeAnimal()));
            cStmt.setString("tip_hrana", String.valueOf(animal.getTipHrana()));
            cStmt.setString("nume_proprietar", String.valueOf(animal.getNumeProprietar()));
            cStmt.setString("prenume_proprietar", String.valueOf(animal.getPrenumeProprietar()));




            cStmt.execute();
            animal.setIdAnimal(cStmt.getInt("id_animal"));
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

    public static void AnimaleUPD(Animale animal) {
        CallableStatement cStmt = null;
        ResultSet rs = null;
        try {
            SqlConf.dbConnect();
            cStmt = SqlConf.getConnection().prepareCall("{call [dbo].[AnimaleUPD](?, ?, ?, ?, ?, ?, ?, ?, ?)}",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            cStmt.setInt("id_animal", animal.getIdAnimal());
            cStmt.setString("nume_proprietar", animal.getNumeProprietar());
            cStmt.setInt("greutate", animal.getGreutate());
            cStmt.setString("sex", String.valueOf(animal.getSex()));
            cStmt.setString("descriere", String.valueOf(animal.getDescriere()));
            cStmt.setDate("data_nasterii", animal.getDataNasterii());
            cStmt.setString("tip_hrana", animal.getTipHrana());
            cStmt.setString("prenume_proprietar", animal.getPrenumeProprietar());
            cStmt.setString("nume_animal", String.valueOf(animal.getNumeAnimal()));


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

    public static void AnimaleDEL(Animale animal) {
        CallableStatement cStmt = null;
        ResultSet rs = null;

        try {
            SqlConf.dbConnect();
            cStmt = SqlConf.getConnection().prepareCall("{call [dbo].[AnimaleDEL](?)}",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            cStmt.setInt("id_animal", animal.getIdAnimal());

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
