package gui;


import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {

    Scene uvod;
    private final Button produkcia= new Button("Produkčný Manažment");
    private final Button logistika= new Button("Logistický Manažment");
    private final Button uctovnictvo= new Button("Účtovnícky Manažment");





    public static void main(String[] args) {
	    launch(args);
    }

    @Override
    public void start(Stage hlavneOkno) {
        hlavneOkno.setTitle("Demo");


        //Tlacidla na presmerovanie na uvodnej strane
        produkcia.setOnAction(e -> new SceneProdukcia(hlavneOkno));
        logistika.setOnAction(e -> new SceneLogistika(hlavneOkno));
        uctovnictvo.setOnAction(e -> new SceneUctovnictvo(hlavneOkno));

        VBox uvodlayout = new VBox(10);
        uvodlayout.getChildren().addAll(produkcia, logistika, uctovnictvo);
        uvod = new Scene(uvodlayout,500,300);



        hlavneOkno.setScene(uvod);
        hlavneOkno.show();

    }
}
