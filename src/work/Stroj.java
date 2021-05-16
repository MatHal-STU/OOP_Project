package work;

import java.util.Random;

public class Stroj {
    protected String typ;

    public boolean isFunkcnost() {
        return funkcnost;
    }

    public void setFunkcnost(boolean funkcnost) {
        this.funkcnost = funkcnost;
    }

    protected boolean funkcnost;

    public Stroj(String meno){
        this.typ = meno;
        this.funkcnost = true;
    }

    public void pokazenie(){
        Random ran = new Random();
        int x = ran.nextInt(100);
        if (x > 94){
            this.funkcnost = false;
        }

    }

}
