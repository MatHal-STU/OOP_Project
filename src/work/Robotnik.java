package work;

import java.util.Random;

public abstract class Robotnik implements Clovek{
    protected int vyplata;
    protected boolean skuseny;
    protected String meno;



    public Robotnik(boolean skusenost) {
        this.skuseny = skusenost;
        if(skusenost){
            this.vyplata = (new Random().nextInt(3)+8)*100;
        }else{
            this.vyplata = (new Random().nextInt(3)+5)*100;
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
    public void vykonaj() {

    }


}
