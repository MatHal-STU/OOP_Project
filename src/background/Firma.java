package background;

import managment.Produkcia;
import work.NeskusenyRobotnik;
import work.SkusenyRobotnik;

import java.util.ArrayList;

public class Firma {

    public Firma(){
        ArrayList<SkusenyRobotnik> skuseny = new ArrayList<>();
        ArrayList<NeskusenyRobotnik> neskuseny = new ArrayList<>();

        Produkcia produkcia = new Produkcia(skuseny,neskuseny);

    }

}
