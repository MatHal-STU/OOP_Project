package gui;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class SceneProdukcia extends Stage {


    public SceneProdukcia(Stage hlavneOkno){
        super();


        VBox prodlayout = new VBox(10);
        TilePane tileButtonsProdukcia = new TilePane(Orientation.HORIZONTAL);
        Button vypisPracovnikov = new Button("Zoznam Pracovnikov");
        Button objednavka = new Button("Objednavky");

        Button sklad = new Button("Sklad");
        sklad.setOnAction(e -> new WinSklad());

        Button odhlas = new Button("Odhlásiť");
        odhlas.setOnAction(e -> new SceneUvod(hlavneOkno));

        tileButtonsProdukcia.getChildren().addAll(objednavka, vypisPracovnikov, odhlas,sklad);
        TextArea vypisProdukcia = new TextArea();
        prodlayout.getChildren().addAll(tileButtonsProdukcia, vypisProdukcia);
        Scene scenaProdukcia = new Scene(prodlayout,500,300);



        hlavneOkno.setScene(scenaProdukcia);
        hlavneOkno.show();

    }
}
