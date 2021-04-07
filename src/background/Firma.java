package background;

import managment.Produkcia;
import work.NeskusenyRobotnik;
import work.Opravar;
import work.SkusenyRobotnik;

import java.util.ArrayList;

public class Firma {

    public Firma(){
        ArrayList<SkusenyRobotnik> skuseny = new ArrayList<>();
        ArrayList<NeskusenyRobotnik> neskuseny = new ArrayList<>();

        Opravar opravar = new Opravar();

        Produkcia produkcia = new Produkcia(skuseny,neskuseny);

    }

    public void vypisRobotnikov(){




    }
}
