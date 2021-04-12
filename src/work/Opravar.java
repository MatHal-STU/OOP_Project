package work;

import sun.applet.AppletResourceLoader;

import java.util.Random;

public class Opravar implements Clovek {
    protected int vyplata;
    protected boolean volny;
    protected String meno;

    Stroj strojVW = new Stroj("VW");
    Stroj strojAudi = new Stroj("Audi");

    public Opravar(){
        this.volny = true;
        this.meno = "František";

    }


    private String skontrolujAudi(){
        String sprava = "Stroj Audi v poriadku";
        if (!strojAudi.isFunkcnost()){
            sprava = "Nefuknčný stroj VW opravím";
        }
        return sprava;
    }

    private String skontrolujVW(){
        String sprava = "Stroj VW poriadku";
        if (!strojAudi.isFunkcnost()){
            sprava = "Nefuknčný stroj VW opravím";
        }
        return sprava;
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
    public void vykonaj(String model) {
        if (model.equals("VW")){
            strojVW.setFunkcnost(true);
        }else if (model.equals("Audi")){
            strojAudi.setFunkcnost(true);
        }
    }


}
