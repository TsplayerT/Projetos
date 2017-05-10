package testes;

public class DoubleEString {

    public static void main(String[] args) {
        String aux1 = "12.9";
        double aux3 = Math.ceil(Double.parseDouble(aux1));
        String aux2 = Double.toString(aux3).substring(0, 2);
        System.out.println(aux2);
    }

}
