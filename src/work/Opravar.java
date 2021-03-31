package work;

public class Opravar implements Clovek {
    protected int vyplata;
    protected boolean skuseny;

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
