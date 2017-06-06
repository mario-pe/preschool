package dao;

import model.Grupa;
import model.Person;
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
                String dzien = resultSet.getString("dzien");
                Zajecia z = new Zajecia(id, przedmiot, godzina, rok, dzien);
                zajecia.add(z);
            }
            return zajecia;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Zajecia> zajeciaByIdNauczyciel(int idP) {
        ArrayList<Zajecia> zajecia = new ArrayList<>();
        try {

            PreparedStatement ps = this.conn.prepareStatement("call zajeciaByIdNauczyciel(?)");
            ps.setInt(1,idP);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_zajecia");
                String przedmiot = resultSet.getString("przedmiot");
                String godzina = resultSet.getString("godzina");
                String rok = resultSet.getString("rok_szkolny");
                String dzien = resultSet.getString("dzien");
                Zajecia z = new Zajecia(id, przedmiot, godzina, rok, dzien);
                zajecia.add(z);
            }
            return zajecia;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Zajecia> grupaByIdOpiekunka(int idP) {
        ArrayList<Zajecia> zajecia = new ArrayList<>();
        try {

            PreparedStatement ps = this.conn.prepareStatement("call grupaByIdOpiekunka(?)");
            ps.setInt(1,idP);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_zajecia");
                String przedmiot = resultSet.getString("przedmiot");
                String godzina = resultSet.getString("godzina");
                String rok = resultSet.getString("rok_szkolny");
                String dzien = resultSet.getString("dzien");
                Zajecia z = new Zajecia(id, przedmiot, godzina, rok, dzien);
                zajecia.add(z);
            }
            return zajecia;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Zajecia selectZajeciaByID(int idZ) {
        try {

            PreparedStatement ps = this.conn.prepareStatement("call selectZajeciaByID(?)");
            ps.setInt(1, idZ);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_zajecia");
                String przedmiot = resultSet.getString("przedmiot");
                String godzina = resultSet.getString("godzina");
                String rok = resultSet.getString("rok_szkolny");
                String dzien = resultSet.getString("dzien");
                Zajecia z = new Zajecia(id, przedmiot, godzina, rok, dzien);
                return z;
            }
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

    public boolean editZajecia(int id, String przedmiot, String godzina, String rok, String dzien) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call editZajecia(?,?,?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, przedmiot);
            ps.setString(3, godzina);
            ps.setString(4, rok);
            ps.setString(5, dzien);
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

    public ArrayList<Person> getChildListZajecia(int idZ) {
        ArrayList<Person> children = new ArrayList<>();
        try {

            PreparedStatement ps = this.conn.prepareStatement("call getChildListZajecia(?)");
            ps.setInt(1, idZ);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_dziecko");
                String name = resultSet.getString("imie");
                String surname = resultSet.getString("nazwisko");
                String city = resultSet.getString("miejscowosc");
                String street = resultSet.getString("ulica");
                String home = resultSet.getString("dom");
                Person child = new Person(id, name, surname, city, street, home);
                children.add(child);
            }
            return children;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
