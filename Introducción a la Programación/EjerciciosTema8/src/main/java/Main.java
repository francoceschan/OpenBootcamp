public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona();

        persona.setNombre("Franco");
        persona.setEdad(25);
        persona.setTelefono("123123123");

        System.out.println("Nombre: "+persona.getNombre()+"\nEdad: "+persona.getEdad()+"\nTelefono: "+persona.getTelefono());
    }
}
