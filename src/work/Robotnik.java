package work;

import products.PalubovkaAudi;
import products.PalubovkaVW;

import java.io.Serializable;
import java.util.Random;

public abstract class Robotnik implements Clovek, Serializable {
    protected int vyplata;
    protected boolean skuseny;


    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    protected String meno;




    public Robotnik(boolean skusenost) {

        this.skuseny = skusenost;
        if (skusenost) {
            this.vyplata = (new Random().nextInt(3) + 8) * 100;
        } else {
            this.vyplata = (new Random().nextInt(3) + 5) * 100;
        }


        int leftLimit = 65; // pismeno 'A'
        int rightLimit = 90; // pismeno 'Z'
        int targetStringLength = 3;
        Random random = new Random();

        this.meno = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
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
    public String vykonaj(String model,PalubovkaVW vw,PalubovkaAudi audi) {
        if (model.equals("VW")) {
            if (skuseny) {
                vw.pridajPocet(2);
            } else {
                vw.pridajPocet(1);
            }
            vw.upovdeomSledovatelov();

        } else if (model.equals("Audi")) {
            if (skuseny){
                audi.pridajPocet(2);
            }else {
                audi.pridajPocet(1);
            }
            audi.upovedomSledovatelov();
        }

        return "Robotník " + this.meno + " vyrobil palubovku " + model + "\n";

    }


}
