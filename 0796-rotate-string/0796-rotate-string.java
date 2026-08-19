class Solution {
    public boolean rotateString(String s, String goal) {
        String p=s+s;
        return s.length()==goal.length() &&  p.contains(goal);
    }
}