package gui;

import background.Firma;
import background.LogistikaControler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Material;
import javafx.stage.Stage;
import managment.Logistika;

public class SceneLogistika extends Stage {

    public SceneLogistika(Stage hlavneOkno,Firma firma){
        super();


        Button odhlas1 = new Button("Odhlásiť");
        Button objednajMaterial = new Button("Doobjednat Material");
        ChoiceBox<String> choiceBoxmodel = new ChoiceBox<>();

        Button sklad = new Button("Sklad");
        sklad.setOnAction(e -> new WinSklad(firma));

        choiceBoxmodel.getItems().addAll("VW","Audi");
        choiceBoxmodel.setValue("VW");
        odhlas1.setOnAction(e -> new SceneUvod(hlavneOkno,firma));
        VBox loglayout = new VBox(10);
        loglayout.getChildren().addAll(objednajMaterial,choiceBoxmodel,sklad,odhlas1);
        Scene scenaLogistika = new Scene(loglayout,500,300);

        hlavneOkno.setScene(scenaLogistika);
        hlavneOkno.show();

    }
}
