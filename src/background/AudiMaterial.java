package background;

import products.Material;
import products.MaterialAudi;

public class AudiMaterial implements DoplnenieMaterialu{
    MaterialAudi audi;

    public AudiMaterial(MaterialAudi audi){
        this.audi = audi;
    }

    @Override
    public String doplnenie(int pocet) {


        if(this.audi.getPocet() > 200){
            return "Sklad je plny";
        }else{
            if (this.audi.getPocet()+pocet > 200){
                this.audi.pridajPocet(200 - this.audi.getPocet());
                return "Sklad doplneny naplno";
            }else {
                this.audi.pridajPocet(pocet);
            }
        }

        audi.upovedomSledovatelov();

        return "Doplnene o " + pocet +" materialu Audi";
    }

    @Override
    public void pouzitie(int pocet) {
        this.audi.odoslanie(pocet);
    }


}
