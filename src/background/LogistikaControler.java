package background;

import products.*;

public class LogistikaControler {
    PalubovkaAudi palubovkaAudi;
    PalubovkaVW palubovkaVW;
    MaterialVW materialVW;
    MaterialAudi materialAudi;

    Sklad sklad;




    public LogistikaControler(PalubovkaVW vw, PalubovkaAudi audi,MaterialVW vwMat,MaterialAudi audiMat){
        this.palubovkaAudi =audi;
        this.palubovkaVW = vw;
        this.materialAudi = audiMat;
        this.materialVW = vwMat;

        this.sklad = new Sklad(palubovkaVW,palubovkaAudi,materialVW,materialAudi);
        palubovkaVW.pridajSledovatelaVW(sklad);
        palubovkaAudi.pridajSledovatelaAudi(sklad);
        materialAudi.pridajSledovatelaAudi(sklad);
        materialVW.pridajSledovatelaVW(sklad);

    }
}
