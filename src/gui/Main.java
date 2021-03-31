package gui;

import background.Firma;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {

    Scene scenaProdukcia,scenaLogistika,scenaUctovnictvo,scenaSklad,uvod;
    private final Button produkcia= new Button("Produkčný Manažment");
    private final Button logistika= new Button("Logistický Manažment");
    private final Button uctovnictvo= new Button("Účtovnícky Manažment");
    private final Button sklad = new Button("Sklad");
    private final Button odhlas = new Button("Odhlásiť");
    private final Button odhlas1 = new Button("Odhlásiť");
    private final Button odhlas2 = new Button("Odhlásiť");
    private final Button odhlas3 = new Button("Odhlásiť");

    //Produkcia
    private final Button vypisPracovnikov = new Button("Zoznam Pracovnikov");
    private final Button objednavka = new Button("Objednavky");
    private final TextArea vypisProdukcia = new TextArea();

    //sklad
    private final Button material = new Button("Material");
    private final Button palubovky = new Button("Palubovky");
    private final TextArea vypisSklad = new TextArea();

    public static void main(String[] args) {
	    launch(args);
    }

    @Override
    public void start(Stage hlavneOkno) {
        hlavneOkno.setTitle("Demo");

        Firma firma = new Firma();


        //Tlacidla na presmerovanie na uvodnej strane
        produkcia.setOnAction(event -> hlavneOkno.setScene(scenaProdukcia));
        logistika.setOnAction(event -> hlavneOkno.setScene(scenaLogistika));
        uctovnictvo.setOnAction(event -> hlavneOkno.setScene(scenaUctovnictvo));
        sklad.setOnAction(event -> hlavneOkno.setScene(scenaSklad));

        //Tlacidlo na odhlasenie
        odhlas.setOnAction(event -> hlavneOkno.setScene(uvod));
        odhlas1.setOnAction(event -> hlavneOkno.setScene(uvod));
        odhlas2.setOnAction(event -> hlavneOkno.setScene(uvod));
        odhlas3.setOnAction(event -> hlavneOkno.setScene(uvod));

        //uvodna obrazovka
        VBox uvodlayout = new VBox(10);
        uvodlayout.getChildren().addAll(produkcia,logistika,uctovnictvo,sklad);
        uvod = new Scene(uvodlayout,500,300);

        //produkcia
        VBox prodlayout = new VBox(10);
        TilePane tileButtonsProdukcia = new TilePane(Orientation.HORIZONTAL);
        tileButtonsProdukcia.getChildren().addAll(objednavka,vypisPracovnikov,odhlas);
        prodlayout.getChildren().addAll(tileButtonsProdukcia,vypisProdukcia);
        scenaProdukcia = new Scene(prodlayout,500,300);

        //logistika
        VBox loglayout = new VBox(10);
        loglayout.getChildren().addAll(odhlas1);
        scenaLogistika = new Scene(loglayout,500,300);

        //Uctovnictvo
        VBox uctolayout = new VBox(10);
        uctolayout.getChildren().addAll(odhlas2);
        scenaUctovnictvo = new Scene(uctolayout,500,300);

        //Sklad
        VBox skladlayout = new VBox(10);
        TilePane tileButtonsSklad = new TilePane(Orientation.HORIZONTAL);
        tileButtonsSklad.getChildren().addAll(material,palubovky,odhlas3);
        skladlayout.getChildren().addAll(tileButtonsSklad,vypisSklad);
        scenaSklad = new Scene(skladlayout,500,300);

        hlavneOkno.setScene(uvod);
        hlavneOkno.show();
    }
}
