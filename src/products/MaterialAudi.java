package products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MaterialAudi extends Material implements Serializable {

    transient private List<SledovatelSkladu> sledovatelia = new ArrayList<>();

    public MaterialAudi (){
        super("Audi");
    }
    public void pridajSledovatelaAudi(SledovatelSkladu sledovatel){
        this.sledovatelia.add(sledovatel);
        sledovatel.upovedomAudi();
    }


    public void upovedomSledovatelov(){
        for(SledovatelSkladu sledovatel : this.sledovatelia){
            sledovatel.upovedomMaterialAudi();
        }
    }
}
