package model;

/**
 * Created by mario on 06.06.2017.
 */
public class Opiekunka extends Pracownik {
    private String specjalnosc;

    public String getSpecjalnosc() {
        return specjalnosc;
    }

    public void setSpecjalnosc(String specjalnosc) {
        this.specjalnosc = specjalnosc;
    }

    public Opiekunka(int id, String imie, String nazwisko, String stanowisko, String specjalnosc) {
        super(id, imie, nazwisko, stanowisko);
        this.specjalnosc = specjalnosc;
    }

    public Opiekunka(int id, String imie, String nazwisko, String stanowisko) {
        super(id, imie, nazwisko, stanowisko);
    }

}
