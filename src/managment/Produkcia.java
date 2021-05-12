package managment;

import products.PalubovkaAudi;
import products.PalubovkaVW;
import work.NeskusenyRobotnik;
import work.SkusenyRobotnik;
import work.TeamLeader;

import java.util.ArrayList;

public class Produkcia extends Manazer {


    ArrayList<SkusenyRobotnik> skuseny = new ArrayList<>();
    ArrayList<NeskusenyRobotnik> neskuseny = new ArrayList<>();
    TeamLeader teamLeader;








    public Produkcia(PalubovkaVW vw, PalubovkaAudi audi) {

        this.teamLeader = new TeamLeader(audi,vw);
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

    public String vyrob(int pocet,String model,PalubovkaVW vw, PalubovkaAudi audi){
        if (pocet > skuseny.size()){
            int pocet2 = pocet - skuseny.size();
            pocet = skuseny.size();
            if (pocet2 > neskuseny.size()){
                return "Malo pracovnikov";
            }
        }


        for (int i = 0; i < pocet; i++) {
            skuseny.get(i).vykonaj(model,vw,audi);
        }

        return "Vyrobene";
    }


}

