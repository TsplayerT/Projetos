package testes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Random;

public class SorteandoSemRepetir {

    public static void bubbleSort() {
        String[] vetor = {"A", "B", "C", "", "D"};
        int tamanho = vetor.length;
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1 - i; j++) {
                if (vetor[j].compareTo(vetor[j + 1]) > 0) {
                    String auxiliar = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = auxiliar;
                }
            }
        }
        for (int v = 0; v < vetor.length; v++) {
            System.out.println(vetor[v]);
        }
    }

    public static void ordem() {
        String[] vetor = {"a", "b", "c", "d", "e"};
        Arrays.sort(vetor, new Comparator() {
            public int compare(Object o1, Object o2) {
                String a = (String) o1;
                String b = (String) o2;
                return a.compareTo(b);
            }
        });
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }

    public static void ordenar() {
        List<Integer> numeros = new ArrayList<Integer>();
        for (int i = 1; i < 61; i++) { //Sequencia da mega sena
            numeros.add(i);
        }
        //Embaralhamos os números:
        Collections.shuffle(numeros);
        //Mostramos 6 aleatórios
        for (int i = 0; i < 40; i++) {
            System.out.print(numeros.get(i) + ",");
        }
    }

    public static void metodo() {
        String[] vetor = {"a", "b", "c", "d", "e"};
        Arrays.sort(vetor, 0, vetor.length);
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }

    public static void teste() {
        String[] vetor = {"a", "b", "c", "d", "e"};
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int t = 0; t <= vetor.length - 2; t++) {
                if ((vetor[t + 1].compareTo(vetor[t]) < 0)) {
                    String temp = vetor[t];
                    vetor[t] = vetor[t + 1];
                    vetor[t + 1] = temp;
                }
            }
        }
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }

    public static void suffles() {
        List<String> numeros = new ArrayList<String>();
        numeros.add("A");
        numeros.add("B");
        numeros.add("C");
        numeros.add("D");
        numeros.add("E");
        //Embaralhamos os números:
        Collections.shuffle(numeros);
        //Mostramos 6 aleatórios
        for (int i = 0; i < numeros.size(); i++) {
            System.out.println(numeros.get(i));
        }
    }

    public static String linha[], coluna[];

    public static void pegandoTabela() {
        String data = null, itens = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/testes/tabela.txt"));
            while ((data = reader.readLine()) != null) {
                itens += data;
            }
            linha = itens.split(";");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void set() {
        Random rand = new Random();

        Set<String> numeros = new TreeSet<String>();
        for (int i = 0; i < 4;) {
            int linha_aleatoria = rand.nextInt(linha.length);
            if (linha_aleatoria == 0) {
                linha_aleatoria = 1;
            }
            coluna = linha[linha_aleatoria].split(",");
            numeros.add(coluna[0]);
            if (numeros.size() == 4) {
                i = 4;
            }
        }
        System.out.println("Números gerados: " + numeros);

    }

    public static void minhaIdeia() {
        Random rand = new Random();
        String[] vetor = {"A", "B", "C", "D"};
        String[] fim = null;
        for (int i = 0; i < vetor.length;) {
            rand.nextInt(4);
            if (vetor[0] != vetor[1] & vetor[0] != vetor[2] & vetor[0] != vetor[3]) {
                fim[0] = vetor[0];
                i++;
            }
            if (vetor[1] != vetor[2] & vetor[1] != vetor[3]) {
                fim[1] = vetor[1];
                i++;
            }
            if (vetor[2] != vetor[3]) {
                fim[2] = vetor[2];
                i++;
            }
            fim[3] = vetor[3];
            i++;
            System.out.println(fim[i]);
        }
    }

    public static void main(String[] args) {
//        pegandoTabela();
//        set();

        suffles();
        //minhaIdeia();
        //teste();
        //metodo();
        //ordem();
        //bubbleSort();
        //ordenar();
    }

}
