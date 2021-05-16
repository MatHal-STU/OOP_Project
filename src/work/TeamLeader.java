package work;

import javafx.scene.control.Alert;
import products.PalubovkaAudi;
import products.PalubovkaVW;

import java.util.ArrayList;
import java.util.Random;

public class TeamLeader extends SkusenyRobotnik {

    public TeamLeader(PalubovkaAudi audi, PalubovkaVW vw) {
        super();
        this.vyplata = (new Random().nextInt(8) + 5) * 100;


        int leftLimit = 65; // pismeno 'A'
        int rightLimit = 90; // pismeno 'Z'
        int targetStringLength = 3;
        Random random = new Random();

        this.meno = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public String trening(ArrayList<NeskusenyRobotnik> neskuseny,ArrayList<SkusenyRobotnik> skuseny) { //neskor bude moct povysit neskuseneho na skuseneho

        boolean povysenie = false;
        StringBuilder sprava = new StringBuilder();
        for (int i = 0; i < neskuseny.size(); i++) {
            if (neskuseny.get(i).trening){
                SkusenyRobotnik trening = new SkusenyRobotnik();
                trening.setMeno(neskuseny.get(i).getMeno());
                skuseny.add(trening);
                sprava.append(trening.meno).append(" bol povýšený");
                //noinspection SuspiciousListRemoveInLoop
                neskuseny.remove(i);
                povysenie =true;
            }
        }
        if (!povysenie){
            return "Nikto nebol povýšený";
        }
        return sprava.toString();
    }

}
