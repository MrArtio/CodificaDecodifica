import java.util.Base64;
public class CodificaDecodifica {
    private String codifica;
    public CodificaDecodifica(String cf) {
        this.codifica = cf;
    }
    public void codificaDecodifica() {
        // codifica una stringa usando l'encoder `Base64`
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode(this.codifica.getBytes());
        System.out.println("Encoded Data: " + new String(encodedBytes));

        // decodifica i dati codificati
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(encodedBytes);
        System.out.println("Decoded Data: " + new String(decodedBytes));
    }
}
