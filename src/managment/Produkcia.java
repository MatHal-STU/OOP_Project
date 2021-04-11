package managment;

import work.NeskusenyRobotnik;
import work.SkusenyRobotnik;
import work.TeamLeader;

import java.util.ArrayList;

public class Produkcia extends Manazer {


    ArrayList<SkusenyRobotnik> skuseny = new ArrayList<>();
    ArrayList<NeskusenyRobotnik> neskuseny = new ArrayList<>();
    TeamLeader teamLeader = new TeamLeader();

    public Produkcia(){
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



}

