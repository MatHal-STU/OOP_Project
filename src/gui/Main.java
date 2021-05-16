package gui;


import background.Firma;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author MATÚŠ JÁN HAĽAMA
 */

public class Main extends Application {

    Scene uvod;
    private final Button produkcia= new Button("Produkčný Manažment");
    private final Button logistika= new Button("Logistický Manažment");
    private final Button objednavka = new Button("Zákazník");





    public static void main(String[] args) {
	    launch(args);
    }

    @Override
    public void start(Stage hlavneOkno) {
        hlavneOkno.setTitle("Demo");

        Firma firma = new Firma();


        //Tlacidla na presmerovanie na uvodnej strane
        produkcia.setOnAction(e -> new SceneProdukcia(hlavneOkno,firma));
        logistika.setOnAction(e -> new SceneLogistika(hlavneOkno,firma));
        objednavka.setOnAction(e -> new SceneObjednavka(hlavneOkno,firma));

        VBox uvodlayout = new VBox(10);
        uvodlayout.getChildren().addAll(produkcia, logistika,objednavka);
        uvod = new Scene(uvodlayout,500,300);



        hlavneOkno.setScene(uvod);
        hlavneOkno.show();

    }
}
