class Solution {
    public int averageValue(int[] nums) {
        int count=0;
        int sum=0;
        for(int num: nums){
            if(num%6==0){
                sum+= num;
                count++;
            }
        }
        if(count==0){
            return 0;
        }
        return sum/count;
    }
}