import java.util.*;

class Solution {
    class Bucket {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int size = 0;
        long sum = 0;

        void add(int val) {
            map.merge(val,1,Integer::sum);
            size++;
            sum += val;
        }

        void remove(int val) {
            map.merge(val,-1,Integer::sum);
            if(map.get(val) == 0) map.remove(val);
            size--;
            sum -= val;
        }

        int first() {
            return map.firstKey();
        }

        int last() {
            return map.lastKey();
        }
    }

    Bucket low = new Bucket();
    Bucket high = new Bucket();

    void add(int val) {
        if(low.size == 0 || val <= low.last()) low.add(val);
        else high.add(val);
        balance();
    }

    void remove(int val) {
        if(low.map.containsKey(val)) low.remove(val);
        else high.remove(val);
        balance();
    }

    void balance() {
        while(low.size < high.size) {
            int val = high.first();
            high.remove(val);
            low.add(val);
        }

        while(low.size > high.size + 1) {
            int val = low.last();
            low.remove(val);
            high.add(val);
        }
    }

    long getCost() {
        long median = low.last();
        return median * low.size - low.sum
             + high.sum - median * high.size;
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];

        low = new Bucket();
        high = new Bucket();

        for(int i = 0; i < n; i++) {
            add(nums[i]);

            if(i >= x) remove(nums[i - x]);

            if(i >= x - 1) {
                cost[i - x + 1] = getCost();
            }
        }

        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];

        for(long[] row : dp) Arrays.fill(row, INF);

        dp[0][0] = 0;

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                if(dp[j][i] == INF) continue;

                if(i < n) {
                    dp[j][i + 1] = Math.min(
                        dp[j][i + 1], dp[j][i]
                    );
                }

                if(j < k && i + x <= n) {
                    dp[j + 1][i + x] = Math.min(
                        dp[j + 1][i + x],
                        dp[j][i] + cost[i]
                    );
                }
            }
        }

        return dp[k][n];
    }
}