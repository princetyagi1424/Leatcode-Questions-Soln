class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result=new ArrayList<>();
        int max=0;
        for(int a:candies){
            max=Math.max(max,a);
        }
        for(int a:candies){
            result.add(a+extraCandies>=max);
        }
        return result;
    }
}