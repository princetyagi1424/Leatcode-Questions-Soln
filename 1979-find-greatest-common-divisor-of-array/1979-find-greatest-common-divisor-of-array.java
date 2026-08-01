class Solution {
    public int findGCD(int[] nums) {
        int min=10000,max=0,ans=0;
        for(int i=0;i<nums.length;i++){
            if(min>nums[i]){
                min=nums[i];
            }
            if(max<nums[i]){
                max=nums[i];
            }
        }
        for(int i=1;i<=min;i++){
            if(min%i==0 && max%i==0){
                ans=i;
            }
        }
        return ans;
    }
}