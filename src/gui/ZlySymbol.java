package gui;

import javafx.scene.control.Alert;

public class ZlySymbol extends Exception{

    public void alert (){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Chyba");
        a.setContentText("Nezadaný správny symbol");
        a.showAndWait();
    }
}
