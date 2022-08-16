

public class Main {

    public static double suma(double x,double y,double z){
        return x+y+z;
    }
    public static void main(String[]args){

        System.out.println( suma(2.3, 3.2, 4));

        Coche miCoche = new Coche();

        miCoche.agregarPuertas(3);

        System.out.println(miCoche.getPuertas());

    }
}

