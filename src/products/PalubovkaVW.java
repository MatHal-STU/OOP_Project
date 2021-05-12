package products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PalubovkaVW extends Palubovky implements Serializable {

    public static final long serialVersionUID = 1;

    public int getPocet() {
        return pocet;
    }

    private int pocet;

    transient private List<SledovatelPaluboviek> sledovatelia = new ArrayList<>();

    public PalubovkaVW(){
        super("VW",4200);
    }



    public void pridajSledovatelaVW(SledovatelPaluboviek sledovatel){
        this.sledovatelia.add(sledovatel);
    }


    public void nastavPocetVW(int cislo){
        this.pocet += cislo;
        for(SledovatelPaluboviek sledovatel : this.sledovatelia){
            sledovatel.upovedomVW();
        }
    }
}
