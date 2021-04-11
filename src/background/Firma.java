package background;

import managment.Produkcia;
import products.Sklad;
import work.NeskusenyRobotnik;
import work.Opravar;
import work.SkusenyRobotnik;

import java.util.ArrayList;

public class Firma {

    Opravar opravar = new Opravar();
    Produkcia produkcia = new Produkcia();
    Sklad sklad = Sklad.getInstance();


    public Firma(){

    }

    public String vypisPalub(){
        String sprava;
        sprava =    "Pocet paluboviek VW " + sklad.getPalubovka1() +
                    "\nPocet paluboviek Audi " + sklad.getPalubovka2();

        return sprava;
    }

    public String vypisMat(){
        String sprava;
        sprava =    "Pocet Materialu na palubovku VW " + sklad.getMaterial1() +
                "\nPocet materialu na palubovku Audi " + sklad.getMaterial2();

        return sprava;
    }

    public void vypisRobotnikov(){




    }
}
