public class FloydWarshall {

    // Función para implementar el algoritmo de Floyd-Warshall
    public static void floydWarshall(int[][] graph, int n) {
        int[][] dist = new int[n][n];
        int[][] next = new int[n][n];

        // Inicialización de las matrices de distancias y de los predecesores
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != 0 && i != j) {
                    next[i][j] = j + 1;
                } else {
                    next[i][j] = 0;
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
        GraphUtils.printMatrix(dist);

        System.out.println("Matriz de Predecesores:");
        GraphUtils.printMatrix(next);
    }

    public static void main(String[] args) {
        int n = 5; // Número de nodos
        int[][] graph = GraphUtils.generateRandomAdjacencyMatrix(n);

        System.out.println("Matriz de Adyacencia Inicial:");
        GraphUtils.printMatrix(graph);

        floydWarshall(graph, n);
    }
}
