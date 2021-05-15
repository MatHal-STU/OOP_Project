package gui;

import background.Firma;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneObjednavka {

    public SceneObjednavka(Stage hlavneOkno, Firma firma){
        super();

        VBox uctolayout = new VBox(10);
        Button odhlas2 = new Button("Odhlásiť");
        Button objednaj = new Button("Objednaj");

        TilePane nazovFirmy = new TilePane(Orientation.HORIZONTAL);
        Label nf = new Label("Meno firmy");
        TextField textNazov = new TextField();


        TilePane znacka = new TilePane(Orientation.HORIZONTAL);
        Label zn = new Label("Značka");
        ChoiceBox<String> model = new ChoiceBox<>();
        model.getItems().addAll("VW","Audi");
        model.setValue("VW");


        TilePane mnozstvo = new TilePane(Orientation.HORIZONTAL);
        Label mn = new Label("Množstvo");
        TextField textmnozstvo = new TextField();

        nazovFirmy.getChildren().addAll(nf,textNazov);
        znacka.getChildren().addAll(zn,model);
        mnozstvo.getChildren().addAll(mn,textmnozstvo);

        odhlas2.setOnAction(e -> new SceneUvod(hlavneOkno,firma));
        uctolayout.getChildren().addAll(nazovFirmy,znacka,mnozstvo,odhlas2);
        Scene scenaUctovnictvo = new Scene(uctolayout,500,300);

        hlavneOkno.setScene(scenaUctovnictvo);
        hlavneOkno.show();
    }
}
