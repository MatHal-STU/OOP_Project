package background;

import javafx.scene.control.ChoiceBox;
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

    public String vyrobaP(ChoiceBox<String> vyber,int mnozstvo){
        String model = vyber.getValue();
        return produkcia.vyrob(mnozstvo,model);
    }

    public String vypisPalub(){
        String sprava;
        sprava =    "Pocet paluboviek VW " + sklad.getPalubovkaVW() +
                    "\nPocet paluboviek Audi " + sklad.getPalubovkaAudi();

        return sprava;
    }

    public String vypisMat(){
        String sprava;
        sprava =    "Pocet Materialu na palubovku VW " + sklad.getMaterial1() +
                "\nPocet materialu na palubovku Audi " + sklad.getMaterial2();

        return sprava;
    }

    public String vypisRobotnikov(){


        return produkcia.vypisRobotnikov();



    }
}
