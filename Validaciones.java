import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class Validaciones {

    // Guarda el formato de fecha día/mes/año, en modo estricto para que rechace fechas ej: 31/02
    private final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/uuuu")
            // si la fecha no existe en el calendario, se rechaza
            .withResolverStyle(ResolverStyle.STRICT);

    // Validar entero
    public int ValidaEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor ingrese un valor entero numérico");
            sc.next();
        }
        return sc.nextInt();
    }

    // Validar decimales
    public Double ValidarDecimal(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println("Por faor ingrese un valor decimal");
            sc.next();
        }
        return sc.nextDouble();
    }

    // Validar rangos
    public int ValidarRango(Scanner sc, int minimo, int maximo) {
        int numero = ValidaEntero(sc);
        if (numero < minimo || numero > maximo) {
            System.out.println("Opción no válida, elija un número entre " + minimo + " y " + maximo);
            return ValidarRango(sc, minimo, maximo);
        }
        return numero;
    }

    // Validar valores positivos para el modelo del carro o los días del contrato
    public int ValidarEnteroPositivo(Scanner sc) {
        int numero = ValidaEntero(sc);
        if (numero <= 0) {
            System.out.println("El valor debe ser mayor que cero");
            return ValidarEnteroPositivo(sc);
        }
        return numero;
    }

    // Validar campos para que no queden vacíos
    private String LeerNoVacio(Scanner sc) {
        String texto = sc.nextLine().trim();
        if (texto.isEmpty()) {
            System.out.println("Este campo no puede quedar vacío");
            return LeerNoVacio(sc);
        }
        return texto;
    }

    // Validar texto solo con letras y espacios (nombre, apellido, marca)
    public String ValidarTexto(Scanner sc) {
        String texto = LeerNoVacio(sc);
        // si tiene números o símbolos (solo se aceptan letras, tildes, ñ y espacios)
        if (!texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            System.out.println("Solo se permiten letras, sin números ni caracteres especiales");
            return ValidarTexto(sc);
        }
        return texto;
    }

    // Validar datos alfanumericos como:cédula, placa, licencia.
    public String ValidarAlfanumerico(Scanner sc) {
        String texto = LeerNoVacio(sc);
        if (!texto.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+")) {
            System.out.println("No se permiten caracteres especiales");
            return ValidarAlfanumerico(sc);
        }
        return texto;
    }

    // Valida direcciones: acepta letras, números y los símbolos propios de una
    // dirección (# - . , /)
    public String ValidarDireccion(Scanner sc) {
        String direccion = LeerNoVacio(sc);
        // si tiene algún símbolo raro (solo se aceptan letras, números, tildes, ñ,
        // espacios y # . , / -)...
        if (!direccion.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ #.,/-]+")) {
            System.out.println("Dirección no válida, solo se permiten letras, números y los símbolos # - . , /");
            return ValidarDireccion(sc);
        }
        return direccion;
    }

    // Valida datos que solo tenga dígitos (teléfono); se guarda como String, no
    // como número
    public String ValidarSoloNumeros(Scanner sc) {
        String texto = LeerNoVacio(sc);
        // si hay algo que no sea un dígito del 0 al 9 (letras, espacios, guiones)
        if (!texto.matches("[0-9]+")) {
            System.out.println("Solo se permiten números, sin espacios ni guiones");
            return ValidarSoloNumeros(sc);
        }
        return texto;
    }

    // Valida una fecha en formato dd/mm/aaaa y comprueba que exista en el
    // calendario
    public String ValidarFecha(Scanner sc) {
        String fecha = LeerNoVacio(sc);
        // intenta convertir el texto en una fecha real
        try {
            // si Java la entiende con el formato día/mes/año, la fecha es válida
            LocalDate.parse(fecha, formatoFecha);
            return fecha;
            // si Java no la pudo entender (formato malo o fecha que no existe, ej: 31/02)
        } catch (DateTimeParseException e) {
            System.out.println("Fecha no válida, use el formato dd/mm/aaaa (15/11/2026)");
            return ValidarFecha(sc);
        }
    }
}