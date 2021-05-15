package products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MaterialVW extends Material implements Serializable {

    transient private List<SledovatelSkladu> sledovatelia = new ArrayList<>();

    public MaterialVW() {
        super("VW");
    }

    public void pridajSledovatelaVW(SledovatelSkladu sledovatel) {
        this.sledovatelia.add(sledovatel);
    }


    public void upovdeomSledovatelov() {
        for (SledovatelSkladu sledovatel : this.sledovatelia) {
            sledovatel.upovedomMaterialVW();
        }
    }

}
