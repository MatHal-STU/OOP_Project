package managment;


import products.Sklad;

public abstract class Manazer {
    protected int rozpocet;

    Sklad sklad = Sklad.getInstance();


    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    protected String typ;

}
