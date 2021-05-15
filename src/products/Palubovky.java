package products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Palubovky implements Produkty,Serializable {
    private String typ;
    private double cena;
    private int pocet;



    public Palubovky (String typ,double cena){
        this.typ = typ;
        pocet = 0;
        this.cena = cena;
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
