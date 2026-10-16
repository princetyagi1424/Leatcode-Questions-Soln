class Solution {
    public int maxPower(String s) {
        return fun(s,1,1,1);
    }
    public static int fun(String a,int i,int count,int max){
        if(i==a.length()){
            return max;
        }
        if(a.charAt(i)==a.charAt(i-1)){
            count++;
        }else{
            count=1;
        }
        max=Math.max(max,count);
        return fun(a,i+1,count,max);
    }
}