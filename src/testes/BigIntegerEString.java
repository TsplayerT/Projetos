package testes;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class BigIntegerEString {

    public static void main(String[] args) throws UnsupportedEncodingException {

//<editor-fold defaultstate="collapsed" desc="V1">
        //        Scanner input = new Scanner(System.in);
        //
        //        int d, x = 0;
        //        int[] b = new int[10];
        //
        //        System.out.print("Digite um número: ");
        //        d = input.nextInt();
        //
        //        while (d > 1) {
        //            b[x] = d % 2;
        //
        //            d = d / 2;
        //
        //            x++;
        //        }
        //
        //        for (int cont = b.length - 1; cont >= 0; cont--) {
        //            System.out.println(b[cont]);
        //        }
        //</editor-fold>      
//<editor-fold defaultstate="collapsed" desc="V2">
//        String entrada = "01001011";
//        int c = Integer.parseInt(entrada, 2);//Converter String com representação binária (Base 2) para Inteiro
//        System.out.println(c);//Código ASCII
//        Character ch = Character.toString((char) c).charAt(0);
//        System.out.println(ch);//Representação ASCII
//
//        String saida = Integer.toBinaryString(c);//Convertendo código ASCII para representação binária
//        //String saida = Integer.toBinaryString((int)ch.charValue());//Ou poderia converter a partir do Character para Binário
//        System.out.println(saida);//String com representação binária
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="V3">
//        String str = "abc";
//        StringBuilder sb = new StringBuilder();
//        for (char c : str.toCharArray()) {
//            sb.append((int) c);
//        }
//        BigIntegerEString mInt = new BigIntegerEString(sb.toString());
//        System.out.println(mInt);
//</editor-fold>
        
        String msg = "ca";
        System.out.println("mensagem: "+msg);
        BigInteger bi = new BigInteger(msg.getBytes());
        System.out.println("codificação: "+bi);
        //System.out.println(new String(bi.toByteArray()));
        //BigInteger cod = 97;
        

    }
}
