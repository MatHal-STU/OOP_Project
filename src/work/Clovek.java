package work;

import products.PalubovkaAudi;
import products.PalubovkaVW;

public interface Clovek  {
        void setVyplata(int ciastka);
        int getVyplata();
        void vykonaj(String model, PalubovkaVW vw, PalubovkaAudi audi);
}
