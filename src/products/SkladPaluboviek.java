package products;

import managment.Produkcia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SkladPaluboviek implements SledovatelPaluboviek, Serializable {

    PalubovkaVW palubovkaVW;
    PalubovkaAudi palubovkaAudi;

    public SkladPaluboviek(PalubovkaVW vw, PalubovkaAudi audi){
        this.palubovkaVW =vw;
        this.palubovkaAudi = audi;
    }

    private int pocetAudi,pocetVW;


    public int getPocetAudi() {
        return pocetAudi;
    }


    public int getPocetVW() {
        return pocetVW;
    }

    @Override
    public void upovedomVW() {
        this.pocetVW = palubovkaVW.getPocet();
    }

    @Override
    public void upovedomAudi() {
        this.pocetAudi = palubovkaAudi.getPocet();
    }



}
