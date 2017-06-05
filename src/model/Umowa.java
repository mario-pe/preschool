package model;

import java.sql.Timestamp;

/**
 * Created by mario on 05.06.2017.
 */
public class Umowa {
    private int id;
    private String type;
    private Timestamp date;

    public Umowa(int id,String type, Timestamp date) {
        this.id = id;
        this.type = type;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
