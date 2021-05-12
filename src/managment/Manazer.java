package managment;


import java.io.Serializable;

public abstract class Manazer implements Serializable {
    protected int rozpocet;





    public void setTyp(String typ) {
        this.typ = typ;
    }

    protected String typ;

}
