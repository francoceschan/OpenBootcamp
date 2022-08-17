public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        Trabajador trabajador = new Trabajador();

        cliente.setNombre("Franco");
        cliente.setEdad(25);
        cliente.setTelefono("123123123");
        cliente.setCredito(2000);

        System.out.println("CLIENTE \nNombre: "+cliente.getNombre()+"\nEdad: "+cliente.getEdad()+"\nTelefono: "+cliente.getTelefono()+"\nCredito: "+cliente.getCredito());

        trabajador.setNombre("Ezequiel");
        trabajador.setEdad(20);
        trabajador.setTelefono("123123123");
        trabajador.setSalario(40000);

        System.out.println("TRABAJADOR \nNombre: "+trabajador.getNombre()+"\nEdad: "+trabajador.getEdad()+"\nTelefono: "+trabajador.getTelefono()+"\nSalario: "+trabajador.getSalario());
    }
}
