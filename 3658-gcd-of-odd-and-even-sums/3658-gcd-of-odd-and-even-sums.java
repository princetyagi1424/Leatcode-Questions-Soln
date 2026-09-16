class Solution {
    public int gcdOfOddEvenSums(int n) {
        if(n==1){
            return 1;
        }
        int even=0,odd=0,ans=0;
        for(int i=1;i<n*2;i++){
            if(i%2==0){
                even+=i;
            }else{
                odd+=i;
            }
        }
        int gcd=0;
        for(int i=1;i<=even;i++){
            if(even%i==0 && odd%i==0){
                ans=i;
            }
            gcd=Math.max(gcd,ans);
        }
        return gcd;
    }
}