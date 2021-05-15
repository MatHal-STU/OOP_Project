package background;

import products.Material;
import products.MaterialAudi;
import products.MaterialVW;

public class Doplnenie {
    MaterialVW vw;
    MaterialAudi audi;

    public Doplnenie(MaterialVW vw, MaterialAudi audi){
        this.vw = vw;
        this.audi = audi;
    }

    public DoplnenieMaterialu getZn (String znacka){
        if(znacka == null){
            return null;
        }
        if(znacka.equalsIgnoreCase("VW")){
            return new VWMaterial(this.vw);

        } else if(znacka.equalsIgnoreCase("Audi")){
            return new AudiMaterial(this.audi);

        }

        return null;
    }
}
