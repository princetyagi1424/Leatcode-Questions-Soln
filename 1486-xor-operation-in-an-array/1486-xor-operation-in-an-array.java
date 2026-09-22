class Solution {
    public int xorOperation(int n, int start) {
        int ans=0;
        int j=start;
        for(int i=1;i<=n;i++){
            ans^=j;
            j+=2;
        }
        return ans;
    }
}