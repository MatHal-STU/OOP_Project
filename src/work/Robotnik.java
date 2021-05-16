package work;

import products.MaterialAudi;
import products.MaterialVW;
import products.PalubovkaAudi;
import products.PalubovkaVW;

import java.io.Serializable;
import java.util.Random;

public abstract class Robotnik implements Clovek, Serializable {
    protected int vyplata;
    protected boolean skuseny;


    private MaterialVW materialVW;
    private MaterialAudi materialAudi;

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

    public void setMaterial(MaterialVW vw, MaterialAudi audi) {
        this.materialVW = vw;
        this.materialAudi = audi;
    }

    @Override
    public String vykonaj(String model, PalubovkaVW vw, PalubovkaAudi audi) {
        boolean vyrobil = true;
        if (model.equals("VW")) {
            if (skuseny) {
                if (materialVW.getPocet() >= 2) {
                    vw.pridajPocet(2);
                    materialVW.odoslanie(2);
                }else {
                    vyrobil = false;
                }
            } else {
                if (materialVW.getPocet() >= 1) {
                    vw.pridajPocet(1);
                    materialVW.odoslanie(1);
                }else {
                    vyrobil = false;
                }
            }
            materialVW.upovdeomSledovatelov();
            vw.upovdeomSledovatelov();


        } else if (model.equals("Audi")) {
            if (skuseny) {
                if (materialAudi.getPocet() >= 2) {
                    audi.pridajPocet(2);
                    materialAudi.odoslanie(2);
                }else {
                    vyrobil = false;
                }
            } else {
                if (materialAudi.getPocet() >= 2) {
                    audi.pridajPocet(1);
                    materialAudi.odoslanie(1);
                }else {
                    vyrobil = false;
                }
            }
            audi.upovedomSledovatelov();
            materialAudi.upovedomSledovatelov();
        }

        if (!vyrobil){
            return "NEDOSTATOK MATERIALU\n";
        }

        return "Robotník " + this.meno + " vyrobil palubovku " + model + "\n";

    }


}
