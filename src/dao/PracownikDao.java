package dao;

import model.*;

import java.sql.*;
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
                String position = resultSet.getString("stanowisko");
                Pracownik pracownik = new Pracownik(id, name, surname, position);
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

    public boolean addPracownik(String name, String surename, String stanowisko) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call addPracownik(?,?,?)");

            ps.setString(1, name);
            ps.setString(2, surename);
            ps.setString(3, stanowisko);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Pracownik selectNauczycielByIdZajecia(int idZ) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call selectNauczycielByIdZajecia(?)");
            ps.setInt(1, idZ);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_pracownik");
                String name = resultSet.getString("imie");
                String surname = resultSet.getString("nazwisko");
//                String position = resultSet.getString("stanowisko");
                Pracownik pracownik = new Pracownik(id, name, surname);//, position);
                return pracownik;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Pracownik> selectNauczycielByIdGrupa(int idZ) {
        ArrayList<Pracownik> nauczycielList = new ArrayList<>();
        try {
            PreparedStatement ps = this.conn.prepareStatement("call selectNauczycielByIdGrupa(?)");
            ps.setInt(1, idZ);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_pracownik");
                String name = resultSet.getString("imie");
                String surname = resultSet.getString("nazwisko");
//                String position = resultSet.getString("stanowisko");
                Pracownik pracownik = new Pracownik(id, name, surname);//, position);
                nauczycielList.add(pracownik);
            }
            return nauczycielList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Pracownik> selectOpiekunByIdGrupa(int idZ) {
        ArrayList<Pracownik> opiekunList = new ArrayList<>();
        try {
            PreparedStatement ps = this.conn.prepareStatement("call selectOpiekunByIdGrupa(?)");
            ps.setInt(1, idZ);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_pracownik");
                String name = resultSet.getString("imie");
                String surname = resultSet.getString("nazwisko");
//                String position = resultSet.getString("stanowisko");
                Pracownik pracownik = new Pracownik(id, name, surname);//, position);
                opiekunList.add(pracownik);
            }
            return opiekunList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Pracownik selectSprzataczkaByIdGrupa(int idZ) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call selectSprzataczkaByIdGrupa(?)");
            ps.setInt(1, idZ);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_pracownik");
                String name = resultSet.getString("imie");
                String surname = resultSet.getString("nazwisko");
//                String position = resultSet.getString("stanowisko");
                Pracownik pracownik = new Pracownik(id, name, surname);//, position);
                return pracownik;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Pracownik selectPracownik(int idP) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call selectPracownikById(?)");
            ps.setInt(1, idP);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_pracownik");
                String name = resultSet.getString("imie");
                String surname = resultSet.getString("nazwisko");
                String position = resultSet.getString("stanowisko");
                Pracownik pracownik = new Pracownik(id, name, surname, position);
                return pracownik;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Pracownik selectPracownik(String imie, String nazwisko) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call selectPracownikByImieNazwisko(?,?)");
            ps.setString(1, imie);
            ps.setString(2, nazwisko);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_pracownik");
                String name = resultSet.getString("imie");
                String surname = resultSet.getString("nazwisko");
                String position = resultSet.getString("stanowisko");
                Pracownik pracownik = new Pracownik(id, name, surname, position);
                return pracownik;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addUmowa(String type, String date) {

        try {
            PreparedStatement ps = this.conn.prepareStatement("call addUmowa(?,?)");

            ps.setString(1, type);
            ps.setString(2, date);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Umowa selectUmowa(String type, String date) {

        try {
            PreparedStatement ps = this.conn.prepareStatement("call selectUmowa(?,?)");

            ps.setString(1, type);
            ps.setString(2, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_umowa");
                String typeQ = rs.getString("type");
                Timestamp dateQ = rs.getTimestamp("date");
                Umowa umowa = new Umowa(id, typeQ, dateQ);
                return umowa;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Umowa selectUmowa(int idP) {

        try {
            PreparedStatement ps = this.conn.prepareStatement("call selectUmowaById(?)");

            ps.setInt(1, idP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_umowa");
                String typeQ = rs.getString("type");
                Timestamp dateQ = rs.getTimestamp("date");
                Umowa umowa = new Umowa(id, typeQ, dateQ);
                return umowa;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addPodpisuje(int idP, int idU) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call addPodpisuje(?,?)");

            ps.setInt(1, idP);
            ps.setInt(2, idU);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Umowa> selectListUmowaByIdPracownik(int idP) {

        ArrayList<Umowa> umowaList = new ArrayList<>();
        try {
            PreparedStatement ps = this.conn.prepareStatement("call selectListUmowaByIdPracownik(?)");

            ps.setInt(1, idP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_umowa");
                String typeQ = rs.getString("type");
                Timestamp dateQ = rs.getTimestamp("date");
                Umowa umowa = new Umowa(id, typeQ, dateQ);
                umowaList.add(umowa);
            }
            return umowaList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addKucharka(int id, String badania) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call addKucharka(?,?)");

            ps.setInt(1, id);
            ps.setString(2, badania);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addNauczyciel(int id, String stopien, String przedmiot) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call addNauczyciel(?,?,?)");

            ps.setInt(1, id);
            ps.setString(2, stopien);
            ps.setString(3, przedmiot);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addOpiekunka(int id, String specjalnosc) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call addOpiekunka(?,?)");

            ps.setInt(1, id);
            ps.setString(2, specjalnosc);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addSprzataczka(int id) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call addSprzataczka(?)");

            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Nauczyciel selectNauczycielById(int idP) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call selectNauczycielById(?)");
            ps.setInt(1, idP);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_pracownik");
                String name = resultSet.getString("imie");
                String surname = resultSet.getString("nazwisko");
                String position = resultSet.getString("stanowisko");
                String stopień = resultSet.getString("stopien_zawodowy");
                String przedmiot = resultSet.getString("przedmiot");
                Nauczyciel nauczyciel = new Nauczyciel(id, name, surname, position, stopień, przedmiot);
                return nauczyciel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Opiekunka selectOpiekunkaById(int idP) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call selectOpiekunkaById(?)");
            ps.setInt(1, idP);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_pracownik");
                String name = resultSet.getString("imie");
                String surname = resultSet.getString("nazwisko");
                String position = resultSet.getString("stanowisko");
                String specjalnosc = resultSet.getString("specjalnosc");

                Opiekunka opiekunka = new Opiekunka(id, name, surname, position, specjalnosc);
                return opiekunka;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Timestamp selectDateKucharka(int idP) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call selectDateKucharka(?)");
            ps.setInt(1, idP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Timestamp date = rs.getTimestamp("badania");
                return date;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int selectGrupaSprzataczkaById(int idP) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("call selectGrupaSprzataczkaById(?)");
            ps.setInt(1, idP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_grupa");
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

