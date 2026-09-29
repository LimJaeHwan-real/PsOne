public class SolutionTest {
    private static void assertEquals(int expected, int actual, String name) {
        if (expected != actual) {
            throw new AssertionError(
                name + ": expected " + expected + ", but was " + actual
            );
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        assertEquals(
            11,
            solution.solution(new int[][] {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
            }),
            "finds the shortest path"
        );

        assertEquals(
            -1,
            solution.solution(new int[][] {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
            }),
            "returns minus one when the destination is unreachable"
        );

        assertEquals(
            4,
            solution.solution(new int[][] {
                {1, 1, 1},
                {0, 0, 1}
            }),
            "supports rectangular maps"
        );
    }
}
