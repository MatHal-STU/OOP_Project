package work;

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
}
