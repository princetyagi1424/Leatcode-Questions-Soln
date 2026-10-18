class Solution {
    public double myPow(double x, int n) {
        long N=n;
        double ans=pow(x, Math.abs(N));
        if (N <0) {
            return 1.0 / ans;
        }
        return ans;
    }
    public static double pow(double x,long n){
        if(n==0){
            return 1.0;
        }
        double half=pow(x,n/2);
        if(n%2==0){
            return half*half;
        }
        return half*half*x;
    }
}