package gui;

import background.Firma;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WinPlan extends Stage {
    public WinPlan(Firma firma){
        VBox planlayout = new VBox(10);



        TilePane tileVW = new TilePane(Orientation.HORIZONTAL);
        Label vw = new Label("VW");
        TextField vwPocet = new TextField();
        tileVW.getChildren().addAll(vw,vwPocet);

        TilePane tileAudi = new TilePane(Orientation.HORIZONTAL);
        Label audi = new Label("Audi");
        TextField audiPocet = new TextField();
        tileAudi.getChildren().addAll(audi,audiPocet);



        Button zadat = new Button("Zadať plán");

        zadat.setOnAction(event -> firma.zadatPlan(vwPocet.getText(),audiPocet.getText()));

        planlayout.getChildren().addAll(tileVW,tileAudi,zadat);



        setScene(new Scene(planlayout, 500, 300));
        show();

    }
}
