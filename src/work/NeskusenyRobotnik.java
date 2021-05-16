package work;

import products.PalubovkaAudi;
import products.PalubovkaVW;

import java.io.Serializable;

public class NeskusenyRobotnik extends Robotnik implements Serializable {
    protected boolean trening= false; // ci moze byt povyseny na skuseneho Teamleaderom

    public int getVyrobeneKusy() {
        return vyrobeneKusy;
    }

    /**
     * ak vyrobi viac ako 10 kusov moze sa trenovat teamleaderom
     * @param vyrobeneKusy ak vyrobi kus pripocita ho
     */
    public void setVyrobeneKusy(int vyrobeneKusy) {
        this.vyrobeneKusy += vyrobeneKusy;
        if (this.vyrobeneKusy >= 10){
            this.trening = true;
        }
    }

    private int vyrobeneKusy=0; //pocet vyrobenych kusov, neskor bude sluzit ako idetifikator na nastavenie boolean trening na true

    public NeskusenyRobotnik(){
        super(false);
    }


}
