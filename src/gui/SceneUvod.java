package gui;

import background.Firma;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneUvod extends Stage {


    public SceneUvod(Stage hlavneOkno,Firma firma){
        VBox uvodlayout = new VBox(10);
        Button produkcia = new Button("Produkčný Manažment");
        Button logistika = new Button("Logistický Manažment");
        Button objednat = new Button("Zákazník");



        produkcia.setOnAction(e -> new SceneProdukcia(hlavneOkno,firma));
        logistika.setOnAction(e -> new SceneLogistika(hlavneOkno,firma));
        objednat.setOnAction(e -> new SceneObjednavka(hlavneOkno,firma));

        uvodlayout.getChildren().addAll(produkcia, logistika,objednat);
        Scene uvod = new Scene(uvodlayout,500,300);

        hlavneOkno.setScene(uvod);
        hlavneOkno.show();

    }

}
