package managment;

public class Objednavka {

    private int pocetObjednanych;

    public int getPocetObjednanych() {
        return pocetObjednanych;
    }

    public String getZnacka() {
        return znacka;
    }

    private String znacka;
    private String firma;

    public Objednavka (String meno,String model,int pocet){
        this.pocetObjednanych = pocet;
        this.firma = meno;
        this.znacka = model;
    }

    public String print(){
        return "Pre: " + this.firma + "\n" +
                "Model: " + this.znacka + "\n" +
                "Pocet: " + this.pocetObjednanych + "\n";
    }

}
