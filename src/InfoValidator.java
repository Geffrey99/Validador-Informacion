import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Ejercicio de procesos ·DAM2
/*
**
* PARA COMPROBAR HABER SI FUNCIONAN LAS ENTRADAS-----------
* https://www.letradni.info/generador-nie
*
*
* */
public class InfoValidator {
    private static final String TELEFFONO_REGEX = "^\\d{3}-\\d{6}$";
    private static final String DNI_REGEX = "^\\d{8}-[A-Z]$";
    private static final String NIE_REGEX = "^[XYZ]\\d{7}[A-Z]$";
    private static final String EMAIL_REGEX = "^[\\w.-]+@[\\w.-]+\\.[A-Z]{2,4}$";
    private static final String CODIGOPOSTAL_REGEX = "^\\d{5}$";
    private static final String MATRICULACOCHE_REGEX = "^\\d{4}-[A-Z]{3}$";

    private static final char[] LETRAS_DNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*****************Bienvenido comprueba ✅ **************");

        validarInput(scanner, ">>> Número de teléfono (000-000000):", TELEFFONO_REGEX);

        validarDNI(scanner, " >>>  DNI (00000000-L): ");

        validarNIE(scanner, " >>>  NIE (L1234567L): ");

        validarInput(scanner, ">>> Correo electrónico (usuario@dominio.ext): ", EMAIL_REGEX);

        validarInput(scanner, ">>> Código postal (00000): ", CODIGOPOSTAL_REGEX);

        validarInput(scanner, ">>> Matrícula de coche (0000-XXX): ", MATRICULACOCHE_REGEX);

        System.out.println("*****************CERRADO OK ❌ **************");
        scanner.close();
    }


    /**
    *@validarInput()
    * La entrada de  telefono, codigoPxx, email, matricula (todos los REGEX)))) Okokokok
    */
    private static void validarInput(Scanner scanner, String prompt, String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                System.out.println("El dato ingresado es OK ✅");
                break;
            } else {
                System.out.println("ERROR: El dato ingresado no es válido ❌" +
                        " Inténtelo de nuevo---");
            }
        }
    }



    /**
     *@validarDNI()
     * válida que el dni introducido tenga el formato correcto y la letra igual
     * y calcula la letra comparandola con la introooducida
     * Okokokok
     */
    private static void validarDNI(Scanner scanner, String prompt) {
        Pattern pattern = Pattern.compile(DNI_REGEX);
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches() && validarLetrasDNI(input)) {
                System.out.println("El DNI ingresado es es OK ✅");
                break;
            } else {
                System.out.println("ERROR: El dato ingresado no es válido ❌" +
                        " Inténtelo de nuevo---");
            }
        }
    }


    private static boolean validarLetrasDNI(String dni) {
        int number = Integer.parseInt(dni.substring(0, 8));
        char expectedLetter = LETRAS_DNI[number % 23];
        char actualLetter = dni.charAt(9);
        return expectedLetter == actualLetter;
    }


    /**
     *@validarNIE()
     * válida que el NIE ingresado tenga el formato correcto y que la letra sea correcta.
     * y convierte la letra inicial a un número antes de calcular la letra de control.
     * Okokokok
     */
    private static void validarNIE(Scanner scanner, String prompt) {
        Pattern pattern = Pattern.compile(NIE_REGEX);
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches() && validarLetrasNIE(input)) {
                System.out.println("El NIE ingresado es válido.");
                break;
            } else {
                System.out.println("Error: El NIE ingresado no es válido. Inténtelo de nuevo.");
            }
        }
    }

    private static boolean validarLetrasNIE(String nie) {
        char firstChar = nie.charAt(0);
        int number;
        if (firstChar == 'X') {
            number = 0;
        } else if (firstChar == 'Y') {
            number = 1;
        } else { // 'Z'
            number = 2;
        }
        number = number * 10000000 + Integer.parseInt(nie.substring(1, 8));
        char expectedLetter = LETRAS_DNI[number % 23];
        char actualLetter = nie.charAt(8);
        return expectedLetter == actualLetter;
    }
}


//OK