package model;

/**
 * Created by mario on 30.05.2017.
 */
public class Grupa {
    private int id;
    private String kat;
    private int sala;
    private String rok;

    public Grupa(int id) {
        this.id = id;
    }

    public Grupa(int id, String kat) {
        this.id = id;
        this.kat = kat;
    }

    public Grupa(int id, String kat, int sala) {
        this.id = id;
        this.kat = kat;
        this.sala = sala;
    }

    public Grupa(int id, String kat, int sala, String rok) {
        this.id = id;
        this.kat = kat;
        this.sala = sala;
        this.rok = rok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKat() {
        return kat;
    }

    public void setKat(String kat) {
        this.kat = kat;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getRok() {
        return rok;
    }

    public void setRok(String rok) {
        this.rok = rok;
    }
}
