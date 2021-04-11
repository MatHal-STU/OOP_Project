package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneLogistika extends Stage {

    public SceneLogistika(Stage hlavneOkno){
        super();

        Button odhlas1 = new Button("Odhlásiť");
        Button objednajMaterial = new Button("Materialy");

        odhlas1.setOnAction(e -> new SceneUvod(hlavneOkno));
        VBox loglayout = new VBox(10);
        loglayout.getChildren().addAll(odhlas1);
        Scene scenaLogistika = new Scene(loglayout,500,300);

        hlavneOkno.setScene(scenaLogistika);
        hlavneOkno.show();

    }
}
