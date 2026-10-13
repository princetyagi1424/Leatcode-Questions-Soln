class Solution {
    public long sumAndMultiply(int n) {
        long ans=0;
        long multi=0;
        long sum=0;
        long a=1;
        while(n!=0){
            long d=n%10;
            if(d!=0){
                ans+=(d*a);
                a*=10;
            }
            sum+=d;
            n/=10;
        }
        return sum*ans;
    }
}