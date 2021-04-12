package work;

import java.util.Random;

public class TeamLeader extends SkusenyRobotnik {

    public TeamLeader() {
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

    public void trening() { //neskor bude moct povysit neskuseneho na skuseneho

    }

}
