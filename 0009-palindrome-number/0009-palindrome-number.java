class Solution {
    public boolean isPalindrome(int x) {
        int a,b=0,i;
         a=x;
         if(x<0){
            return false;
         }
        while(x!=0){
            i=x%10;
            b=b*10+i;
            x=x/10;
        }
        if(b==a){
            return true;
        }else{
            return false;
        }
    }
}