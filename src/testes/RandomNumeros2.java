package testes;

public class RandomNumeros2 {

    public static void main(String[] args) {
        int n = 10, x;
        int original[] = new int[n];
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            x = (int) Math.round(Math.random() * 100);
            original[i] = x;
            a[i] = x;
        }
        int i, j, menor, aux;
        for (i = 0; i < (n - 1); i++) {
            menor = i;
            for (j = (i + 1); j < n; j++) {
                if (a[j] < a[menor]) {
                    menor = j;
                }
                aux = a[i];
                a[i] = a[menor];
                a[menor] = aux;
            }
            System.out.println("v[i] = Original, Ordenado");
            System.out.println("--------------------------");
            for (i = 0; i < n; i++) {
                System.out.printf("v[%d] = %8d, %d\n", i, original[i], a[i]);
            }
        }
    }
}
