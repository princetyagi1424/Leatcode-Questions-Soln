class Solution {
    public boolean checkIfExist(int[] arr) {
        boolean ans=false;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i!=j){
                    if(arr[i]==(arr[j])*2 ){
                    ans=true;
                }
                }
            }
        }
        return ans;
    }
}