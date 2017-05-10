package principal;

public class RemoverChar {

    public static void main(String[] args) {
        
        String frase = "TIRAR";
        frase = frase.substring(0, frase.length()-1);
        System.out.println(frase);
    }

}
