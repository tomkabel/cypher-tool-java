
import java.util.Scanner;

public class CypherTool {

    public static String encryptRot13(String s) {
        return s;
    }

    public static String encryptAtbash(String s) {
        return s;
    }

    public static String decryptRot13(String s) {
        return s;
    }

    public static String decryptAtbash(String s) {
        return s;
    }

    public static String encryptCaesar(String s) {
        return s;
    }

    public static String decryptCaesar(String s) {
        return s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Cypher Tool!");
        System.out.println("Select operation: ");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        String operation = scanner.next();

        System.out.println("Select cypher:");
        System.out.println("1. ROT13");
        System.out.println("2. Atbash");
        System.out.println("3. Caesar");

        String cipher = scanner.next();

        System.out.println("Enter the message:");
        String message = scanner.next();

        String response = "";
        if (operation.equals("1")) {
            System.out.println("Encrypted message: ");
            if (cipher.equals("1")) {
                response = encryptRot13(message);

            } else if (cipher.equals("2")) {
                response = encryptAtbash(message);
            } else if (cipher.equals("3")) {
                response = encryptCaesar(message);

            }
            System.out.println(response);
        } else if (operation.equals("2")) {
            System.out.println("Decrypted message: ");
            if (cipher.equals("1")) {
                response = decryptRot13(message);

            } else if (cipher.equals("2")) {
                response = decryptAtbash(message);
            } else if (cipher.equals("3")) {
                response = decryptCaesar(message);

            }
            System.out.println(response);
        }
    }
}
