// class Solution {
//     public int firstStableIndex(int[] nums, int k) {
//         int n = nums.length;
//         int prefixMax[] = new int[n];
//         int suffixMin[] = new int[n];

//         suffixMin[n-1] = nums[n-1];
//         for(int i = n-2; i>=0; i--){
//             suffixMin[i] = Math.min(suffixMin[i+1], nums[i]);
//         } 
//         prefixMax[0] = nums[0];
//         for(int i = 1; i<n; i++){
//             prefixMax[i] = Math.max(prefixMax[i-1], nums[i]);
            
//         } 

//         for(int i = 0; i<n; i++){
//             if(prefixMax[i] - suffixMin[i] <= k) return i;
//         }
//         return -1;
//     }
// }

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int minR[]=new int[n];

        int curr=(int)1e9;
        for(int i=n-1;i>=0;i--){
            curr=Math.min(curr,nums[i]);
            minR[i]=curr;
        }

        int maxi=-(int)1e9;
        for(int i=0;i<n;i++){
             maxi=Math.max(maxi,nums[i]);
            int mini=minR[i];
            if(maxi-mini <= k) return i;
            
        }

        return -1;
    }
}