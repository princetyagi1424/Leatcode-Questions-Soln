class Solution {
    public int minMoves(int[] nums) {
        int ans=0;
        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
        }
        for(int num:nums){
            int a=max-num;
            ans+=Math.abs(a);
        }
        return ans;
    }
}