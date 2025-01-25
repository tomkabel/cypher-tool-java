package cypher;
import java.util.Scanner;

public class CypherTool {

    public static String encryptRot13(String s) {
        
        return shiftString(s, 13);
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

    public static char reverseLetter(char input) {
        return (char) ('z'-(input - 'a'));
    }

    public static String shiftString(String s, int shift) {
        // Hello World / 3
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++) {
            char letter = s.charAt(i);
            if (letter >= 'A' && letter <= 'Z') {
                letter += shift;
                if (letter > 'Z') {
                    letter -= 26;
                } else if (letter < 'A') {
                    letter += 26;
                }
            } else if (letter >= 'a' && letter <= 'z') {
                letter += shift;
                if (letter > 'z') {
                    letter -= 26;
                } else if (letter < 'a') {
                    letter += 26;
                }
            }
            sb.append(letter);

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Cypher Tool!");
        System.out.println("Select operation: ");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        String operation = scanner.nextLine();

        System.out.println("Select cypher:");
        System.out.println("1. ROT13");
        System.out.println("2. Atbash");
        System.out.println("3. Caesar");

        String cipher = scanner.nextLine();

        System.out.println("Enter the message:");
        String message = scanner.nextLine();

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
