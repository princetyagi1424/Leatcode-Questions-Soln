class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length+nums2.length;
        int arr[]=new int[n];
        int a=0;
        for(int i=0;i<nums1.length;i++){
            arr[a]=nums1[i];
            a++;
        }
        for(int i=0;i<nums2.length;i++){
            arr[a]=nums2[i];
            a++;
        }
        Arrays.sort(arr);
        if(n%2==1){
            return arr[n/2];
        }else{
            return (arr[n/2]+arr[n/2-1])/2.0;
        }
    }
}