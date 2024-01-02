package basics.generics.wildcard;


import java.util.List;

public class Print {
    public void setPrintValues(List<? extends Vehicle> vehicles){}

    public void setPrintValuesWithoutWildcard(List<Vehicle> vehicles){

    }
}

class Vehicle{}
