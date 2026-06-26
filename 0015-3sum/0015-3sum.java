class Solution {
     public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> results = new ArrayList<>();
        sort(nums);

        int n = nums.length;
        for (int i = 0; i < n; i++){
            if (i != 0 && nums[i] == nums[i-1]) continue;
            if (nums[i] > 0) break;

            int j = i+1;
            int k = n-1;

            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;
                } else if (sum > 0){
                    k--;
                } else {
                    results.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    while (j < k && nums[j] == nums[j-1]) j++;                }
            }
        }
        return results;
    }

    int[] aux;
    private void sort(int[] arr) {
        aux = new int[arr.length];
        sort(arr, 0, arr.length);
    }

    private void sort(int[] arr, int low, int high) {
        if (low+1 < high) {
            int mid = low + (high-low)/2;

            sort(arr, low, mid);
            sort(arr, mid, high);

            merge(arr, low, high);
        }
    }

    private void merge(int[] arr, int low, int high) {
        int l = low, mid = low + (high-low)/2, m = mid, n = high-low;

        for (int i = 0; i < n; i++) {
            if (l == mid) {
                aux[i] = arr[m++];
            } else if (m == high) {
                aux[i] = arr[l++];
            } else if (arr[l] <= arr[m]) {
                aux[i] = arr[l++];
            } else {
                aux[i] = arr[m++];
            }
        }

        for (int i = 0; i < n; i++) {
            arr[low+i] = aux[i];
        }   
    }
}