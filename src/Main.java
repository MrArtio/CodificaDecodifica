import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci Stringa da codificare: ");
        String codificare = in.nextLine();
        CodificaDecodifica codificaDecodifica = new CodificaDecodifica(codificare);
        codificaDecodifica.codificaDecodifica();
    }
}