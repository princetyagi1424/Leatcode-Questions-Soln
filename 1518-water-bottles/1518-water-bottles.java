class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int a=numBottles;
        int b=numExchange;
        int ans=0;
        while(a>=b){
            int c=a / b;
            int d=a % b;
            ans+=c*b;
            a=c+d;
        }
        ans+=a;
        return ans;
    }
}