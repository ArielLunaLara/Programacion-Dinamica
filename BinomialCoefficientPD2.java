public class BinomialCoefficientPD2{

    // Función para calcular el Coeficiente Binomial usando un arreglo unidimensional
    public static int binDP(int n, int k) {
        // Arreglo unidimensional para almacenar resultados intermedios
        int[] B = new int[k + 1];

        // B[0] siempre es 1 porque C(n, 0) = 1
        B[0] = 1;

        // Iterar sobre las filas de 1 a n
        for (int i = 1; i <= n; i++) {
            // Actualizar el arreglo de derecha a izquierda
            for (int j = Math.min(i, k); j > 0; j--) {
                B[j] = B[j] + B[j - 1];
            }
        }

        return B[k];
    }

    public static void main(String[] args) {
        // Casos de prueba con medición del tiempo
        int[] ns = {5, 10, 15, 20, 25}; // Valores de n
        int k = 2; // Valor fijo de k
    
        System.out.println("Resultados con k fijo (k = " + k + "):");
        for (int n : ns) {
            long startTime = System.nanoTime();
            int result = binDP(n, k);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("C(" + n + ", " + k + ") = " + result + " (Tiempo: " + duration + " nanosegundos)");
        }
    
        int nFixed = 10; // Valor fijo de n
        int[] ks = {2, 4, 6, 8, 10}; // Valores de k
    
        System.out.println("\nResultados con n fijo (n = " + nFixed + "):");
        for (int kVal : ks) {
            long startTime = System.nanoTime();
            int result = binDP(nFixed, kVal);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("C(" + nFixed + ", " + kVal + ") = " + result + " (Tiempo: " + duration + " nanosegundos)");
        }
    }
}
