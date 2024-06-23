public class BinomialCoefficientDP {

    // Función para calcular el Coeficiente Binomial usando un arreglo unidimensional
    public static int bin2(int n, int k) {
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

        // El resultado está en B[k]
        return B[k];
    }

    public static void main(String[] args) {
        // Parte de pruebas para verificar el funcionamiento del algoritmo

        // Caso de prueba 1: C(6, 4)
        int n1 = 6, k1 = 4;
        int result1 = bin2(n1, k1);
        System.out.println("C(" + n1 + ", " + k1 + ") = " + result1);

        // Caso de prueba 2: C(8, 3)
        int n2 = 8, k2 = 3;
        int result2 = bin2(n2, k2);
        System.out.println("C(" + n2 + ", " + k2 + ") = " + result2);
    }
}
