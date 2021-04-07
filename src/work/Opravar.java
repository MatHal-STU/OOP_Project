package work;

import sun.applet.AppletResourceLoader;

import java.util.Random;

public class Opravar implements Clovek {
    protected int vyplata;
    protected boolean skuseny;
    protected boolean volny;
    protected String meno;
    protected int vek = 35;


    public Opravar(){
        vytvor(true);
        this.volny = true;
        this.meno = "František";

    }

    @Override
    public void vytvor(boolean skusenost) {
        this.skuseny = skusenost;
    }

    @Override
    public void setVyplata(int ciastka) {
        this.vyplata = ciastka;
    }

    @Override
    public int getVyplata() {
        return this.vyplata;
    }


}
