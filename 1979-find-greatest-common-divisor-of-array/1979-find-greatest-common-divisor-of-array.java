class Solution {
    public int findGCD(int[] nums) {
        int min=nums[0],max=nums[0];
        for(int i=0;i<nums.length;i++){
            if(min>nums[i]){
                min=nums[i];
            }else if(max<nums[i]){
                max=nums[i];
            }
        }
        while(max!=0){
            int temp=max;
            max=min%max;
            min=temp;
        }
        return min;
    }
}