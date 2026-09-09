class Solution {
    public long countCommas(long n) {
        long totalCommas = 0;
        long base = 1000;
        while (n >= base) {
            totalCommas += (n - base + 1);
            if (base > Long.MAX_VALUE / 1000) {
                break;
            }
            base *= 1000;
        }
        return totalCommas;
    }
}