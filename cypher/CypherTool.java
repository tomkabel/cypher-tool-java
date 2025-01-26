package cypher;

import java.util.Scanner;

public class CypherTool {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Cypher Tool!");
            boolean continueRunning = true;
            while (continueRunning) {
                InputData inputData = getInput(scanner);
                if (inputData == null) {
                    continueRunning = false;
                } else {
                    try {
                        System.out.printf("\nResult %s\n", processInput(inputData));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }
        }
        System.out.println("Exiting the program. Goodbye!");
    }

    /**
     * Prompts the user for input and collects the operation, cipher, and
     * message. This method uses helper methods (`promptOperation`,
     * `promptCipher`, and `promptMessage`) to gather the necessary input from
     * the user.
     *
     * @param scanner The Scanner object used to read user input.
     * @return An {@link InputData} object containing the operation, cipher, and
     * message. Returns {@code null} if the user chooses to exit at any point.
     */
    public static InputData getInput(Scanner scanner) {
        String operation = promptOperation(scanner);
        if (operation == null) {
            return null;
        }

        String cipher = promptCipher(scanner);
        if (cipher == null) {
            return null;
        }

        String message = promptMessage(scanner);
        if (message == null) {
            return null;
        }

        return new InputData(operation, cipher, message);
    }

    /**
     * Encrypts a string using the ROT13 cipher. ROT13 is a simple letter
     * substitution cipher that replaces a letter with the 13th letter after it
     * in the alphabet. For example: 'a' <==> 'n' 'b' <==> 'o' 'C' <==> 'P'
     *
     * This method handles both lowercase and uppercase letters. Non-alphabetic
     * characters (e.g., numbers, symbols, or spaces) are appended to the result
     * without modification.
     *
     * @param s The input string to be encrypted.
     * @return The encrypted string.
     */
    public static String encryptRot13(String s) {
        return rot13(s);
    }

    /**
     * Decrypts a string using the ROT13 cipher. Since ROT13 is its own inverse,
     * decryption is the same as encryption.
     *
     * @param s The input string to be decrypted.
     * @return The decrypted string.
     */
    public static String decryptRot13(String s) {
        return rot13(s);
    }

    /**
     * Applies the ROT13 transformation to a given string. This method shifts
     * each letter in the input string by 13 positions in the alphabet.
     * Non-alphabetic characters are appended to the result without
     * modification.
     *
     * @param s The input string to be transformed.
     * @return The transformed string with each letter shifted by 13 positions.
     */
    private static String rot13(String s) {
        return shiftString(s, 13);
    }

    /**
     * Processes a message using the ROT13 cipher and formats the result.
     *
     * @param message The input message to be processed.
     * @return A formatted string containing the ROT13 transformation result.
     */
    private static String processRot13(String message) {
        return "(ROT13):\n" + rot13(message);
    }

    /**
     * Encrypts a string using the Atbash cipher. The Atbash cipher is a
     * substitution cipher where each letter in the alphabet is mapped to its
     * reverse.
     *
     * @param s The input string to be encrypted.
     * @return The encrypted string.
     */
    public static String encryptAtbash(String s) {
        return atbash(s);
    }

    /**
     * Decrypts a string using the Atbash cipher. Since Atbash is its own
     * inverse, decryption is the same as encryption.
     *
     * @param s The input string to be decrypted.
     * @return The decrypted string.
     */
    public static String decryptAtbash(String s) {
        return atbash(s);
    }

    /**
     * Processes a message using the Atbash cipher and formats the result.
     *
     * @param message The input message to be processed.
     * @return A formatted string containing the Atbash transformation result.
     */
    private static String processAtbash(String message) {
        return "(Atbash):\n" + atbash(message);
    }

    /**
     * Applies the Atbash cipher to a given string. The Atbash cipher is a
     * substitution cipher where each letter in the alphabet is mapped to its
     * reverse. For example: 'a' <==> 'z' 'B' <==> 'Y' 'c' <==> 'x'
     *
     * This method handles both lowercase and uppercase letters. Non-alphabetic
     * characters (e.g., numbers, symbols, or spaces) are appended to the result
     * without modification.
     *
     * @param s The input string to be transformed using the Atbash cipher.
     * @return The transformed string with each letter reversed in the alphabet.
     *
     * @implNote This method uses character arithmetic to get the reverse
     * letter: - For lowercase letters: {@code `c = (char) ('z' - (c - 'a'))`} -
     * For uppercase letters: {@code `c = (char) ('Z' - (c - 'A'))`}
     *
     * Example: "abcXYZ" <==> "zyxCBA"
     */
    private static String atbash(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                c = (char) ('z' - (c - 'a'));
            } else if (Character.isUpperCase(c)) {
                c = (char) ('Z' - (c - 'A'));
            }
            result.append(c);
        }

        return result.toString();
    }

    /**
     * Encrypts a string using the Caesar cipher with a fixed shift of 3. The
     * Caesar cipher shifts each letter in the alphabet by a fixed number of
     * positions.
     *
     * @param input The input string to be encrypted.
     * @return The encrypted string.
     */
    public static String encryptCaesar(String input) {
        return shiftString(input, 3);
    }

    /**
     * Decrypts a string using the Caesar cipher with a fixed shift of -3. The
     * Caesar cipher shifts each letter in the alphabet by a fixed number of
     * positions.
     *
     * @param input The input string to be decrypted.
     * @return The decrypted string.
     */
    public static String decryptCaesar(String input) {
        return shiftString(input, -3);
    }

    /**
     * Processes a message using the Caesar cipher and formats the result. This
     * method determines whether to encrypt or decrypt the message based on the
     * operation.
     *
     * @param operation The operation to perform ("1" for encrypt, "2" for
     * decrypt).
     * @param message The input message to be processed.
     * @return A formatted string containing the Caesar transformation result.
     */
    private static String processCaesar(String operation, String message) {
        if (operation.equals("1")) {
            return "(Caesar):\n" + encryptCaesar(message);
        } else {
            return "(Caesar):\n" + decryptCaesar(message);
        }
    }

    /**
     * Shifts each character in the input string by a specified number of
     * positions in the alphabet. This method handles both uppercase and
     * lowercase letters. Non-alphabetic characters are appended to the result
     * without modification.
     *
     * @param s The input string to be shifted.
     * @param shift The number of positions to shift each character.
     * @return The transformed string with each letter shifted by the specified
     * number of positions.
     *
     * @implNote For uppercase letters, the shift wraps around the 26 letters of
     * the alphabet if it goes beyond 'Z' or below 'A'. For lowercase letters,
     * the shift wraps around if it goes beyond 'z' or below 'a'.
     */
    public static String shiftString(String s, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isUpperCase(c)) {
                c += shift;
                if (c > 'Z') {
                    c -= 26;
                }
                if (c < 'A') {
                    c += 26;
                }
            } else if (Character.isLowerCase(c)) {
                c += shift;
                if (c > 'z') {
                    c -= 26;
                }
                if (c < 'a') {
                    c += 26;
                }
            }
            result.append(c);
        }
        return result.toString();
    }

    /**
     * Prompts the user to select an operation (encrypt or decrypt). This method
     * repeatedly prompts the user until a valid input is provided or the user
     * chooses to exit.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The selected operation ("1" for encrypt, "2" for decrypt).
     * Returns {@code null} if the user chooses to exit.
     */
    private static String promptOperation(Scanner scanner) {
        while (true) {
            System.out.println("\nSelect operation:");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.println("Enter 'exit' to quit.");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                return null;
            } else if (input.equals("1")) {
                return input;
            } else if (input.equals("2")) {
                return input;
            } else {
                System.out.println("Error: You entered '" + input + "', which is not a valid operation.");
                System.out.println("Please enter one of the following options:");
                System.out.println("- 1 for Encrypt");
                System.out.println("- 2 for Decrypt");
                System.out.println("- 'exit' to quit.");
            }
        }
    }

    /**
     * Prompts the user to select a cipher (ROT13, Atbash, or Caesar). This
     * method repeatedly prompts the user until a valid input is provided or the
     * user chooses to exit.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The selected cipher ("1" for ROT13, "2" for Atbash, "3" for
     * Caesar). Returns {@code null} if the user chooses to exit.
     */
    private static String promptCipher(Scanner scanner) {
        while (true) {
            System.out.println("\nSelect cipher:");
            System.out.println("1. ROT13");
            System.out.println("2. Atbash");
            System.out.println("3. Caesar");
            System.out.println("Enter 'exit' to quit.");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                return null;
            } else if (input.equals("1")) {
                return input;
            } else if (input.equals("2")) {
                return input;
            } else if (input.equals("3")) {
                return input;
            } else {
                System.out.println("Error: You entered '" + input + "', which is not a valid option.");
                System.out.println("Please enter one of the following options:");
                System.out.println("- 1 for ROT13");
                System.out.println("- 2 for Atbash");
                System.out.println("- 3 for Caesar");
                System.out.println("- 'exit' to quit.");
            }
        }
    }

    /**
     * Prompts the user to enter a message or choose to exit. This method
     * repeatedly prompts the user until a non-empty message is provided or the
     * user chooses to exit.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The input message. Returns null if the user chooses to exit.
     */
    private static String promptMessage(Scanner scanner) {
        while (true) {
            System.out.println("\nEnter the message (or 'exit' to quit):");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                return null;
            } else if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Error: The message cannot be empty.");
                System.out.println("Please enter a valid message or type 'exit' to quit.");
            }
        }
    }

    /**
     * Processes the input data based on the selected cipher and operation. This
     * method routes the input to the appropriate cipher processing method.
     *
     * @param inputData The input data containing the operation, cipher, and
     * message.
     * @return The result of the cipher transformation.
     * @throws IllegalArgumentException If an invalid cipher is selected.
     */
    private static String processInput(InputData inputData) {
        if (inputData.cipher.equals("1")) {
            return processRot13(inputData.message);
        } else if (inputData.cipher.equals("2")) {
            return processAtbash(inputData.message);
        } else if (inputData.cipher.equals("3")) {
            return processCaesar(inputData.operation, inputData.message);
        } else {
            throw new IllegalArgumentException("Invalid cipher selection. Please choose 1 (ROT13), 2 (Atbash), or 3 (Caesar).");
        }
    }

    /**
     * A data class to store the operation, cipher, and message provided by the
     * user.
     */
    public static class InputData {

        /**
         * The operation to perform. Valid values are: - "1" for encrypt - "2"
         * for decrypt
         */
        String operation;

        /**
         * The selected cipher. Valid values are: "1" for ROT13 - "2" for Atbash
         * - "3" for Caesar
         */
        String cipher;

        /**
         * The message to be processed. This can be any non-empty string.
         */
        String message;

        /**
         * Constructs an InputData object with the specified operation, cipher,
         * and message.
         *
         * @param operation The operation to perform.
         * @param cipher The selected cipher.
         * @param message The message to be processed.
         */
        InputData(String operation, String cipher, String message) {
            this.operation = operation;
            this.cipher = cipher;
            this.message = message;
        }
    }

}
