package background;

import gui.ZlySymbol;
import javafx.scene.control.ChoiceBox;
import managment.Logistika;
import products.*;

import java.util.regex.Pattern;

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

    public String novaObjednavka(String name, ChoiceBox<String> vyber, String pocet){
        try {
            int number;

            if (Pattern.matches("[a-zA-Z]+", pocet)) {
                throw new ZlySymbol();
            }
            number = Integer.parseInt(pocet);
            String model = vyber.getValue();
            logistika.pridajObjednavku(name,model,number);

        }catch (ZlySymbol ex){
            ex.alert();
            return "Neobjednane";
        }
        return "Objednane";
    }

    public LogistikaControler(PalubovkaVW vw, PalubovkaAudi audi,MaterialVW vwMat,MaterialAudi audiMat){
        this.palubovkaAudi =audi;
        this.palubovkaVW = vw;
        this.materialAudi = audiMat;
        this.materialVW = vwMat;
        this.logistika = new Logistika(audi,vw,materialVW,materialAudi);

        this.sklad = new Sklad(palubovkaVW,palubovkaAudi,materialVW,materialAudi);
        palubovkaVW.pridajSledovatelaVW(sklad);
        palubovkaAudi.pridajSledovatelaAudi(sklad);
        materialAudi.pridajSledovatelaAudi(sklad);
        materialVW.pridajSledovatelaVW(sklad);

    }

    public String vypisObjednavok() {
        return logistika.vypisObjednavok();
    }
    public String odslatObjednavku(int cislo){
        return logistika.odoslat((cislo-1));
    }
}
