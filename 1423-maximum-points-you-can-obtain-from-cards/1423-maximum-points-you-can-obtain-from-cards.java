class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        int n=cardPoints.length;
        for(int num:cardPoints){
            sum+=num;
        }
        if(n==k){
            return sum;
        }
        int winsum=0;
        int winsize=n-k;
        for(int i=0;i<winsize;i++){
            winsum+=cardPoints[i];
        }
         int minScore=winsum;
        for(int i=winsize;i<cardPoints.length;i++){
            winsum+=cardPoints[i];
            winsum-=cardPoints[i-winsize];
            minScore=Math.min(minScore,winsum);
        }
        return sum-minScore;
    }
}