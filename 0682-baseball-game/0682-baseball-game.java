class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer>st=new Stack<>();
        for(String a:operations){
            if(a.equals("C")){
                st.pop();
            }else if(a.equals("D")){
                st.push(st.peek()*2);
        }else if(a.equals("+")){
            int last=st.pop();
            int slast=st.peek();
            st.push(last);
            st.push(last+slast);
        }else{
            st.push(Integer.parseInt(a));
        }
        }
        int ans=0;
        for(int i:st){
            ans+=i;
        }
        return ans;
            }
}