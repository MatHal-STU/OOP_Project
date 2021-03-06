package background;


import gui.ZlySymbol;
import javafx.scene.control.ChoiceBox;
import managment.Produkcia;
import products.*;
import work.Opravar;
import work.SkusenyRobotnik;
import work.Stroj;

import java.io.*;
import java.util.regex.Pattern;

public class Firma implements Serializable {



    Serializacia serializacia;


    PalubovkaAudi palubovkaAudi = new PalubovkaAudi();
    PalubovkaVW palubovkaVW = new PalubovkaVW();
    MaterialAudi materialAudi = new MaterialAudi();
    MaterialVW materialVW = new MaterialVW();
    Produkcia produkcia = new Produkcia(palubovkaVW, palubovkaAudi,materialVW,materialAudi);

    Sklad sklad;


    LogistikaControler logistikaControler;
    /**
     *Serializacia uloz vytvára nový súbor
     */
    private void uloz() throws ClassNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/palubovkaAudi.out"));
        Serializacia serializacia = new Serializacia(0,0,0,0);
        this.serializacia = serializacia;
        out.writeObject(serializacia);
        out.close();
    }

    /**
     *
     * Ukladá aktualizovane prvky
     *
     */
    private void ulozVyrobene() throws ClassNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/palubovkaAudi.out"));
        this.serializacia.setPocetPaluboviekAudi(sklad.getPocetAudi());
        this.serializacia.setPocetPaluboviekVW(sklad.getPocetVW());
        this.serializacia.setPocetMaterialuAudi(sklad.getMaterialAudiPocet());
        this.serializacia.setPocetMaterialuVW(sklad.getMaterialVWPocet());
        out.writeObject(this.serializacia);
        out.close();
    }

    /**
     *
     * Načíta predošlý súbor
     *
     */
    private void nacitaj() throws ClassNotFoundException, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/palubovkaAudi.out"));
        this.serializacia = (Serializacia) in.readObject();
        palubovkaAudi.pridajPocet(serializacia.getPocetPaluboviekAudi());
        palubovkaVW.pridajPocet(serializacia.getPocetPaluboviekVW());
        materialAudi.pridajPocet(serializacia.getPocetMaterialuAudi());
        materialVW.pridajPocet(serializacia.getPocetMaterialuVW());
        System.out.println(serializacia.getPocetMaterialuAudi() + " " + serializacia.getPocetMaterialuVW() + "\n" + serializacia.getPocetPaluboviekAudi() + " " + serializacia.getPocetPaluboviekVW());
        in.close();

    }

    public Firma() {

        try {
            nacitaj();
        } catch (ClassNotFoundException | IOException e) {
            try {
                uloz();
            } catch (ClassNotFoundException | IOException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
            e.printStackTrace();
        }
        this.sklad = new Sklad(palubovkaVW, palubovkaAudi,materialVW,materialAudi);


        this.logistikaControler = new LogistikaControler(palubovkaVW,palubovkaAudi,materialVW,materialAudi);
        materialAudi.pridajSledovatelaAudi(sklad);
        materialVW.pridajSledovatelaVW(sklad);
        palubovkaAudi.pridajSledovatelaAudi(sklad);
        palubovkaVW.pridajSledovatelaVW(sklad);
        palubovkaAudi.upovedomSledovatelov();
        palubovkaVW.upovdeomSledovatelov();
        materialVW.upovdeomSledovatelov();
        materialAudi.upovedomSledovatelov();
    }

    public String vyrobaP(ChoiceBox<String> vyber, int mnozstvo) {

        String model = vyber.getValue();

        String vyroba = produkcia.vyrob(mnozstvo, model, this.palubovkaVW, this.palubovkaAudi);
        try {
            ulozVyrobene();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return vyroba;


    }


    public String vypisRobotnikov() {


        return produkcia.vypisRobotnikov();

    }

    public String vypisPalub() {
        String sprava;
        sprava = "Pocet paluboviek VW " + sklad.getPocetVW() +
                "\nPocet paluboviek Audi " + sklad.getPocetAudi();

        return sprava;
    }

    public String vypisMaterialu() {
        String sprava;
        sprava = "Pocet materiálu VW " + sklad.getMaterialVWPocet() +
                "\nPocet materiálu Audi " + sklad.getMaterialAudiPocet();

        return sprava;
    }

    public String doplnMaterial(ChoiceBox<String> vyber,int pocet){

        String model = vyber.getValue();
        String vysledok =  logistikaControler.doplnenie(model,pocet);
        try {
            ulozVyrobene();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return vysledok;

    }

    public String novaObjednavka(String name,ChoiceBox<String> vyber,String pocet){

            return logistikaControler.novaObjednavka(name,vyber,pocet);

    }

    public String vypisObjednavok(){
        return logistikaControler.vypisObjednavok();
    }

    public String odslatObjednavku(int cislo){
        String sprava = logistikaControler.odslatObjednavku(cislo);
        try {
            ulozVyrobene();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return sprava;
    }

    public void zadatPlan(String vw, String audi) {
        try {
            if (Pattern.matches("[a-zA-Z]+", vw) || Pattern.matches("[a-zA-Z]+", audi)) {
                throw new ZlySymbol();
            }
            produkcia.setPlanAudi(Integer.parseInt(audi));
            produkcia.setPlanVW(Integer.parseInt(vw));

        }catch (ZlySymbol ex){
            ex.alert();
        }
    }

    public String vypisPlanu() {
        return produkcia.vypisPlanu();
    }

    public String opravaStroju(){
        return produkcia.oprava(palubovkaVW,palubovkaAudi);
    }

    public String trening() {
        return produkcia.trening();
    }
}
