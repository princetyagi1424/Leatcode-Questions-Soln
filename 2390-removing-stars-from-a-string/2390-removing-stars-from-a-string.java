class Solution {
    public String removeStars(String s) {
        StringBuilder sb=new StringBuilder();
        int j=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}