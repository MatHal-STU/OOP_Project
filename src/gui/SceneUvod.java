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
        Button uctovnictvo = new Button("Účtovnícky Manažment");
        Button objednat = new Button("Objednať");



        produkcia.setOnAction(e -> new SceneProdukcia(hlavneOkno,firma));
        logistika.setOnAction(e -> new SceneLogistika(hlavneOkno,firma));
        uctovnictvo.setOnAction(e -> new SceneUctovnictvo(hlavneOkno,firma));
        objednat.setOnAction(e -> new SceneObjednavka(hlavneOkno,firma));

        uvodlayout.getChildren().addAll(produkcia, logistika, uctovnictvo,objednat);
        Scene uvod = new Scene(uvodlayout,500,300);

        hlavneOkno.setScene(uvod);
        hlavneOkno.show();

    }

}
