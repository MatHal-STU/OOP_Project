package products;

public class Material implements Produkty{
    private String typ;
    private int pocet;



    public Material (String typ){
        this.typ = typ;
        pocet = 0;
    }

    @Override
    public void pridajPocet(int cislo) {
        this.pocet += cislo;
    }
}
