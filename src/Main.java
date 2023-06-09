import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String input;
        do {
            System.out.print("\n1) Codifica");
            System.out.print("\n2) Decodifica");
            System.out.print("\n3) Seleziona file da codificare");
            System.out.print("\n4) Seleziona file da decodificare");
            System.out.print("\n5) Generatore di chiavi");
            System.out.print("\n6) Exit");
            System.out.print("\n");
            System.out.print("\nInput: ");

            input = in.nextLine();

            switch (input) {
                case "1" -> {
                    try {
                        ConfigReader cr1 = new ConfigReader();
                        System.out.print("Inserisci Stringa da Codificare: ");
                        String codificare = in.nextLine();
                        String encodedText = CodificaDecodifica.encrypt(codificare,cr1.getEncryptionKey());
                        System.out.println("Testo codificato: " + encodedText);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "2" -> {
                    try {
                        ConfigReader cr2 = new ConfigReader();
                        System.out.print("Inserisci Stringa da Decodificare: ");
                        String decodificare = in.nextLine();
                        String decodedText = CodificaDecodifica.decrypt(decodificare, cr2.getEncryptionKey());
                        System.out.println("Testo decodificato: " + decodedText);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "3" -> {
                    try {
                        FileReadWrite frw1 = new FileReadWrite();
                        frw1.selectFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "4" -> {
                    try {
                        FileReadWrite frw2 = new FileReadWrite();
                        frw2.decodeFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "5" -> {
                    KeyGenerator keyGen = new KeyGenerator();
                    keyGen.getKeyGenerator();
                }
            }
        } while (!input.equals("6")) ;
    }
}