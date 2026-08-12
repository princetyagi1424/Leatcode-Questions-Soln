class Solution {
    public int[] sortArrayByParity(int[] nums) {
        for(int i=1;i<nums.length;i++){
            int key=nums[i];
            int j=i-1;
            if(key%2==0){
                while(j>=0 && nums[j]%2!=0){
                nums[j+1]=nums[j];
                j--;
            }
               nums[j+1]=key;
            }
        }
        return nums;
    }
}