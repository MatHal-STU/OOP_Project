package managment;

import background.Doplnenie;
import products.MaterialAudi;
import products.MaterialVW;

public class Logistika extends Manazer {

    MaterialAudi audi;
    MaterialVW vw;
    Doplnenie doplnenie;

    public Logistika(MaterialVW vw, MaterialAudi audi){
        this.vw = vw;
        this.audi = audi;
        this.doplnenie = new Doplnenie(vw,audi);
    }

    public String doplnenie(String znacka,int pocet){
        return doplnenie.getZn(znacka).doplnenie(pocet);
    }

}
