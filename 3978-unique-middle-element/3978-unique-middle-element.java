class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        boolean ans=true;
        int mid=(nums.length/2);
        int l=0,r=nums.length-1;
        while(l<mid){
            if(nums[l]==nums[mid] || nums[r]==nums[mid]){
                ans=false;
                break;
            }
            l++;
            r--;
        }
        return ans;
    }
}