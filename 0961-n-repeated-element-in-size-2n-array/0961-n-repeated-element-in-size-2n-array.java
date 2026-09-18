class Solution {
    public int repeatedNTimes(int[] nums) {
        int freq[]=new int[10001];
        int n=nums.length/2;
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]==n){
                return i;
            }
        }
        return -1;
    }
}