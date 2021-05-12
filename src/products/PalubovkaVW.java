package products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PalubovkaVW extends Palubovky implements Serializable {




    transient private List<SledovatelPaluboviek> sledovatelia = new ArrayList<>();

    public PalubovkaVW(){
        super("VW",4200);
    }



    public void pridajSledovatelaVW(SledovatelPaluboviek sledovatel){
        this.sledovatelia.add(sledovatel);
    }


    public void upovdeomSledovatelov(){
        for(SledovatelPaluboviek sledovatel : this.sledovatelia){
            sledovatel.upovedomVW();
        }
    }



}
