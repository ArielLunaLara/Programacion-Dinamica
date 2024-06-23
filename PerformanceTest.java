public class PerformanceTest {

    public static void main(String[] args) {
        int[] sizes = {3, 5, 10}; // Tamaños de grafos para probar

        for (int n : sizes) {
            int[][] graph = GraphUtils.generateRandomAdjacencyMatrix(n);

            long startTime = System.currentTimeMillis();
            FloydWarshall.floydWarshall(graph, n);
            long endTime = System.currentTimeMillis();

            System.out.println("Tiempo para n = " + n + ": " + (endTime - startTime) + " ms");
        }
    }
}
