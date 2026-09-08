class Solution {
    public long coloredCells(int n) {
        long ans=0;
        for(int i=0;i<n;i++){
            ans+=i;
        }
        return (4*ans)+1;
    }
}