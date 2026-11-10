import java.util.Scanner;

// Clase encargada de mostrar los menús y devolver la opción que escogió el usuario.
public class Menu {

    private Validaciones v = new Validaciones();

    public int MenuPrincipal(Scanner sc) {
        System.out.println("----------------------------------------");
        System.out.println("   RENTING DE CARROS   ");
        System.out.println("----------------------------------------");
        System.out.println("1. Gestión de clientes");
        System.out.println("2. Gestión de vehículos");
        System.out.println("3. Gestión de contratos de renting");
        System.out.println("4. Imprimir informe general");
        System.out.println("5. Salir del sistema");
        System.out.print("Opción seleccionada: ");
        return v.ValidarRango(sc, 1, 5);
    }
}