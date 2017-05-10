package principal;

import java.util.Scanner;

public class Vetores {

    public void unidimensional() {
        int u[] = {1, 5, 7, 3, 2};
        for (int i = 0; i < u.length; i++) {
            System.out.printf((i + 1) + " linha: " + u[i]);
            System.out.printf("\n");
        }
    }

    public void bidimensional() {
        int n[][] = {{1, 2}, {3}, {4, 5, 6}};
        int linhas = 0;
        int colunas = 0;
        int total = 0;

        if (n.length > 0) {
            linhas = n.length;
            colunas = n[0].length;
        }
//encontrar o item com o maior numero de colunas        
        for (int i = 0; i < linhas; i++) {
            if (n[i].length > total) {
                total = n[i].length;
            }
        }
//Imprimir os valores existentes e quanto tiver a quantidade de colunas a mais imprimir 0 só para ilustração
        for (int i = 0; i < linhas; i++) {
            colunas = n[i].length;
            for (int j = 0; j < colunas; j++) {
                System.out.print(" " + n[i][j]);
            }
            if (total > colunas) {
                for (int d = 0; d < (total - colunas); d++) {
                    System.out.print(" 0");
                }
            }
            System.out.println();
        }

    }

    public void tridimensional() {
        int profundidade = 2;
        int altura = 3;
        int largura = 4;

        String[][][] m = new String[profundidade][altura][largura];
        for (int i = 0; i < profundidade; ++i) {
            for (int j = 0; j < altura; ++j) {
                for (int k = 0; k < largura; ++k) {
                    m[i][j][k] = "X = " + (i + 1) + " Y = " + (j + 1) + " Z = " + (k + 1);
                    System.out.println(m[i][j][k]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Vetores v = new Vetores();
        Scanner s = new Scanner(System.in);
        System.out.println("Qual escolhe? unidimensional = 1 ou bidimesional = 2 ou tridimensional = 3\n");
        int x = s.nextInt();
        if (x == 1) {
            v.unidimensional();
        } else if (x == 2) {
            v.bidimensional();
        } else if (x == 3) {
        v.tridimensional();
        }else{
            System.out.println("ERRO AO ESCOLHER!");
        }
    }
}
