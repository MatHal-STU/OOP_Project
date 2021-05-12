package background;

import products.MaterialAudi;
import products.MaterialVW;
import products.PalubovkaAudi;
import products.PalubovkaVW;

import java.io.*;

public class Serializacia implements Serializable {
    public static final long serialVersionUID = 0;
    private int pocetPaluboviekAudi;
    private int pocetPaluboviekVW;

    public int getPocetPaluboviekAudi() {
        return pocetPaluboviekAudi;
    }

    public void setPocetPaluboviekAudi(int pocetPaluboviekAudi) {
        this.pocetPaluboviekAudi = pocetPaluboviekAudi;
    }

    public int getPocetPaluboviekVW() {
        return pocetPaluboviekVW;
    }

    public void setPocetPaluboviekVW(int pocetPaluboviekVW) {
        this.pocetPaluboviekVW = pocetPaluboviekVW;
    }

    public int getPocetMaterialuAudi() {
        return pocetMaterialuAudi;
    }

    public void setPocetMaterialuAudi(int pocetMaterialuAudi) {
        this.pocetMaterialuAudi = pocetMaterialuAudi;
    }

    public int getPocetMaterialuVW() {
        return pocetMaterialuVW;
    }

    public void setPocetMaterialuVW(int pocetMaterialuVW) {
        this.pocetMaterialuVW = pocetMaterialuVW;
    }

    private int pocetMaterialuAudi;
    private int pocetMaterialuVW;

    public Serializacia (int a,int b, int c , int d){
        pocetPaluboviekAudi = a;
        pocetPaluboviekVW = b;
        pocetMaterialuAudi = c;
        pocetMaterialuVW = d;
    }

    }
