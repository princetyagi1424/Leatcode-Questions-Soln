class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> l = new ArrayList<>();
       fun("",0,0,n,l);  
       return l; 
    }
    void fun(String p,int open,int close,int n,List<String> l){
        if(open==n && close==n){
            l.add(p);
            return;
        }
        if(open<n){
            fun(p+"(",open+1,close,n,l);
        }
        if(close<open){
            fun(p+")",open,close+1,n,l);
        }
    }
}