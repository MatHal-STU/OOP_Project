package products;

import java.io.Serializable;

public class Sklad implements SledovatelSkladu, Serializable {

    PalubovkaVW palubovkaVW;
    PalubovkaAudi palubovkaAudi;
    MaterialVW materialVW;
    MaterialAudi materialAudi;

    public Sklad(PalubovkaVW vw, PalubovkaAudi audi,MaterialVW vwMat,MaterialAudi audiMat){
        this.palubovkaVW =vw;
        this.palubovkaAudi = audi;
        this.materialAudi = audiMat;
        this.materialVW = vwMat;
    }

    private int pocetAudi;
    private int pocetVW;

    public int getMaterialAudiPocet() {
        return materialAudiPocet;
    }

    public int getMaterialVWPocet() {
        return materialVWPocet;
    }

    private int materialAudiPocet;
    private int materialVWPocet;

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

    @Override
    public void upovedomMaterialVW() {
        this.materialVWPocet = this.materialVW.getPocet();
    }

    @Override
    public void upovedomMaterialAudi() {
        this.materialAudiPocet = this.materialAudi.getPocet();
    }


}
