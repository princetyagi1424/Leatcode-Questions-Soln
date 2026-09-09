class Solution {
    public int characterReplacement(String s, int k) {
        int freq[]=new int[26];
        int l=0,maxlength=0,maxfreq=0;
        for(int r=0;r<s.length();r++){
            int i=s.charAt(r)-'A';
            freq[i]++;
            maxfreq=Math.max(maxfreq,freq[i]);
            int replace=(r-l+1)-maxfreq;
            while(replace > k){
                int index=s.charAt(l)-'A';
                freq[index]--;
                l++;
                replace=(r-l+1)-maxfreq;
            }
            maxlength=Math.max(maxlength,r-l+1);
        }
        return maxlength;
    }
}