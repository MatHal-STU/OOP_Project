package gui;

import background.Firma;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class SceneProdukcia extends Stage {


    public SceneProdukcia(Stage hlavneOkno){
        super();

        Firma firma = new Firma();

        VBox prodlayout = new VBox(5);
        TilePane tileButtonsProdukcia = new TilePane(Orientation.HORIZONTAL);
        TilePane tilevyroba = new TilePane(Orientation.HORIZONTAL);
        Button vypisPracovnikov = new Button("Zoznam Pracovnikov");
        Button objednavka = new Button("Objednavky");
        TextArea vypisProdukcia = new TextArea();

        Button vyrobit = new Button("Vyrobiť P");
        ChoiceBox<String> choiceBoxmodel = new ChoiceBox<>();
        TextField textmnozstvo = new TextField();
        Label mn = new Label("Množstvo");

        choiceBoxmodel.getItems().addAll("VW","Audi");
        vyrobit.setOnAction(event ->{
            vypisProdukcia.clear();
            vypisProdukcia.appendText("Vyroba zahajena!\n"+ firma.vyrobaP(choiceBoxmodel,Integer.parseInt(textmnozstvo.getText())));

        });
        vypisPracovnikov.setOnAction(event ->{
            vypisProdukcia.clear();
            vypisProdukcia.appendText(firma.vypisRobotnikov());

        });


        Button sklad = new Button("Sklad");
        sklad.setOnAction(e -> new WinSklad());

        Button odhlas = new Button("Odhlásiť");
        odhlas.setOnAction(e -> new SceneUvod(hlavneOkno));

        tilevyroba.getChildren().addAll(textmnozstvo,mn,choiceBoxmodel,vyrobit);
        tileButtonsProdukcia.getChildren().addAll(objednavka,vypisPracovnikov,sklad, odhlas);
        prodlayout.getChildren().addAll(tileButtonsProdukcia,tilevyroba, vypisProdukcia);
        Scene scenaProdukcia = new Scene(prodlayout,700,500);



        hlavneOkno.setScene(scenaProdukcia);
        hlavneOkno.show();

    }
}
