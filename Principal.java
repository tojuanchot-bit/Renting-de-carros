// Trae la configuración regional para que los decimales se escriban con punto
import java.util.Locale;
import java.util.Scanner;

// Clase principal del sistema de renting
public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Le dice al Scanner que los decimales se escriben con punto (12.5) y no con coma
        sc.useLocale(Locale.US);
        Menu menu = new Menu();
        boolean continuar = true;

        while (continuar) {
            switch (menu.MenuPrincipal(sc)) {
                case 1:
                    System.out.println();
                    System.out.println("Página en mantenimiento");
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Página en mantenimiento");
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Página en mantenimiento");
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Página en mantenimiento");
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    System.out.println("¡Gracias por usar el sistema de renting. Hasta luego!");
                    System.out.println();
                    continuar = false;
                    break;
                // si llegara cualquier otro número (igual el menú ya valida del 1 al 5)
                default:
                    System.out.println("Esta opción no es válida");
                    break;
            }
        }
    }
}