class Solution {
    public int[][] imageSmoother(int[][] img) {

        int rows = img.length;
        int cols = img[0].length;

        int[][] ans = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                int sum = 0;
                int count = 0;

                for (int x = i - 1; x <= i + 1; x++) {

                    for (int y = j - 1; y <= j + 1; y++) {

                        if (x >= 0 && x < rows && y >= 0 && y < cols) {
                            sum += img[x][y];
                            count++;
                        }
                    }
                }

                ans[i][j] = sum / count;
            }
        }

        return ans;
    }
}