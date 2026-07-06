class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        
        // 1. Find the FIRST position (Your exact logic)
        int first = -1; 
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target) first = mid; // Track if we actually hit the target
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // If the target wasn't even found, we can stop early and return [-1, -1]
        if (first == -1) {
            return new int[]{-1, -1};
        }

        // 2. Reset pointers to find the LAST position
        low = 0;
        high = n - 1;
        int last = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) last = mid; // Track if we hit the target
                low = mid + 1; // Since we want the LAST position, try to look right
            } else {
                high = mid - 1;
            }
        }

        // 3. Put both results directly into the required array format!
        return new int[]{first, last};
    
    }
}