package products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PalubovkaAudi extends Palubovky implements Serializable {

    public static final long serialVersionUID = 0;

    public int getPocet() {
        return pocet;
    }

    private int pocet;
    transient private List<SledovatelPaluboviek> sledovatelia = new ArrayList<>();

    public PalubovkaAudi(){
        super("Audi",5000);
    }

    public void pridajSledovatelaAudi(SledovatelPaluboviek sledovatel){

        this.sledovatelia.add(sledovatel);
        sledovatel.upovedomAudi();
    }


    public void nastavPocetAudi(int cislo){
        this.pocet += cislo;


        for(SledovatelPaluboviek sledovatel : this.sledovatelia){
            sledovatel.upovedomAudi();
        }
    }
}
