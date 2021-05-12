package work;

import products.PalubovkaAudi;
import products.PalubovkaVW;

import java.io.Serializable;

public class NeskusenyRobotnik extends Robotnik implements Serializable {
    protected boolean trening= false; // ci moze byt povyseny na skuseneho Teamleaderom
    int vyrobeneKusy; //pocet vyrobenych kusov, neskor bude sluzit ako idetifikator na nastavenie boolean trening na true

    public NeskusenyRobotnik(){
        super(false);
    }


}
