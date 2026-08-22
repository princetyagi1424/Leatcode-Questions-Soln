class Solution {
    public boolean checkRecord(String s) {
        char[]ch=s.toCharArray();
        int p=0,l=0,a=0,b=0;
        for(int i=0;i<s.length();i++){
            if(ch[i]=='P'){
                p++;
                l=0;
            }else if(ch[i]=='A'){
                a++;
                l=0;
            }else {
                l++;
            }
            if(l>=3){
                b=3;
            }
        }
        if(a>=2 || b>2){
            return false;
        }else{
            return true;
        }
    }
}