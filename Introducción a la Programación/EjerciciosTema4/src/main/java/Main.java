public class Main {
    public static void main(String[] args) {

        double numeroIf = -3;
        int numeroWhile = -8;
        int numeroDoWhile = 5;
        String estacion = "Auto";


        if (numeroIf > 0) {
            System.out.println("El numero es mayor a 0");
        } else if (numeroIf < 0) {
            System.out.println("El numero es menor a 0");
        } else {
            System.out.println("El numero es 0");
        }

        while (numeroWhile < 3){
            System.out.println("El numeroWhile es: " + numeroWhile);
            numeroWhile++;
        }

        do {
            System.out.println("El numeroDoWhile es: " + numeroDoWhile);
            numeroDoWhile++;
        } while (numeroDoWhile < 3);

        for (int numeroFor = 0; numeroFor <= 3 ; numeroFor++) {
            System.out.println("El numeroFor es: " + numeroFor);
        }

        switch (estacion){
            case "Otoño":
                System.out.println("Estamos en Otoño");
                break;
            case "Invierno":
                System.out.println("Estamos en Invierno");
                break;
            case "Primavera":
                System.out.println("Estamos en Primavera");
                break;
            case "Verano":
                System.out.println("Estamos en Verano");
                break;
            default:
                System.out.println("El valor ingresado no es una estacion del año");
                break;
        }

    }
}
