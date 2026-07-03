class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. Use a List of int[] to dynamically hold merged intervals
        List<int[]> merged = new ArrayList<>();

        // 3. Traverse through all intervals
        for (int[] interval : intervals) {
            // If merged list is empty or no overlap
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                // Add current interval as a new block
                merged.add(interval);
            } else {
                // Overlapping: update the end of the last merged interval
                int[] lastInterval = merged.get(merged.size() - 1);
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            }
        }

        // 4. Convert the List back to a 2D array for the return type
        return merged.toArray(new int[merged.size()][]);
    }
}