import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    private static ArrayList<Contacto> contactos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    listarContactos();
                    break;
                case 3:
                    buscarContacto();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida, intentá otra vez.");
            }
        } while (opcion != 4);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Mini Agenda ---");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Listar contactos");
        System.out.println("3. Buscar contacto por nombre");
        System.out.println("4. Salir");
        System.out.print("Elegí una opción: ");
    }

    private static int leerOpcion() {
        int opcion = -1;
        try {
            opcion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            // Ignorar error, opción inválida
        }
        return opcion;
    }

    private static void agregarContacto() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        contactos.add(new Contacto(nombre, telefono));
        System.out.println("Contacto agregado.");
    }

    private static void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos guardados.");
        } else {
            System.out.println("\nContactos:");
            for (Contacto c : contactos) {
                System.out.println(c);
            }
        }
    }

    private static void buscarContacto() {
        System.out.print("Ingrese el nombre a buscar: ");
        String nombreBuscado = scanner.nextLine().toLowerCase();

        boolean encontrado = false;
        for (Contacto c : contactos) {
            if (c.getNombre().toLowerCase().contains(nombreBuscado)) {
                System.out.println(c);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún contacto con ese nombre.");
        }
    }
}
