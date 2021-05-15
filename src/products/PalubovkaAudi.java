package products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PalubovkaAudi extends Palubovky implements Serializable {



    transient private List<SledovatelSkladu> sledovatelia = new ArrayList<>();

    public PalubovkaAudi(){
        super("Audi",5000);
    }

    public void pridajSledovatelaAudi(SledovatelSkladu sledovatel){
        this.sledovatelia.add(sledovatel);
        sledovatel.upovedomAudi();
    }


    public void upovedomSledovatelov(){
        for(SledovatelSkladu sledovatel : this.sledovatelia){
            sledovatel.upovedomAudi();
        }
    }
}
