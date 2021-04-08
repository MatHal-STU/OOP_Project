package background;

import managment.Produkcia;
import products.Sklad;
import work.NeskusenyRobotnik;
import work.Opravar;
import work.SkusenyRobotnik;

import java.util.ArrayList;

public class Firma {

    static ArrayList<SkusenyRobotnik> skuseny = new ArrayList<>();
    static ArrayList<NeskusenyRobotnik> neskuseny = new ArrayList<>();
    Opravar opravar = new Opravar();
    Produkcia produkcia = new Produkcia(skuseny,neskuseny);
    Sklad sklad = Sklad.getInstance();


    public Firma(){

    }

    public String vypisPalub(){
        String sprava;
        sprava =    "Pocet paluboviek VW " + sklad.getPalubovka1() +
                    "\nPocet paluboviek Audi" + sklad.getPalubovka2();

        return sprava;
    }

    public void vypisRobotnikov(){




    }
}
