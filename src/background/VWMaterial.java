package background;


import products.Material;
import products.MaterialVW;

public class VWMaterial implements DoplnenieMaterialu{

    MaterialVW materialVW;

    public VWMaterial(MaterialVW vw){
        this.materialVW = vw;
    }

    @Override
    public String doplnenie(int pocet) {
        if(this.materialVW.getPocet() > 200){
            return "Sklad je plny";
        }else{
            if (this.materialVW.getPocet()+pocet > 200){
                this.materialVW.pridajPocet(200 - this.materialVW.getPocet());
                return "Sklad doplneny naplno";
            }else {
                this.materialVW.pridajPocet(pocet);
            }
        }

        materialVW.upovdeomSledovatelov();
        return "Doplnene o " + pocet +" materialu VW";
    }
}
