package gui;

import background.Firma;
import background.LogistikaControler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Material;
import javafx.stage.Stage;
import managment.Logistika;

import java.util.regex.Pattern;

public class SceneLogistika extends Stage {

    public SceneLogistika(Stage hlavneOkno, Firma firma) {
        super();


        Button odhlas1 = new Button("Odhlásiť");
        Button objednajMaterial = new Button("Objednat Material");
        ChoiceBox<String> choiceBoxmodel = new ChoiceBox<>();

        TilePane doplnit = new TilePane(Orientation.HORIZONTAL);
        Label pocet = new Label("Počet Materiálu");
        TextField textpocet = new TextField();
        choiceBoxmodel.getItems().addAll("VW", "Audi");
        choiceBoxmodel.setValue("VW");
        TextArea vypisLogistika = new TextArea();

        doplnit.getChildren().addAll(pocet, textpocet, choiceBoxmodel, objednajMaterial);

        Button sklad = new Button("Sklad");


        objednajMaterial.setOnAction(
                event -> {
                    try {
                        String text = textpocet.getText();
                        int number;

                        if (Pattern.matches("[a-zA-Z]+", text)) {
                            throw new ZlySymbol();
                        }
                        number = Integer.parseInt(text);
                        vypisLogistika.clear();
                        vypisLogistika.appendText(firma.doplnMaterial(choiceBoxmodel,number));
                    } catch (ZlySymbol ex) {
                        ex.alert();
                    }


                    //vypisProdukcia.clear();
                    // vypisProdukcia.appendText("Vyroba zahajena!\n"+ firma.vyrobaP(choiceBoxmodel,Integer.parseInt(textmnozstvo.getText())));

                });

        sklad.setOnAction(e -> new WinSklad(firma));


        odhlas1.setOnAction(e -> new SceneUvod(hlavneOkno, firma));
        VBox loglayout = new VBox(10);
        loglayout.getChildren().addAll(doplnit, sklad, vypisLogistika, odhlas1);
        Scene scenaLogistika = new Scene(loglayout, 700, 500);

        hlavneOkno.setScene(scenaLogistika);
        hlavneOkno.show();

    }
}
