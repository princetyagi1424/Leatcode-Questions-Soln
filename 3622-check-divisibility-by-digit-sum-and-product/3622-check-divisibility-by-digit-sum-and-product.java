class Solution {
    public boolean checkDivisibility(int n) {
        int ans=0,sum=0,multi=1,b=n;
        while(n!=0){
            int t=n%10;
            sum+=t;
            multi*=t;
            n/=10;
        }   
        ans=sum+multi;
        if(b%ans==0){
            return true;
        }else{
            return false;
        }
    }
}