class Solution {
    public int heightChecker(int[] heights) {
        int arr[]=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            arr[i]=heights[i];
        }
        for(int i=1;i<heights.length;i++){
            int key=heights[i];
            int j=i-1;
            while(j>=0 && heights[j]>key){
                heights[j+1]=heights[j];
                j--;
            }
            heights[j+1]=key;
        }
        int count=0;
        for(int i=0;i<heights.length;i++){
            if(arr[i]!=heights[i]){
                count++;
            }
        }
        return count;
    }
}