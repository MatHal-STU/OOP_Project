package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.BitSet;

import static javafx.application.Application.launch;



public class Main extends Application {

    Scene scenaProdukcia,scenaLogistika,scenaUctovnictvo,uvod;
    private final Button produkcia= new Button("Produkčný Manažment");
    private final Button logistika= new Button("Logistický Manažment");
    private final Button uctovnictvo= new Button("Účtovnícky Manažment");
    private final Button odhlas = new Button("Odhlásiť");
    private final Button odhlas1 = new Button("Odhlásiť");
    private final Button odhlas2 = new Button("Odhlásiť");

    public static void main(String[] args) {
	    launch(args);
    }

    @Override
    public void start(Stage hlavneOkno) {
        hlavneOkno.setTitle("Demo");

        //Tlacidla na presmerovanie na uvodnej strane
        produkcia.setOnAction(event -> hlavneOkno.setScene(scenaProdukcia));
        logistika.setOnAction(event -> hlavneOkno.setScene(scenaLogistika));
        uctovnictvo.setOnAction(event -> hlavneOkno.setScene(scenaUctovnictvo));

        //Tlacidlo na odhlasenie
        odhlas.setOnAction(event -> hlavneOkno.setScene(uvod));
        odhlas1.setOnAction(event -> hlavneOkno.setScene(uvod));
        odhlas2.setOnAction(event -> hlavneOkno.setScene(uvod));

        //uvodna obrazovka
        VBox uvodlayout = new VBox(15);
        uvodlayout.getChildren().addAll(produkcia,logistika,uctovnictvo);
        uvod = new Scene(uvodlayout,500,300);

        //produkcia
        VBox prodlayout = new VBox(15);
        prodlayout.getChildren().addAll(odhlas);
        scenaProdukcia = new Scene(prodlayout,500,300);

        //logistika
        VBox loglayout = new VBox(15);
        loglayout.getChildren().addAll(odhlas1);
        scenaLogistika = new Scene(loglayout,500,300);

        //Uctovnictvo
        VBox uctolayout = new VBox(15);
        uctolayout.getChildren().addAll(odhlas2);
        scenaUctovnictvo = new Scene(uctolayout,500,300);

        hlavneOkno.setScene(uvod);
        hlavneOkno.show();
    }
}
