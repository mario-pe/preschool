package dao;

import model.Person;
import model.Pracownik;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by mario on 30.05.2017.
 */
public class PracownikDao {
    private Connection conn;

    public PracownikDao(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<Pracownik> getAllPracownicy() {
        ArrayList<Pracownik> pracownicy = new ArrayList<>();
        try {
            PreparedStatement ps = this.conn.prepareStatement("call allPracownik()");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_pracownik");
                String name = resultSet.getString("imie");
                String surname = resultSet.getString("nazwisko");
                Pracownik pracownik = new Pracownik(id, name, surname);
                pracownicy.add(pracownik);
            }
            return pracownicy;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deletePracownik(int id) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call deletePracownik(?)");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean editPracownik(int id, String name, String surename) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call editPracownik(?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, surename);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addPracownik(String name, String surename) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call addPracownik(?,?)");

            ps.setString(1, name);
            ps.setString(2, surename);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean detailsPracownik(int id) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call detailsPracownik(?)");
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Pracownik selectNauczycielByIdZajecia(int idZ){
        try {
            PreparedStatement ps = this.conn.prepareStatement("call selectNauczycielByIdZajecia(?)");
            ps.setInt(1,idZ);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_pracownik");
                String name = resultSet.getString("imie");
                String surname = resultSet.getString("nazwisko");
                Pracownik pracownik = new Pracownik(id, name, surname);
                return pracownik;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Pracownik> selectNauczycielByIdGrupa(int idZ){
        ArrayList<Pracownik> nauczycielList = new ArrayList<>();
        try {
            PreparedStatement ps = this.conn.prepareStatement("call selectNauczycielByIdGrupa(?)");
            ps.setInt(1,idZ);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_pracownik");
                String name = resultSet.getString("imie");
                String surname = resultSet.getString("nazwisko");
                Pracownik pracownik = new Pracownik(id, name, surname);
                nauczycielList.add(pracownik);
            }
            return nauczycielList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Pracownik> selectOpiekunByIdGrupa(int idZ){
        ArrayList<Pracownik> opiekunList = new ArrayList<>();
        try {
            PreparedStatement ps = this.conn.prepareStatement("call selectOpiekunByIdGrupa(?)");
            ps.setInt(1,idZ);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_pracownik");
                String name = resultSet.getString("imie");
                String surname = resultSet.getString("nazwisko");
                Pracownik pracownik = new Pracownik(id, name, surname);
                opiekunList.add(pracownik);
            }
            return opiekunList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Pracownik selectSprzataczkaByIdGrupa(int idZ){
        try {
            PreparedStatement ps = this.conn.prepareStatement("call selectSprzataczkaByIdGrupa(?)");
            ps.setInt(1,idZ);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_pracownik");
                String name = resultSet.getString("imie");
                String surname = resultSet.getString("nazwisko");
                Pracownik pracownik = new Pracownik(id, name, surname);
                return pracownik;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

