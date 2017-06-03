package dao;

import model.Grupa;
import model.Zajecia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by mario on 02.06.2017.
 */
public class ZajeciaDao {
    private Connection conn;

    public ZajeciaDao(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<Zajecia> getAllZajecia() {
        ArrayList<Zajecia> zajecia = new ArrayList<>();
        try {

            PreparedStatement ps = this.conn.prepareStatement("call allZ()");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_zajecia");
                String przedmiot = resultSet.getString("przedmiot");
                String godzina = resultSet.getString("godzina");
                String rok = resultSet.getString("rok_szkolny");
                Zajecia z = new Zajecia(id, przedmiot, godzina, rok);
                zajecia.add(z);
            }
            return zajecia;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteZajecia(int id) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call deleteZajecia(?)");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean editZajecia(int id, String przedmiot, String godzina, String rok) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call editZajecia(?,?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, przedmiot);
            ps.setString(3, godzina);
            ps.setString(4, rok);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addZajecia(String przedmiot, String godzina, String rok) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call addZajęcia(?,?,?)");
            ps.setString(1, przedmiot);
            ps.setString(2, godzina);
            ps.setString(3, rok);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean detailsZajecia(int id) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call organizacjaZajecia(?)");
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
