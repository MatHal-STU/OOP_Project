package work;

import sun.applet.AppletResourceLoader;

import java.util.Random;

public class Opravar implements Clovek {
    protected int vyplata;
    protected boolean volny;
    protected String meno;



    public Opravar(){
        this.volny = true;
        this.meno = "František";

    }



    @Override
    public void setVyplata(int ciastka) {
        this.vyplata = ciastka;
    }

    @Override
    public int getVyplata() {
        return this.vyplata;
    }

    @Override
    public void vykonaj() {

    }


}
