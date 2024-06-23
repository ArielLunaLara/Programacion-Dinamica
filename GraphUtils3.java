import java.util.Arrays;

public class GraphUtils3 {

    static final int INF = 99999; // Un valor grande que representa infinito

    // Función para imprimir la matriz
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                if (val == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(val + "\t");
                }
            }
            System.out.println();
        }
    }

    // Implementación del algoritmo de Floyd-Warshall
    public static void floydWarshall(int[][] graph, int n) {
        int[][] dist = new int[n][n];
        int[][] next = new int[n][n];

        // Inicialización de las matrices de distancias y de los predecesores
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    next[i][j] = j;
                } else {
                    next[i][j] = -1;
                }
            }
        }

        // Algoritmo de Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        // Imprimir resultados
        System.out.println("Matriz de Distancias Mínimas:");
        printMatrix(dist);

        System.out.println("Matriz de Predecesores:");
        printMatrix(next);
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 3, INF, INF, INF, INF},
            {INF, 0, 1, INF, INF, INF},
            {INF, INF, 0, 7, INF, 2},
            {INF, INF, INF, 0, 1, INF},
            {INF, INF, INF, INF, 0, 3},
            {INF, INF, INF, INF, INF, 0}
        };
        int n = graph.length;

        floydWarshall(graph, n);
    }
}
