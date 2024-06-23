public class BinomialCoefficient {

    // Función recursiva para calcular el Coeficiente Binomial usando Divide y Vencerás
    public static int bin(int n, int k) {
        if (k == 0 || n == k)
            return 1;
        else
            return bin(n - 1, k - 1) + bin(n - 1, k);
    }

    public static void main(String[] args) {
        // Casos de prueba
        int[] ns = {5, 10, 15, 20, 25}; // Valores de n
        int k = 2; // Valor fijo de k

        System.out.println("Resultados con k fijo (k = " + k + "):");
        for (int n : ns) {
            long startTime = System.nanoTime();
            int result = bin(n, k);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("C(" + n + ", " + k + ") = " + result + " (Tiempo: " + duration + " nanosegundos)");
        }

        int nFixed = 10; // Valor fijo de n
        int[] ks = {2, 4, 6, 8, 10}; // Valores de k

        System.out.println("\nResultados con n fijo (n = " + nFixed + "):");
        for (int kVal : ks) {
            long startTime = System.nanoTime();
            int result = bin(nFixed, kVal);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("C(" + nFixed + ", " + kVal + ") = " + result + " (Tiempo: " + duration + " nanosegundos)");
        }
    }
}
