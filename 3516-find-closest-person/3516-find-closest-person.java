class Solution {
    public int findClosest(int x, int y, int z) {
        int a=Math.abs(x-z);
        int b=Math.abs(y-z);
        if(a==b){
            return 0;
        }
        int c=Math.min(a,b);
        if(c==a){
            return 1;
        }else{
            return 2;
        }
    }
}