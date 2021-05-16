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

        TilePane objednavka = new TilePane(Orientation.HORIZONTAL);
        TextField cisloObjednavky = new TextField();
        Label cislo = new Label("Č. Objednávky");
        Button odoslat = new Button("Odoslať objednávku");
        Button objednavky = new Button("Objednávky");
        objednavka.getChildren().addAll(objednavky,cislo, cisloObjednavky , odoslat);

        Button plan = new Button("Zadať plán");

        plan.setOnAction(event -> new WinPlan(firma));

        objednavky.setOnAction(event ->{
            vypisLogistika.clear();
            vypisLogistika.appendText(firma.vypisObjednavok());
        });

        odoslat.setOnAction(event -> {
            vypisLogistika.clear();
            try {
                String text = cisloObjednavky.getText();
                int number;

                if (Pattern.matches("[a-zA-Z]+", text)) {
                    throw new ZlySymbol();
                }
                number = Integer.parseInt(text);
                vypisLogistika.appendText(firma.odslatObjednavku(number));
            } catch (ZlySymbol ex) {
                ex.alert();
            }

        });


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
        loglayout.getChildren().addAll(doplnit, sklad,objednavka,plan, vypisLogistika, odhlas1);
        Scene scenaLogistika = new Scene(loglayout, 700, 500);

        hlavneOkno.setScene(scenaLogistika);
        hlavneOkno.show();

    }
}
