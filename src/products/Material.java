package products;

import java.io.Serializable;

public class Material implements Produkty, Serializable {
    private String typ;
    private int pocet;



    public Material (String typ){
        this.typ = typ;
        pocet = 0;
    }

    @Override
    public int getPocet() {
        return pocet;
    }

    @Override
    public void pridajPocet(int cislo) {
        this.pocet += cislo;
    }
}
