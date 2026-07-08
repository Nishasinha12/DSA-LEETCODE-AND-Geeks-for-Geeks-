class Solution {
    public boolean search(int[] nums, int target) {
    
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If mid element is the target
            if (nums[mid] == target) return true;

            // Handle duplicates: cannot determine sorted side
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // Left half is sorted
            if (nums[low] <=nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1; // Search left
                } else {
                    low = mid + 1;  // Search right
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;  // Search right
                } else {
                    high = mid - 1; // Search left
                }
            }
        }

        return false; // Not found
    }
}