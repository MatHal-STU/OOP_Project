package managment;

import work.NeskusenyRobotnik;
import work.SkusenyRobotnik;

import java.util.ArrayList;

public class Produkcia extends Manazer {


    public Produkcia(ArrayList<SkusenyRobotnik> skusenyrobotnici,ArrayList<NeskusenyRobotnik> neskusenyrobotnici){
        setTyp("Produkcia");
        for (int i = 0; i < 5; i++) {
            SkusenyRobotnik robotnik = new SkusenyRobotnik();
            skusenyrobotnici.add(robotnik);
        }
        for (int i = 0; i < 2; i++) {
            NeskusenyRobotnik robotnik = new NeskusenyRobotnik();
            neskusenyrobotnici.add(robotnik);
        }
    }



}

