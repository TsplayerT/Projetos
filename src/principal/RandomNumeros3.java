package principal;

import java.util.Random;

public class RandomNumeros3 {

    public static void main(String[] args) {
        
        Random r = new Random();
        
        int n = 4;
        int c = 1;
        int x;
        String vetor[] = {"A","B","C","D","E","F","G"};
        int original[] = new int[n];
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            x = r.nextInt(vetor.length);
            original[i] = x;
            a[i] = x;
            System.out.print(vetor[x]);
            if(c < n){
                c++;
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
