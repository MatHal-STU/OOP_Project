package gui;

import background.Firma;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WinSklad extends Stage {

    public WinSklad(Firma firma){
        VBox skladlayout = new VBox(10);



        TilePane tileButtonsSklad = new TilePane(Orientation.HORIZONTAL);




        Button palubovky = new Button("Palubovky");


        Button material = new Button("Material");
        tileButtonsSklad.getChildren().addAll(material, palubovky);
        TextArea vypisSklad = new TextArea();
        skladlayout.getChildren().addAll(tileButtonsSklad, vypisSklad);

        palubovky.setOnAction(e->{
            vypisSklad.clear();
            vypisSklad.appendText(firma.vypisPalub());

        });

        material.setOnAction(e-> { });

        setScene(new Scene(skladlayout, 500, 300));
        show();

    }

}
