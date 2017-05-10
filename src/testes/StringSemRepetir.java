package testes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class StringSemRepetir {

    static String[] vetor = {"A", "C", "G", "D", "SD", "S"};

    public static void t1() {

        for (int j = 0; j < vetor.length - 1; j++) {
            if (vetor[j].equals(vetor[j + 1])) {
                String auxiliar = vetor[j];
                vetor[j] = vetor[j + 1];
                vetor[j + 1] = auxiliar;
            }
        }
    }

    public static void t2() {
        Random rand = new Random();
        int tamanho = vetor.length;
        for (int i = 0; i < tamanho - 1; i++) {
            if (vetor[i].compareTo(vetor[i + 1]) < 0) {
                int index = rand.nextInt(vetor.length);
                vetor[index] = vetor[i];
                vetor[i] = vetor[index];
                vetor[index] = vetor[i];
            }
        }
    }

    public static void t3() {
        Random rand = new Random();
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                if (vetor[j].compareTo(vetor[j + 1]) > 0) {
                    int index = rand.nextInt(vetor.length);
                    vetor[index] = vetor[i];
                    vetor[i] = vetor[index];
                    vetor[index] = vetor[i];
                }
            }
        }
    }

    public static void t4() {

        String vetor[] = new String[4];
        vetor[0] = "z";
        vetor[1] = "a";
        vetor[2] = "g";
        vetor[3] = "d";
        Arrays.sort(vetor, new Comparator() {
            public int compare(Object o1, Object o2) {
                String a = (String) o1;
                String b = (String) o2;
                return a.compareTo(b);
            }
        });
    }

    public static void t5() {
        int[] valor = new int[4];
        for (int v = 0; v < valor.length; v++) {
            valor[v] = v;
        }
        int i = valor.length - 1;
        Random random = new Random();
        while (i > 0) {
            int index = random.nextInt(i);
            valor[index] ^= valor[i];
            valor[i] ^= valor[index];
            valor[index] ^= valor[i];
            i--;
        }
        for (int x = 0; x < valor.length; x++) {
            System.out.print(valor[x] + ",");
        }
    }

    public static void t6() {
        int i = vetor.length - 1;
        Random random = new Random();
        while (i > 0) {
            int index = random.nextInt(i);
            if (vetor[i].equals(vetor[i + 1])) {
                vetor[index] = vetor[i];
                vetor[i] = vetor[index];
                vetor[index] = vetor[i];
                i--;
            }
        }
    }

    public static void main(String[] args) {
        t6();
        System.out.println();
        for (int x = 0; x < vetor.length; x++) {
            System.out.print(vetor[x] + ",");
        }
    }

}
