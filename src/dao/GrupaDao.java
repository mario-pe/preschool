package dao;

import model.Grupa;
import model.Person;

import java.lang.reflect.Executable;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by mario on 30.05.2017.
 */
public class GrupaDao {
    private Connection conn;

    public GrupaDao(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<Grupa> getAllGroups() {
        ArrayList<Grupa> groups = new ArrayList<>();
        try {
//            Statement statement = this.conn.createStatement();
//            statement.execute("SELECT * FROM grupa");
//            ResultSet resultSet = statement.getResultSet();
            PreparedStatement ps = this.conn.prepareStatement("call allGrupy()");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_grupa");
                String kat = resultSet.getString("kat_wiekowa");
                int sala = resultSet.getInt("sala");
                String rok = resultSet.getString("rok_szkolny");
                Grupa grupa = new Grupa(id, kat, sala, rok);
                groups.add(grupa);
            }
            return groups;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteGrupa(int id) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call deleteGrupa(?)");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean editGrupa(int id, String kat, int sala, String rok) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call editGrupa(?,?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, kat);
            ps.setInt(3, sala);
            ps.setString(4, rok);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addGrupa(String kat, int sala, String rok) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call addGrupa(?,?,?)");
            ps.setString(1, kat);
            ps.setInt(2, sala);
            ps.setString(3, rok);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }




}

