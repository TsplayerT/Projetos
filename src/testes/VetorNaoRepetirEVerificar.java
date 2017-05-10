package testes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.JComboBox;

public class VetorNaoRepetirEVerificar {

    static Random rand = new Random();

    static HashSet<String> dica = new HashSet<String>();
    static List<String> list;
    static JComboBox jcombobox = new JComboBox<>(new String[]{"Metais Alcalinos", "Metais Alcalino-Terrosos", "Metais de Transição", "Lantanídeos", "Actinídeos", "Metais Representativos", "Semi-Metais", "Não-Metais", "Halogênios", "Gases Nobres"});
    static String resposta = "Gases Nobres";
    String[] dicas;

    public static Object arryas(int quantidade) {
        while (dica.size() < quantidade) {
            dica.add(jcombobox.getItemAt(rand.nextInt(10)).toString());
            dica.add(resposta);
        }
        return dica;
    }

    public static void imprimir() {
//        int d = 0;
//        for (String s : dica) {
//            d++;
//            dicas.set(d, s);
//            dicas[d] = s;
//            System.out.println(d + "||" + s);
//        }
        Iterator iter = dica.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + "\n");
            //iter.remove();
        }
//        System.out.println(dica.size() + "  objetos: " + dica.toString());
//        dica.clear();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            arryas(3);
            imprimir();
        }
    }
}
