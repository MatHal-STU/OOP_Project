package background;

public class Doplnenie {
    public DoplnenieMaterialu getZn (String znacka){
        if(znacka == null){
            return null;
        }
        if(znacka.equalsIgnoreCase("VW")){
            return new VWMaterial();

        } else if(znacka.equalsIgnoreCase("Audi")){
            return new AudiMaterial();

        }

        return null;
    }
}
