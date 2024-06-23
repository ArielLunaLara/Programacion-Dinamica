import java.util.Random;

public class GraphUtils {

    // Función para generar una matriz de adyacencia aleatoria
    public static int[][] generateRandomAdjacencyMatrix(int n) {
        int[][] matrix = new int[n][n];
        Random rand = new Random();

        // Llenar la matriz con pesos aleatorios (por ejemplo, de 1 a 10)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    matrix[i][j] = rand.nextInt(10) + 1;
                } else {
                    matrix[i][j] = 0; // Peso 0 para la diagonal (sin bucles)
                }
            }
        }
        return matrix;
    }

    // Función para imprimir la matriz
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5; // Número de nodos
        int[][] adjacencyMatrix = generateRandomAdjacencyMatrix(n);

        System.out.println("Matriz de Adyacencia Aleatoria:");
        printMatrix(adjacencyMatrix);
    }
}
