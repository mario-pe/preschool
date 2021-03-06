package model;

/**
 * Created by mario on 02.06.2017.
 */
public class Zajecia {
    private int id;
    private String przedmiot;
    private String godzina;
    private String rok;
    private String dzien;

    public Zajecia(int id, String przedmiot, String godzina, String rok, String dzien) {
        this.id = id;
        this.przedmiot = przedmiot;
        this.godzina = godzina;
        this.rok = rok;
        this.dzien = dzien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(String przedmiot) {
        this.przedmiot = przedmiot;
    }

    public String getGodzina() {
        return godzina;
    }

    public void setGodzina(String godzina) {
        this.godzina = godzina;
    }

    public String getRok() {
        return rok;
    }

    public void setRok(String rok) {
        this.rok = rok;
    }

    public String getDzien() {
        return dzien;
    }

    public void setDzien(String dzien) {
        this.dzien = dzien;
    }
}
