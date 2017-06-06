package model;

/**
 * Created by mario on 06.06.2017.
 */
public class Nauczyciel extends Pracownik {
    private String stopien;
    private String przedmiot;


    public Nauczyciel(int id, String imie, String nazwisko, String stanowisko) {
        super(id, imie, nazwisko, stanowisko);
    }

    public Nauczyciel(int id, String imie, String nazwisko, String stanowisko, String stopień, String przedmiot) {
        super(id, imie, nazwisko, stanowisko);
        this.stopien = stopień;
        this.przedmiot = przedmiot;
    }

    public String getStopien() {
        return stopien;
    }

    public void setStopien(String stopien) {
        this.stopien = stopien;
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(String przedmiot) {
        this.przedmiot = przedmiot;
    }
}
