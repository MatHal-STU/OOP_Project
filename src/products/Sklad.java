package products;

public class Sklad {

    public int getMaterial1() {
        return material1;
    }

    public void setMaterial1(int material1) {
        this.material1 = material1;
    }

    public int getMaterial2() {
        return material2;
    }

    public void setMaterial2(int material2) {
        this.material2 = material2;
    }

    public int getMaterial3() {
        return material3;
    }

    public void setMaterial3(int material3) {
        this.material3 = material3;
    }

    public int getPalubovka1() {
        return palubovka1;
    }

    public void setPalubovka1(int palubovka1) {
        this.palubovka1 = palubovka1;
    }

    public int getPalubovka2() {
        return palubovka2;
    }

    public void setPalubovka2(int palubovka2) {
        this.palubovka2 = palubovka2;
    }

    int material1=0,material2=0,material3=0;
    int palubovka1=0,palubovka2=0;

    static Sklad sklad = new Sklad();

    private Sklad(){

    }

    public static Sklad getInstance(){
        return sklad;
    }


}
