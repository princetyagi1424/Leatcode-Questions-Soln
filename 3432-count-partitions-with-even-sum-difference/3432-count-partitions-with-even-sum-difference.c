int countPartitions(int* nums, int numsSize) {
    int count=0;
        int first=0;
        int total=0;
        for(int i=0;i<numsSize;i++){
            total+=nums[i];
        }
        for(int i=0;i<numsSize-1;i++){
            first+=nums[i];
            int second=total-first;
            if((first-second)%2==0){
                count++;
            }
        }
        return count;
}