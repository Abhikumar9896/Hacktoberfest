import java.util.Arrays;

class M_Coloring {
    public boolean graphColoring(boolean graph[][], int m) {
        int n = graph.length;
        int[] colors = new int[n];
        return solve(0, graph, colors, m, n);
    }

    private static boolean solve(int v, boolean[][] graph, int[] colors, int m, int n) {
        if (v == n)
            return true;

        for (int c = 1; c <= m; c++) {
            if (isValid(v, c, graph, colors)) {
                colors[v] = c;
                if (solve(v + 1, graph, colors, m, n))
                    return true;
                colors[v] = 0;
            }
        }
        return false;
    }

    private static boolean isValid(int v, int c, boolean[][] graph, int[] colors) {
        for (int i = 0; i < colors.length; i++) {
            if (i != v && graph[v][i] && colors[i] == c)
                return false;
        }
        return true;
    }
}
