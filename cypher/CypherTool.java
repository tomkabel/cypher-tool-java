package cypher;

import java.util.Scanner;

public class CypherTool {

    public static final Scanner scanner = new Scanner(System.in);

    public static String encryptRot13(String s) {

        return "(ROT13): \n"+shiftString(s, 13);
    }

    public static String decryptRot13(String s) {
        return "(ROT13): \n"+shiftString(s, -13);
    }

    public static String encryptAtbash(String s) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // Step 3: Get the current character at index i
            char letter = s.charAt(i);
            if (Character.isLowerCase(letter)) {
                letter = reverseLetterLowercase(letter);
            } else if(Character.isUpperCase(letter)) {
                letter = reverseLetterUppercase(letter);
            }
            strBuilder.append(letter);
        }

        return "(Atbash): \n"+strBuilder.toString();
    }

    public static String decryptAtbash(String s) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // Step 3: Get the current character at index i
            char letter = s.charAt(i);
            if (Character.isLowerCase(letter)) {
                letter = reverseLetterLowercase(letter);
            } else if(Character.isUpperCase(letter)) {
                letter = reverseLetterUppercase(letter);
            }
            strBuilder.append(letter);
        }
        return "(Atbash): \n"+strBuilder.toString();
    }

    public static String encryptCaesar(String s) {
        return "(Caesar): \n"+shiftString(s, 3);
    }

    public static String decryptCaesar(String s) {
        return "(Caesar): \n"+shiftString(s, -3);
    }

    private static char reverseLetterLowercase(char input) {
        return (char) ('z'-(input - 'a'));
    }
    private static char reverseLetterUppercase(char input) {
        return (char) ('Z'-(input - 'A'));
    }
    public static String shiftString(String s, int shift) {
        // Step 1: Create a StringBuilder to store the shifted string
        StringBuilder strBuilder = new StringBuilder();

        // Step 2: Loop through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            // Step 3: Get the current character at index i
            char letter = s.charAt(i);

            // Step 4: Check if the character is an uppercase letter (A-Z)
            if (letter >= 'A' && letter <= 'Z') {
                // Step 5: Shift the character by the specified amount
                letter += shift;

                // Step 6: Handle wrapping around if the character goes beyond 'Z'
                if (letter > 'Z') {
                    letter -= 26; // Wrap around to the beginning of the uppercase alphabet
                } // Step 7: Handle wrapping around if the character goes below 'A'
                else if (letter < 'A') {
                    letter += 26; // Wrap around to the end of the uppercase alphabet
                }
            } // Step 8: Check if the character is a lowercase letter (a-z)
            else if (letter >= 'a' && letter <= 'z') {
                // Step 9: Shift the character by the specified amount
                letter += shift;

                // Step 10: Handle wrapping around if the character goes beyond 'z'
                if (letter > 'z') {
                    letter -= 26; // Wrap around to the beginning of the lowercase alphabet
                } // Step 11: Handle wrapping around if the character goes below 'a'
                else if (letter < 'a') {
                    letter += 26; // Wrap around to the end of the lowercase alphabet
                }
            }

            // Step 12: Append the shifted (or unshifted) character to the StringBuilder
            strBuilder.append(letter);
        }

        // Step 13: Convert the StringBuilder to a String and return the result
        return strBuilder.toString();
    }

    private static void doOperation() {
        System.out.println("Select operation: ");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        String operation = scanner.nextLine().trim();

        if (operation.equalsIgnoreCase("exit")) {
            System.out.println("Exiting the program. Goodbye!");
            return;
        }

        if (!operation.equals("1") && !operation.equals("2")) {
            System.out.println("Error: invalid input");
            doOperation();
            return;
        }
        doCypher(operation);
    }

    private static void doCypher(String operation) {
        System.out.println("Select cypher:");
        System.out.println("1. ROT13");
        System.out.println("2. Atbash");
        System.out.println("3. Caesar");

        String cipher = scanner.nextLine().trim();

        if (cipher.equalsIgnoreCase("exit")) {
            System.out.println("Exiting the program. Goodbye!");
            return;
        }

        if (!cipher.equals("1") && !cipher.equals("2") && !cipher.equals("3")) {
            System.out.println("Error: invalid input");
            doCypher(operation);
            return;
        }
        doMessage(cipher, operation);
    }

    private static void doMessage(String cipher, String operation) {
        System.out.println("Enter the message:");
        String message = scanner.nextLine().trim();

        if (message.equalsIgnoreCase("exit")) {
            System.out.println("Exiting the program. Goodbye!");
            return;
        }

        System.out.println();

        String response = "";
        if (operation.equals("1")) {
            System.out.print("Encrypted message ");
            if (cipher.equals("1")) {
                response = encryptRot13(message);
            } else if (cipher.equals("2")) {
                response = encryptAtbash(message);
            } else if (cipher.equals("3")) {
                response = encryptCaesar(message);
            }
        } else if (operation.equals("2")) {
            System.out.print("Decrypted message ");
            if (cipher.equals("1")) {
                response = decryptRot13(message);

            } else if (cipher.equals("2")) {
                response = decryptAtbash(message);
            } else if (cipher.equals("3")) {
                response = decryptCaesar(message);

            }
        }
        System.out.print(response);
        System.out.println();
        System.out.println();
        doOperation();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Cypher Tool!");

        doOperation();
    }
}
