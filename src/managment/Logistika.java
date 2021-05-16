package managment;

import background.Doplnenie;
import products.*;

import java.util.ArrayList;

public class Logistika extends Manazer {

    MaterialAudi audi;
    MaterialVW vw;
    PalubovkaAudi palubovkaAudi;
    PalubovkaVW palubovkaVW;
    Doplnenie doplnenie;
    Sklad sklad;

    ArrayList<Objednavka> objednavky = new ArrayList<>();

    public Logistika(PalubovkaAudi palubovkaAudi, PalubovkaVW palubovkaVW,MaterialVW vw, MaterialAudi audi){
        this.vw = vw;
        this.audi = audi;
        this.palubovkaAudi = palubovkaAudi;
        this.palubovkaVW = palubovkaVW;


        this.sklad = new Sklad(palubovkaVW,palubovkaAudi,vw,audi);
        palubovkaVW.pridajSledovatelaVW(sklad);
        palubovkaAudi.pridajSledovatelaAudi(sklad);
        audi.pridajSledovatelaAudi(sklad);
        vw.pridajSledovatelaVW(sklad);
        this.doplnenie = new Doplnenie(vw,audi);
    }

    public void pridajObjednavku(String firma,String znacka,int pocet){
        objednavky.add(new Objednavka(firma,znacka,pocet));
    }

    public String vypisObjednavok(){
        StringBuilder vysledok = new StringBuilder();


        if (objednavky.size() == 0){
            return "Žiadne Objednávky";
        }


        int i = 0;
        for (Objednavka objednavka : objednavky) {
            vysledok.append("Objednavká č.").append(++i).append(" \n");
            vysledok.append(objednavka.print());
            vysledok.append("----------------------\n");
        }
        return vysledok.toString();
    }

    public String doplnenie(String znacka,int pocet){
        return doplnenie.getZn(znacka).doplnenie(pocet);
    }


    /**
     * Odosle objednavku a vymaze ju z arraylistu
     * @param cislo objednavky
     * @return stav
     */
    public String odoslat(int cislo){

        if (cislo >= this.objednavky.size() ||cislo < 0){
            return "Objednávka č. " + (cislo+1) + " neexistuje";
        }

        String model = objednavky.get(cislo).getZnacka();
        int pocet = objednavky.get(cislo).getPocetObjednanych();

        if (model.equals("VW")){
            if (sklad.getPocetVW() < pocet){
                return "Objednávku č. " + (cislo+1) + " nie je možné odoslať z dôvodu nedostatku paluboviek VW na sklade";
            }
            palubovkaVW.odoslanie(pocet);
            objednavky.remove(cislo);
            palubovkaVW.upovdeomSledovatelov();
        }else {
            if (sklad.getPocetAudi() < pocet){
                return "Objednávku č. " + (cislo+1) + " nie je možné odoslať z dôvodu nedostatku paluboviek Audi na sklade";
            }
            palubovkaAudi.odoslanie(cislo);
            objednavky.remove(cislo);
            palubovkaAudi.upovedomSledovatelov();
        }



        return "Objednávka č. " + (cislo+1) + " odoslaná\n";
    }

}
