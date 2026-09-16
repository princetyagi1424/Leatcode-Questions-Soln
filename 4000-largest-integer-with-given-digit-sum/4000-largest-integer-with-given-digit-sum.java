class Solution {
    public int largestInteger(int n, int s) {
        int ans=0;
        if(s==0){
            return ans;
        }else if(s>9*n){
            ans=-1;
        }else{
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < n; i++) {
                int digit = Math.min(9, s);
                str.append(digit);
                s -= digit;
            }
            ans = Integer.parseInt(str.toString());
        }
        return ans;
    }
}