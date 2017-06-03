package dao;

import model.Grupa;
import model.Person;
import model.Zajecia;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by mario on 28.05.2017.
 */
public class PersonDao {
    private Connection conn;

    public PersonDao(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<Person> getAllChildren() {
        ArrayList<Person> children = new ArrayList<>();
        try {

            PreparedStatement ps = this.conn.prepareStatement("call allChildren()");
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

    public boolean deleteChild(int id) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call deleteChild(?)");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean editChild(int id, String name, String surename, String city, String street, String home) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call editChild(?,?,?,?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, surename);
            ps.setString(4, city);
            ps.setString(5, street);
            ps.setString(6, home);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addChild(String name, String surename, String city, String street, String home) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call addChild(?,?,?,?,?)");

            ps.setString(1, name);
            ps.setString(2, surename);
            ps.setString(3, city);
            ps.setString(4, street);
            ps.setString(5, home);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Person> getKeeper(int id_opiekuna){
        ArrayList<Person> opiekunowie = new ArrayList<>();
        try {
            PreparedStatement ps = this.conn.prepareStatement("call getOpiekun(?)");
            ps.setInt(1, id_opiekuna);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("imie");
                String surname = resultSet.getString("nazwisko");
                String city = resultSet.getString("miejscowosc");
                String street = resultSet.getString("ulica");
                String home = resultSet.getString("dom");
                Person child = new Person(id, name, surname, city, street, home);
                opiekunowie.add(child);
            }return opiekunowie;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Grupa> getGrupaDziecko(int id_dziecka){
        ArrayList<Grupa> grupy = new ArrayList<>();

        try{PreparedStatement ps = this.conn.prepareStatement("call getGrupaDziecko(?)");
        ps.setInt(1, id_dziecka);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id_grupa");
            String kat = resultSet.getString("kat_wiekowa");
            int sala = resultSet.getInt("sala");
            String rok = resultSet.getString("rok_szkolny");
            Grupa grupa = new Grupa(id,kat,sala,rok);
            grupy.add(grupa);
        }return grupy;
        }catch(SQLException e) {
                e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Zajecia> getZajeciaDziecko(int id_dziecka){
        ArrayList<Zajecia> zajecia = new ArrayList<>();

        try{PreparedStatement ps = this.conn.prepareStatement("call getZajeciaDziecko(?)");
            ps.setInt(1, id_dziecka);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_zajecia");
                String przedmiot = resultSet.getString("przedmiot");
                String godzina = resultSet.getString("godzina");
                String rok = resultSet.getString("rok_szkolny");
                Zajecia z = new Zajecia(id,przedmiot,godzina,rok);
                zajecia.add(z);
            }return zajecia;
        }catch(SQLException e) {
            e.printStackTrace();
            return null;

        }
//        return null;
    }
    public boolean addKeeper(String name, String surename, String city, String street, String home) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call addKeeper(?,?,?,?,?)");

            ps.setString(1, name);
            ps.setString(2, surename);
            ps.setString(3, city);
            ps.setString(4, street);
            ps.setString(5, home);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean reltationChildKeeper(int idChild, int idKeeper){
        try {
            PreparedStatement ps = this.conn.prepareStatement("call reltationChildKeeper(?,?)");
            ps.setInt(1, idChild);
            ps.setInt(2, idKeeper);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteKeeper(int id) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call deleteKeeper(?)");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public int getKeeper(String name, String surename, String city,String street, String home){

        try {
            PreparedStatement ps = this.conn.prepareStatement("call addKeeper(?,?,?,?,?)");

            ps.setString(1, name);
            ps.setString(2, surename);
            ps.setString(3, city);
            ps.setString(4, street);
            ps.setString(5, home);
            ResultSet rs = ps.executeQuery();
            int id = rs.getInt("id_opiekun");

            return id;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }


    }

}