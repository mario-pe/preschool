package model;

/**
 * Created by mario on 30.05.2017.
 */
public class Pracownik {
    private int id;
    private String imie;
    private String nazwisko;
    private String stanowisko;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public Pracownik(int id, String imie, String nazwisko, String stanowisko) {

        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
    }

    public Pracownik(int id, String imie, String nazwisko) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
}
