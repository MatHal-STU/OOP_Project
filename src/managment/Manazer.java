package managment;


import java.io.Serializable;
import java.util.ArrayList;

public abstract class Manazer implements Serializable {
    protected int rozpocet;


    public void setTyp(String typ) {
        this.typ = typ;
    }

    protected String typ;

}
