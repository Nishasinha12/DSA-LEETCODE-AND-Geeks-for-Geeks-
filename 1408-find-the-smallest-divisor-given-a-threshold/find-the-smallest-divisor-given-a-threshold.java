class Solution {
     private int sumByD(int[] arr, int div) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.ceil((double) num / div);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
         if (nums.length >threshold) return -1;

        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sumByD(nums, mid) <= threshold) {
                high = mid - 1; // Try smaller divisor
            } else {
                low = mid + 1;  // Try larger divisor
            }
        }

        return low;
        
    }
}