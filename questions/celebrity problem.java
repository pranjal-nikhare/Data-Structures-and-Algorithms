class CelebrityProblem {
    public static int findCelebrity(int[][] matrix, int n) {
        int potentialCelebrity = 0; // Assume the first person as a potential celebrity

        // Find the potential celebrity
        for (int i = 1; i < n; i++) {
            if (matrix[potentialCelebrity][i] == 1) {
                potentialCelebrity = i;
            }
        }

        // Check if the potential celebrity is known by everyone and knows no one
        for (int i = 0; i < n; i++) {
            if (i != potentialCelebrity && (matrix[potentialCelebrity][i] == 1 || matrix[i][potentialCelebrity] == 0)) {
                return -1; // No celebrity found
            }
        }

        return potentialCelebrity; // Found the celebrity
    }

    public static void main(String[] args) {
        // Example usage
        int[][] matrix = {
            {0, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 0, 0, 0}
        };
        int n = 4;

        int celebrity = findCelebrity(matrix, n);
        if (celebrity != -1) {
            System.out.println("Celebrity found at index " + celebrity);
        } else {
            System.out.println("No celebrity found");
        }
    }
}
