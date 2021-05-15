package managment;


import java.io.Serializable;
import java.util.ArrayList;

public abstract class Manazer implements Serializable {
    protected int rozpocet;

    ArrayList<Objednavka> objednavky = new ArrayList<>();

    public void setTyp(String typ) {
        this.typ = typ;
    }

    protected String typ;

}
