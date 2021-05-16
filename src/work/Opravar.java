package work;

import products.PalubovkaAudi;
import products.PalubovkaVW;

import java.io.Serializable;

public class Opravar implements Clovek, Serializable {
    protected int vyplata;
    protected boolean volny;
    protected String meno;

    Stroj strojVW ;
    Stroj strojAudi ;

    public Opravar(Stroj strojVW, Stroj strojAudi){
        this.strojVW = strojVW;
        this.strojAudi = strojAudi;
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
    public String vykonaj(String model, PalubovkaVW vw, PalubovkaAudi audi) {

        StringBuilder sprava = new StringBuilder();
        if (strojVW.isFunkcnost()){
            strojVW.setFunkcnost(true);
            sprava.append("POKAZENÝ STROJ VW, OPRAVUJEM \n");
            sprava.append("OPRAVENÉ\n");
        }
        if (strojAudi.isFunkcnost()){
            strojAudi.setFunkcnost(true);
            sprava.append("POKAZENÝ STROJ AUDI, OPRAVUJEM \n");
            sprava.append("OPRAVENÉ\n");
        }

        return sprava.toString();
    }


}
