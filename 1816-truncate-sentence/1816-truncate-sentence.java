class Solution {
    public String truncateSentence(String s, int k) {
        String []a=s.split(" ");
        String ans="";
        for(int i=0;i<k;i++){
            ans=ans+" "+a[i];
        }
        return ans.trim();
    }
}