package background;


import javafx.scene.control.ChoiceBox;
import managment.Produkcia;
import products.PalubovkaAudi;
import products.PalubovkaVW;
import products.SkladPaluboviek;
import work.Opravar;

import java.io.*;

public class Firma implements Serializable {


    Opravar opravar = new Opravar();


    PalubovkaAudi palubovkaAudi = new PalubovkaAudi();
    PalubovkaVW palubovkaVW = new PalubovkaVW();
    Produkcia produkcia = new Produkcia(palubovkaVW, palubovkaAudi);

    SkladPaluboviek skladPaluboviek;

    private void uloz() throws ClassNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/palubovkaAudi.out"));
        PalubovkaAudi audi = new PalubovkaAudi();
        out.writeObject(audi);
        out.close();
    }

    private void ulozVyrobene() throws ClassNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/palubovkaAudi.out"));
        out.writeObject(this.palubovkaAudi);
        out.close();
    }

    private void nacitaj() throws ClassNotFoundException, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/palubovkaAudi.out"));
        PalubovkaAudi audi = (PalubovkaAudi) in.readObject();
        this.palubovkaAudi.nastavPocetAudi(audi.getPocet());
        System.out.println(palubovkaAudi.getPocet());
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
        this.skladPaluboviek = new SkladPaluboviek(palubovkaVW, palubovkaAudi);

        palubovkaAudi.pridajSledovatelaAudi(skladPaluboviek);
        palubovkaVW.pridajSledovatelaVW(skladPaluboviek);
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
        sprava = "Pocet paluboviek VW " + skladPaluboviek.getPocetVW() +
                "\nPocet paluboviek Audi " + skladPaluboviek.getPocetAudi();


        return sprava;
    }
}
