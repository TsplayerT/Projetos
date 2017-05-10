package testes;

public class MatrizTridimensional {

    public void matrizTridimensional() {
        int jogadores = 2;
        int cartas = 3;
        int caracteristicas = 4;

        String[][][] m = new String[jogadores][cartas][caracteristicas];
        for (int i = 0; i < jogadores; ++i) {
            System.out.println("\nJogador " + (i + 1));
            for (int j = 0; j < cartas; ++j) {
                m[i][j][0] = "Carta " + (j + 1);
                m[i][j][1] = "100 HP";
                m[i][j][2] = "175 ATK";
                m[i][j][3] = "350 DEF";
                for (int k = 0; k < caracteristicas; ++k) {
                    System.out.println(m[i][j][k]);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        new MatrizTridimensional().matrizTridimensional();
    }
}
