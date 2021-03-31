package work;

import java.util.Random;

public abstract class Robotnik implements Clovek{
    protected int vyplata;
    protected boolean skuseny;

    @Override
    public void vytvor(boolean skusenost) {
        this.skuseny = skusenost;
        if(skusenost){
            this.vyplata = (new Random().nextInt(3)+8)*100;
        }else{
            this.vyplata = (new Random().nextInt(3)+5)*100;
        }
    }


}
