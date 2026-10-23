// import java.util.List;
// class Solution {
//     public boolean isAcronym(List<String> words, String s) {
//         if(words.size()!=s.length()){return false;}
//         for(int i=0;i<words.size();i++){
//             if(words.get(i).charAt(0)!=s.charAt(i)){
//                 return false;
//             }
//         }
//         return true;
//     }
// }
import java.util.List;
class Solution {
    public boolean isAcronym(List<String> words, String s) {
        if(words.size()!=s.length()){
            return false;
        }
        return check(words,s,0);
    }
    private boolean check(List<String> words,String s,int i){
        if(i==words.size()){
            return true;
        }
        if(words.get(i).charAt(0)!=s.charAt(i)){
                return false;
        }
        return check(words,s,i+1);
    }
}