class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int freq[]=new int[n*n+1];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                freq[grid[i][j]]++;
            }
        }
        int repeat=-1, miss=-1;
        for(int i=0;i<=n*n;i++){
            if(freq[i]==2){
                repeat=i;
            }
            if(freq[i]==0){
                miss=i;
            }
        }
        return new int[]{repeat,miss};

        
    }
}