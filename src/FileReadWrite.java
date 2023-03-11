import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Scanner;

public class FileReadWrite {
    private static final String ENCODING_KEY = "7PvdZj+y/LHUwvS8WfCCwQ==";

    public void selectFile() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il percorso completo del file da codificare:");
        String filePath = scanner.nextLine();
        File inputFile = new File(filePath);
        if (inputFile.exists()) {
            String encodedContent = encrypt(readFileAsString(inputFile), ENCODING_KEY);
            String outputPath = inputFile.getParent() + File.separator + "encoded_" + inputFile.getName();
            writeFile(outputPath, encodedContent);
            System.out.println("Il file è stato codificato con successo e salvato come: " + outputPath);
        } else {
            System.out.println("Il file non esiste.");
        }
    }

    public void decodeFile() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il percorso completo del file codificato da decodificare:");
        String filePath = scanner.nextLine();
        File inputFile = new File(filePath);
        if (inputFile.exists()) {
            String decodedContent = decrypt(readFileAsString(inputFile), ENCODING_KEY);
            String outputPath = inputFile.getParent() + File.separator + "decoded_" + inputFile.getName();
            writeFile(outputPath, decodedContent);
            System.out.println("Il file è stato decodificato con successo e salvato come: " + outputPath);
        } else {
            System.out.println("Il file non esiste.");
        }
    }

    public String readFileAsString(File file) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    public void writeFile(String filePath, String content) throws IOException {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            writer.print(content);
        }
    }

    public static String encrypt(String plainText, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] cipherText = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(cipherText);
    }

    public static String decrypt(String encodedText, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] cipherText = Base64.getDecoder().decode(encodedText);
        byte[] decryptedText = cipher.doFinal(cipherText);
        return new String(decryptedText, StandardCharsets.UTF_8);
    }
}

