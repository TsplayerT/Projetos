package testes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class NumeroAleatoriosSemRepeticao {

    public void t1() {
        Set<Integer> numeros = new TreeSet<Integer>();
        Random rand = new Random();
        //Vamos sortear 20 números de 0 até 100 sem repetição
        while (numeros.size() < 10) {
            numeros.add(rand.nextInt(41));
        }
        System.out.println("Números gerados: " + numeros);
    }

    public void t2() {
        int numero;
        int[] num = new int[6];
        Random r = new Random();
        for (int i = 0; i < num.length; i++) {
            numero = r.nextInt(13) + 1;
            for (int j = 0; j < num.length; j++) {
                if (numero == num[j] && j != i) {
                    numero = r.nextInt(13) + 1;
                } else {
                    num[i] = numero;
                }
            }
        }
        //Apresentar na tela o resultado
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + "  ");
        }
    }

    public void t3() {
        //FUNCIONAL
        int quantidade = 18;
        int[] dezenas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};
//        for (int i = 0; i < dezenas.length; i++) {
//            dezenas[i] = i;
//        }
        Random r = new Random();
        System.out.print("Quantidade a serem sorteados: " + quantidade + "\nMenor/maior número possivél a ser sorteado: 0/" + dezenas.length + "\nNúmeros sorteados: ");
        for (int j = 0; j < quantidade; j++) {
            int aux = dezenas[j];
            int k = j + r.nextInt(dezenas.length - j);
            dezenas[j] = dezenas[k];
            dezenas[k] = aux;
            System.out.print(dezenas[j] + ",");
        }
        System.out.println();
    }

    int[] dezenas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    int quantidade_jogadores = 6;
    int quantidade_cartas = 3;  // QUANTIDADE DE CARTAS PARA CADA JOGADOR
    String[][][] auxiliar = new String[quantidade_jogadores][quantidade_cartas][2];
    String[] nome_carta = {
        "4 de Ouros", "4 de Espadas", "4 de Copas", "4 de Paus",
        "5 de Ouros", "5 de Espadas", "5 de Copas", "5 de Paus",
        "6 de Ouros", "6 de Espadas", "6 de Copas", "6 de Paus",
        "7 de Ouros", "7 de Espadas", "7 de Copas", "7 de Paus",
        "Q de Ouros", "Q de Espadas", "Q de Copas", "Q de Paus",
        "J de Ouros", "J de Espadas", "J de Copas", "J de Paus",
        "K de Ouros", "K de Espadas", "K de Copas", "K de Paus",
        "A de Ouros", "A de Espadas", "A de Copas", "A de Paus",
        "2 de Ouros", "2 de Espadas", "2 de Copas", "2 de Paus",
        "3 de Ouros", "3 de Espadas", "3 de Copas", "3 de Paus"};

    public void escolhendoCartas() {
        Random r = new Random();
        for (int j = 0; j < quantidade_jogadores; j++) {
            System.out.println("------- Jogador: " + Integer.toString(j + 1) + " -------");
            for (int c = 0; c < quantidade_cartas; c++) {
                int aux = dezenas[c];
                int k = c + r.nextInt(dezenas.length - c);
                dezenas[c] = dezenas[k];
                dezenas[k] = aux;

                auxiliar[j][c][0] = nome_carta[dezenas[c]];
                auxiliar[j][c][1] = Integer.toString(dezenas[c]);
                System.out.println(auxiliar[j][c][0] + " | " + auxiliar[j][c][1]);
            }
        }
        for (int x = 0; x < dezenas.length; x++) {
            System.out.print(dezenas[x] + ",");
        }
    }

    int[] array = new int[20];

    public void t4() {

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
//            System.out.print(array[i] + ",");
        }
//        System.out.println();
        shuffle(array); //Embaralha o array
        int nu = 0;
        for (int j = 0; j < 2; j++) {
            System.out.println();
            for (int i = 0; i < 5; i++) {
                //System.out.print(array[i] + ",");
                System.out.print(array[nu] + ",");
                nu++;
            }
        }
    }

    public static void shuffle(int[] array) {
        int i = array.length - 1;
        Random random = new Random();
        while (i > 0) {
            int index = random.nextInt(i);
            array[index] ^= array[i];
            array[i] ^= array[index];
            array[index] ^= array[i];
            i--;
        }
    }

    public void t5() {
        int i = 1;
        i ^= 10;
        System.out.println(i);
    }

    public void t6() {
        t4();
        for (int j = 0; j < 2; j++) {
            System.out.println("------- Jogador: " + Integer.toString(j + 1) + " -------");
            for (int c = 0; c < quantidade_cartas; c++) {
                auxiliar[j][c][0] = "" + array[(c + 1) * (j + 1)];
                //auxiliar[j][c][1] = Integer.toString(array[random[j][c]]);
                System.out.println(auxiliar[j][c][0]);
            }
        }
    }

    public void t7() {
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i;
        }
        int x = numeros.length - 1;
        Random r = new Random();
        while (x > 0) {
            int rn = r.nextInt(x);
            numeros[rn] = numeros[x];
            numeros[x] = numeros[rn];
            numeros[rn] = numeros[x];
            x--;
        }
        for (int z = 0; z < numeros.length; z++) {
            System.out.print(numeros[z] + ",");
        }
    }

    public static void main(String[] args) {
        new NumeroAleatoriosSemRepeticao().t7();
    }
}
