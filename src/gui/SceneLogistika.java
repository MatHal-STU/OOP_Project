package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Material;
import javafx.stage.Stage;

public class SceneLogistika extends Stage {

    public SceneLogistika(Stage hlavneOkno){
        super();

        Button odhlas1 = new Button("Odhlásiť");
        Button objednajMaterial = new Button("Doobjednat Material");
        ChoiceBox<String> choiceBoxmodel = new ChoiceBox<>();

        choiceBoxmodel.getItems().addAll("VW","Audi");
        odhlas1.setOnAction(e -> new SceneUvod(hlavneOkno));
        VBox loglayout = new VBox(10);
        loglayout.getChildren().addAll(objednajMaterial,choiceBoxmodel,odhlas1);
        Scene scenaLogistika = new Scene(loglayout,500,300);

        hlavneOkno.setScene(scenaLogistika);
        hlavneOkno.show();

    }
}
