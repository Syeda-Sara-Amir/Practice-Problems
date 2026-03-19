// QUESTION: Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
// You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
// Return the answer with the smaller index first.

// Constraints:
// 2 <= nums.length <= 1000
// -10,000,000 <= nums[i] <= 10,000,000
// -10,000,000 <= target <= 10,000,000
// Only one valid answer exists.

class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] values = new int[2];

        // ================= BRUTEFORCE SOLUTION ========================== //
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    values[0] = i;
                    values[1] = j;
                }
            }
        }
        // Time Complexity: O(n squared)
        // Space Complexity: O(1)
        return values;


        // ==================== MOST EFFICIENT WAY ====================== //
        HashMap<Integer, Integer> checked = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (checked.containsKey(remaining)) {
                values[0] = checked.get(remaining);
                values[1] = i;
                return values;
            } else {
                checked.put(nums[i], i);
            }
        }
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        return values;


        // =================== TWO POINTER APPROACH =============== //

        // We make a 2D array to preserve original indices after sorting.
        // ascending[i][0] = value, ascending[i][1] = original index
        int[][] ascending = new int[nums.length][2];  
        for (int i = 0; i < nums.length; i++) {
            ascending[i][0] = nums[i];
            ascending[i][1] = i;
        }
        Arrays.sort(ascending, (a, b) -> a[0] - b[0]); 

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int cur = ascending[i][0] + ascending[j][0];
            if (cur == target) {
                values[0] = Math.min(ascending[i][1], ascending[j][1]); 
                values[1] = Math.max(ascending[i][1], ascending[j][1]); 
                return values;
            } else if (cur < target) {
                i++;
            } else {
                j--;  
            }
        }

        // Time Complexity: O(n log n)  — dominated by the sort step
        // Space Complexity: O(n)
        return values;
    }
}
