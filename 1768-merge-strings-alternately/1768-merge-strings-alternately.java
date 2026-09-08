class Solution {
    public String mergeAlternately(String word1, String word2) {
        char c[]=word1.toCharArray();
        char b[]=word2.toCharArray();
        String ans="";
        int n=word1.length()+word2.length();
        for(int i=0;i<n;i++){
            if(word1.length()>i){
                ans+=c[i];
            }
            if(word2.length()>i){
                ans+=b[i];
            }
        }
        return ans;
    }
}