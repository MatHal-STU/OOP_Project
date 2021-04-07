package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneUctovnictvo extends Stage {

    public SceneUctovnictvo(Stage hlavneOkno){
        super();

        VBox uctolayout = new VBox(10);
        Button odhlas2 = new Button("Odhlásiť");
        odhlas2.setOnAction(e -> new SceneUvod(hlavneOkno));
        uctolayout.getChildren().addAll(odhlas2);
        Scene scenaUctovnictvo = new Scene(uctolayout,500,300);

        hlavneOkno.setScene(scenaUctovnictvo);
        hlavneOkno.show();
    }
}
