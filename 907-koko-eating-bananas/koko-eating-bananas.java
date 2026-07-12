import java.util.Arrays;

class Solution {
    private long calculateTotalHours(int[] piles, int speed) {
        long totalH = 0; // Changed to long to prevent overflow
        for (int bananas : piles) {
            // Safe integer ceiling division: ceil(a / b) = (a + b - 1) / b
            totalH += (bananas + speed - 1) / speed;
        }
        return totalH;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();

        int low = 1, high = maxPile;
        int ans = maxPile;

        while (low <= high) {
            // Prevent potential low + high overflow
            int mid = low + (high - low) / 2;
            long totalH = calculateTotalHours(piles, mid);

            if (totalH <= h) {
                ans = mid;
                high = mid - 1; // Try to find a slower speed
            } else {
                low = mid + 1;  // Need a faster speed
            }
        }
        return ans;
    }
}