# Cypher Tool

A Java-based command-line tool for encrypting and decrypting messages using ROT13, Atbash, and a custom cipher.

## Features
- **Encryption/Decryption Operations**: Supports ROT13, Atbash, and Caesar cipher.
- **Interactive CLI**: User-friendly command-line interface for input and output.
- **Input Validation**: Ensures valid input for operations, ciphers, and messages.
- **Error Handling**: Provides clear feedback for invalid inputs and handles edge cases.

## Supported Ciphers
1. **ROT13**: Rotates each letter by 13 places in the alphabet.
2. **Atbash**: Maps each letter to its reverse in the alphabet (A ↔ Z, B ↔ Y, etc.).
3. **Caesar Cipher**: It is a type of substitution cipher where each letter in the plaintext is shifted by a fixed number of positions down or up the alphabet.


## Contributing

Contributions are welcome! Please follow these steps:

- Fork the repository.

- Create a new branch for your feature or bugfix (e.g. `feature/rot-13`)

- Submit a pull request with a detailed description of your changes.


## Running
Compile the Java files:
```bash
javac -d build Main.java
```
Run the project:
```bash
java -cp ./build Main
```
