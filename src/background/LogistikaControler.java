package background;

import products.PalubovkaAudi;
import products.PalubovkaVW;
import products.SkladPaluboviek;

public class LogistikaControler {
    PalubovkaAudi palubovkaAudi;
    PalubovkaVW palubovkaVW;

    SkladPaluboviek skladPaluboviek = new SkladPaluboviek(palubovkaVW,palubovkaAudi);



    public LogistikaControler(PalubovkaVW vw, PalubovkaAudi audi){
        this.palubovkaAudi =audi;
        this.palubovkaVW = vw;
        palubovkaVW.pridajSledovatelaVW(skladPaluboviek);
        palubovkaAudi.pridajSledovatelaAudi(skladPaluboviek);
    }
}
