class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        for(int i=0;i<operations.length;i++){
            String s=operations[i];
            if(s.contains("++")){
                x++;
            }else{
                x--;
            }
        }
        return x;
    }
}