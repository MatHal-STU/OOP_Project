package managment;

import products.Sklad;
import work.NeskusenyRobotnik;
import work.SkusenyRobotnik;
import work.Stroj;
import work.TeamLeader;

import java.util.ArrayList;

public class Produkcia extends Manazer {


    ArrayList<SkusenyRobotnik> skuseny = new ArrayList<>();
    ArrayList<NeskusenyRobotnik> neskuseny = new ArrayList<>();
    TeamLeader teamLeader = new TeamLeader();


    Sklad sklad = Sklad.getInstance();


    public Produkcia() {
        setTyp("Produkcia");
        for (int i = 0; i < 5; i++) {
            SkusenyRobotnik robotnik = new SkusenyRobotnik();
            this.skuseny.add(robotnik);
        }
        for (int i = 0; i < 2; i++) {
            NeskusenyRobotnik robotnik = new NeskusenyRobotnik();
            this.neskuseny.add(robotnik);
        }
    }

    public String vypisRobotnikov(){
        StringBuilder sprava = new StringBuilder();
        int pocet = skuseny.size() + neskuseny.size();
        sprava.append("Počet robotnikov: ").append(pocet).append("\n");

        for (SkusenyRobotnik skusenyRobotnik : skuseny) {
            sprava.append(skusenyRobotnik.getMeno()).append(" platený: ").append(skusenyRobotnik.getVyplata()).append(" skusený\n");
        }
        for (NeskusenyRobotnik neskusenyRobotnik : neskuseny) {
            sprava.append(neskusenyRobotnik.getMeno()).append(" platený: ").append(neskusenyRobotnik.getVyplata()).append(" neskusený\n");
        }

        return sprava.toString();
    }

    public String vyrob(int pocet,String model){
        if (pocet > skuseny.size()){
            int pocet2 = pocet - skuseny.size();
            pocet = skuseny.size();
            if (pocet2 > neskuseny.size()){
                return "Malo pracovnikov";
            }
        }


        for (int i = 0; i < pocet; i++) {
            skuseny.get(i).vykonaj(model);
        }

        return "Vyrobene";
    }

}

