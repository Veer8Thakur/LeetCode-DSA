// class Solution {
//     public boolean uniformArray(int[] nums1) {
//         int n = nums1.length;
//         int min = Integer.MAX_VALUE;
//         int even = 0;
//         for(int num: nums1){
//             min = Math.min(min, num); 
//             if(num%2 == 0) even++;
//         }

//         if(min%2 == 1 || even == n) return true; // True is when if min = odd or all no. are even
//         return false;
//     }
// }

class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=Integer.MAX_VALUE;
        for(int num:nums1)
            {
                min=Math.min(min,num);
            }
        if(min%2==1) //If smallest is odd,then always possible
            return true;
        for(int num:nums1)
            {
                if(num%2!=0) //If smallest is even,then all are already even
                    return false;
            }
        return true;
    }
}