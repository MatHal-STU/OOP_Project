package managment;

import products.PalubovkaAudi;
import products.PalubovkaVW;
import work.*;

import java.util.ArrayList;
import java.util.Random;

public class Produkcia extends Manazer {


    ArrayList<SkusenyRobotnik> skuseny = new ArrayList<>();
    ArrayList<NeskusenyRobotnik> neskuseny = new ArrayList<>();
    TeamLeader teamLeader;
    private final Stroj strojVW = new Stroj("VW");
    private final Stroj strojAudi = new Stroj("Audi");
    Opravar opravar = new Opravar(strojVW,strojAudi);

    public void setPlanVW(int planVW) {
        this.planVW = planVW;
    }

    public void setPlanAudi(int planAudi) {
        this.planAudi = planAudi;
    }

    private int planVW=0,planAudi=0;



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
            sprava.append(neskusenyRobotnik.getMeno()).append(" platený: ").append(neskusenyRobotnik.getVyplata()).append(" neskusený, Počet vyrobených paluboviek ").append(neskusenyRobotnik.getVyrobeneKusy()).append("\n");
        }

        return sprava.toString();
    }

    /**
     * vyroba paluboviek
     * @param pocet pocet na vyrobu
     * @param model aky model
     * @param vw palubovka vw
     * @param audi palubovka audi
     * @return sprava kto spravil palubovky
     */
    public String vyrob(int pocet,String model,PalubovkaVW vw, PalubovkaAudi audi){

        StringBuilder sprava = new StringBuilder();
        Random rn = new Random();
        int i;

        while (pocet != 0){
            if (pocet > 1) {
                i = rn.nextInt(skuseny.size());
                sprava.append("Skúsený ");
                sprava.append(skuseny.get(i).vykonaj(model, vw, audi));
                pocet -=2;
            }
            if (pocet>0) {
                i = rn.nextInt(neskuseny.size());
                sprava.append("Neskúsený ");
                sprava.append(neskuseny.get(i).vykonaj(model, vw, audi));
                neskuseny.get(i).setVyrobeneKusy(1);
                pocet--;
            }
        }

        return sprava.toString();
    }

    public String vypisPlanu(){
        return "Plán: \n" +
                "VW: " + this.planVW +
                "\nAudi: " + this.planAudi;
    }

}

