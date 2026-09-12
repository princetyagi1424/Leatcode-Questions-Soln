class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List <Integer> list=new ArrayList<>();
        for(int n=left;n<=right;n++){
            boolean ans=true;
            int i=n;
            while(i!=0){
                int digit=i%10;
                if(digit==0 || n%digit!=0){
                    ans=false;
                    break;
                }
                i/=10;
            }
            if(ans){
                list.add(n);
            }
        }
        return list;
    }
}