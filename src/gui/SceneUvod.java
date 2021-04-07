package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneUvod extends Stage {


    public SceneUvod(Stage hlavneOkno){
        VBox uvodlayout = new VBox(10);
        Button produkcia = new Button("Produkčný Manažment");
        Button logistika = new Button("Logistický Manažment");
        Button uctovnictvo = new Button("Účtovnícky Manažment");


        produkcia.setOnAction(e -> new SceneProdukcia(hlavneOkno));
        logistika.setOnAction(e -> new SceneLogistika(hlavneOkno));
        uctovnictvo.setOnAction(e -> new SceneUctovnictvo(hlavneOkno));


        uvodlayout.getChildren().addAll(produkcia, logistika, uctovnictvo);
        Scene uvod = new Scene(uvodlayout,500,300);

        hlavneOkno.setScene(uvod);
        hlavneOkno.show();

    }

}
