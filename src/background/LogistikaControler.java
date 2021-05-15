package background;

import managment.Logistika;
import products.*;

public class LogistikaControler {
    private PalubovkaAudi palubovkaAudi;
    private PalubovkaVW palubovkaVW;
    private MaterialVW materialVW;
    private MaterialAudi materialAudi;

    private Sklad sklad;

    private Logistika logistika;

    public String doplnenie(String model,int pocet){
        String vysledok;
        vysledok = logistika.doplnenie(model,pocet);
        sklad.upovedomMaterialAudi();
        sklad.upovedomMaterialVW();

        return vysledok;
    }


    public LogistikaControler(PalubovkaVW vw, PalubovkaAudi audi,MaterialVW vwMat,MaterialAudi audiMat){
        this.palubovkaAudi =audi;
        this.palubovkaVW = vw;
        this.materialAudi = audiMat;
        this.materialVW = vwMat;
        this.logistika = new Logistika(materialVW,materialAudi);

        this.sklad = new Sklad(palubovkaVW,palubovkaAudi,materialVW,materialAudi);
        palubovkaVW.pridajSledovatelaVW(sklad);
        palubovkaAudi.pridajSledovatelaAudi(sklad);
        materialAudi.pridajSledovatelaAudi(sklad);
        materialVW.pridajSledovatelaVW(sklad);

    }
}
